import java.time.LocalDate;
import java.util.*;

public class Main {
    static Map<Produs, List<Tranzactie>> stocuri = new HashMap<>();

    static void AdaugaProdus(int cod, String denumire) {
        var produs = new Produs(cod, denumire);
        if (stocuri.containsKey(produs)) {
            throw new IllegalArgumentException("Codul exista: " + produs);
        }
        stocuri.put(produs, new ArrayList<>());
    }

    static void AdaugaTranzactie(TipTranzactie tip, LocalDate data, int codProdus, int cantitate) {
        var produs = new Produs(codProdus);
        if (!stocuri.containsKey(produs)) {
            throw new IllegalArgumentException("Produsul nu exista - " + codProdus);
        }
        var lista = stocuri.get(produs);
        lista.add(new Tranzactie(tip, data, codProdus, cantitate));
    }

    static void AfisareStocuri() {
        for (var produs : stocuri.keySet()) {
            var lista = stocuri.get(produs);
            var cantitate = 0;
            for (var tranzactie : lista) {
                cantitate += tranzactie.getTip().semn() + tranzactie.getCantitate();
            }
            LocalDate data = null;
            if (!lista.isEmpty()) {
                data = Collections.max(lista, new Comparator<Tranzactie>() {
                    @Override
                    public int compare(Tranzactie o1, Tranzactie o2) {
                        return o1.getData().compareTo(o2.getData());
                    }
                }).getData();
            }
            System.out.printf("%2d %-10s %3d buc (ultima tranzactie: %s)%n",
                    produs.getCod(), produs.getDenumire(), cantitate, data);
        }
    }

    public static void main(String[] args) {
        var tip = TipTranzactie.IESIRE;
        if (tip == TipTranzactie.IESIRE) {
            System.out.println("Egale");
        }
        System.out.printf("%s - cu valoarea %d%n", tip, tip.semn());

        var mere = new Produs(1, "Mere");
        System.out.println(mere);
        if (mere.equals(new Produs(1))) {
            System.out.printf("%s este egal cu %s%n", mere, new Produs(1));
        }

        stocuri.put(
                new Produs (1, "Mere"),
                new ArrayList<>()
        );
        stocuri.get(new Produs(1))
                        .add(new Tranzactie(
                                TipTranzactie.INTRARE,
                                LocalDate.of(2024,3,1),
                                1,
                                7));
        System.out.println(stocuri);

        // AdaugaProdus(1, "Mere");
        AdaugaProdus(2, "Pere");
        AdaugaProdus(3, "Cirese");

        System.out.println(stocuri);

        AdaugaTranzactie(TipTranzactie.INTRARE, LocalDate.of(2024, 3, 1), 1, 10);
        AdaugaTranzactie(TipTranzactie.INTRARE, LocalDate.of(2024, 3, 1), 2, 5);
        AdaugaTranzactie(TipTranzactie.IESIRE, LocalDate.of(2024, 3, 4), 1, 7);

        System.out.println(stocuri);

        AfisareStocuri();
    }
}

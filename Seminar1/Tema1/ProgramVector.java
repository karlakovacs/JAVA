public class ProgramVector {
    private static void afisare(int[] vector, String mesaj) {
        System.out.printf("%s (%d elemente): ", mesaj, vector.length);
        for (int valoare : vector) {
            System.out.print(valoare + " ");
        }
    }

    // TEMA: functie de inserare la inceputul vectorului
    static int[] inserare(int valoare, int[] vector) {
        // incrementarea dimensiunii vectorului
        int[] vectorNou = new int[vector.length + 1];
        // mutarea elementelor in noul vector
        for (int i = 0; i < vector.length; i++) {
            vectorNou[i + 1] = vector[i];
        }
        // inserarea la inceputul noului vector
        vectorNou[0] = valoare;
        // vector = vectorNou; // shallow copy
        // deep copy
        vector = new int[vectorNou.length];
        for (int i = 0; i < vectorNou.length; i++) vector[i] = vectorNou[i];
        return vector;
    }

    public static void main(String[] args) {
        var valori = args[0].split(",");
        var v = new int[valori.length];
        for (var i = 0; i < valori.length; i++) {
            v[i] = Integer.parseInt(valori[i]);
        }
        afisare(v, "Initial");
        v = inserare(13, v); // apelul
        afisare(v, "Dupa inserare");
    }
}

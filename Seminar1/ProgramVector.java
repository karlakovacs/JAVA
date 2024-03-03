public class ProgramVector {
    private static void afisare(int[] vector, String mesaj) {
        System.out.printf("%s (%d elemente): ", mesaj, vector.length);
        for (int valoare : vector) {
            System.out.print(valoare + " ");
        }
    }

    static void incrementare(int[] vector) {
        for (var i = 0; i < vector.length; i++) {
            int valoare = vector[i]; // facem o copie
            vector[i] = valoare + 1; // vector[i]++ sau vector[i] += 1
        }
    }

    public static void main(String[] args) {
        var valori = args[0].split(",");
        var v = new int[valori.length];
        for (var i = 0; i < valori.length; i++) {
            v[i] = Integer.parseInt(valori[i]);
        }
        afisare(v, "Initial");
        incrementare(v);
        afisare(v, "Dupa incrementare");
    }
}

// parametrul implicit este separat prin spatiu

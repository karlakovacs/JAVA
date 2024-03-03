import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Student[] citireStudenti() {
        var numarStudenti = Integer.parseInt(scanner.nextLine());
        var studenti = new Student[numarStudenti];
        for (var i = 0; i < numarStudenti; i++) {
            var linie = scanner.nextLine().split(",");
            var student = new Student(
                    Integer.parseInt(linie[0]),
                    linie[1],
                    linie[2],
                    Integer.parseInt(linie[3])
            );
            studenti[i] = student;
            linie = scanner.nextLine().split(",");
            for ( int j = 0; j < linie.length; j += 2) {
                var denumire = linie[j];
                var valoare = Integer.parseInt(linie[j + 1]);
                student.add(new Nota(denumire, valoare));
            }
        }
        return studenti;
    }

    static void afisare(Student[] studenti, String mesaj) {
        System.out.println(mesaj + "");
        for (var student : studenti) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(new Nota("Programare Java", 10));

        var ion = new Student(1, "Ion", "1001A", 3);
        System.out.println(ion);

        var studenti = citireStudenti();
        afisare(studenti, "Dupa citire");
    }
}

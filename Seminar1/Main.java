import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. de citit de la tastatura un nume (Popescu Ion) si dupa afisare Hello nume
        var scanner = new Scanner(System.in); // Scanner - trebuie sa ii spunem ce tip sa citeasca
        // var nume = scanner.next(); // un singur cuvant
        var nume = scanner.nextLine(); // o linie intreaga
        System.out.printf("Hello %s!%n", nume);

        // 2. de citit de la tastatura 2 numere si afisare suma
        System.out.print("a = ");
        int a = Integer.parseInt(scanner.nextLine()); // parseInt - metoda statica din clasa int-ului

        System.out.print("b = ");
        int b = scanner.nextInt();

        // nextLine intoarce totul pana la primul separator, nextInt citeste pana la urmatorul separator

        System.out.println(a);
        System.out.println(b);

        System.out.printf("%d + %d = %d%n", a, b, a + b);

        System.out.println(
                String.format("%d + %d = %d%n", a, b, a + b));
    }
}

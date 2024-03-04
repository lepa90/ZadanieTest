import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("dane.txt");
            Scanner scanner = new Scanner(file);

            // Wczytanie danych o drużynach
            String nazwaDruzynyA = scanner.nextLine();
            double wspolczynnikPredkosciA = Double.parseDouble(scanner.nextLine());

            String nazwaDruzynyB = scanner.nextLine();
            double wspolczynnikPredkosciB = Double.parseDouble(scanner.nextLine());

            // Wczytanie rozmiaru planszy
            int szerokoscPlanszy = Integer.parseInt(scanner.nextLine());
            int wysokoscPlanszy = Integer.parseInt(scanner.nextLine());

            
            // Obliczenie prędkości dla figur o parzystej współrzędnej x
            double vParzyste = 1 * wspolczynnikPredkosciA;

            // Obliczenie prędkości dla figur o nieparzystej współrzędnej x
            double vNieparzyste = Math.pow(2, wspolczynnikPredkosciB);

            // Jeśli figury zaczynają u góry planszy, przemnóż prędkość przez -1
            if (nazwaDruzynyA.equals("Góra")) {
                vParzyste *= -1;
                vNieparzyste *= -1;
            }
            char[][] plansza = new char[wysokoscPlanszy][szerokoscPlanszy];
            for (int i = 0; i < wysokoscPlanszy; i++) {
                for (int j = 0; j < szerokoscPlanszy; j++) {
                    plansza[i][j] = '.';
                }
            }
            int pozycjaDruzynyA = 0;
            int pozycjaDruzynyB = wysokoscPlanszy - 1;
            // Symulacja ruchu
            while (true) {
                if (pozycjaDruzynyA < wysokoscPlanszy && pozycjaDruzynyA >= 0) {
                    plansza[pozycjaDruzynyA][0] = 'A';
                }
                if (pozycjaDruzynyB < wysokoscPlanszy && pozycjaDruzynyB >= 0) {
                    plansza[pozycjaDruzynyB][szerokoscPlanszy - 1] = 'B';
                }
            
                pozycjaDruzynyA += vParzyste;
                pozycjaDruzynyB += vNieparzyste;
            
                if (pozycjaDruzynyA >= wysokoscPlanszy || pozycjaDruzynyB < 0) {
                    break;
                }
            }

            // Wyświetlenie wyników
            if (pozycjaDruzynyA >= wysokoscPlanszy) {
                System.out.println(nazwaDruzynyA);
            } else {
                System.out.println(nazwaDruzynyB);
            }
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }
}

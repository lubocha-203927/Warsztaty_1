package Gra_w_zgadywanie_liczb_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberOfTries = 0;
        int min = 0, max = 1000;
        int suspicion;
        Scanner scanner = new Scanner(System.in);
        String answer;

        System.out.println("Pomyśl liczbę z zakresu od 0 do 1000 a ja ją zgadnę w max 10 próbach");
        while (true) {
            numberOfTries++;
            suspicion = ((max - min) / 2) + min;
            System.out.println("Zgaduję: " + suspicion);


            while (true) {
                answer = scanner.nextLine();

                if(answer.equals("mniej")) {
                    max = suspicion;
                } else if (answer.equals("więcej")) {
                    min = suspicion;
                } else if (answer.equals("trafiłeś")) {
                    System.out.println("Wygrałem( liczba podejść: " + numberOfTries+").");
                    return;
                } else {
                    System.out.println("Nie oszukuj!");
                    continue;
                }
                break;
            }
        }
    }
}

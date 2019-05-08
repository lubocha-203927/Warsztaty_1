package Gra_w_zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zgadnij liczbę: ");

        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println("To nie jest liczba");
                scanner.next();
            }

            int userGivenNumber = scanner.nextInt();

            if (userGivenNumber < randomNumber) {
                System.out.println("Za mało!");
            } else if (userGivenNumber > randomNumber) {
                System.out.println("Za dużo!");
            } else {
                System.out.println("Zgadłeś!");
                break;
            }
        }
    }
}
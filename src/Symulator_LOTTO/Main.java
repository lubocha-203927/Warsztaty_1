package Symulator_LOTTO;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] randomNumbers = new int[6];
        int[] userNumbers = new int[6];
        int numberOfHits = 0;
        boolean notRepeated;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < userNumbers.length; i++) {
            while (true) {
                notRepeated = true;

                System.out.print("Podaj liczbę z zakresu 1-49: ");
                if (scanner.hasNextInt()) {
                    userNumbers[i] = scanner.nextInt();
                } else {
                    System.out.println("To nie jest liczba");
                    scanner.nextLine();
                    continue;
                }

                if (userNumbers[i] < 1 || userNumbers[i] > 49) {
                    System.out.println("Wprowadzona liczba nie mieści się w zakresie 1 - 49.");
                    continue;
                }

                for (int j = i - 1; j >= 0; j--) {
                    if (userNumbers[j] == userNumbers[i]) {
                        System.out.println("Wprowadzono drugi raz tą samą liczbę");
                        notRepeated = false;
                        break;
                    }
                }

                if (notRepeated) {
                    break;
                }
            }
        }

        Arrays.sort(userNumbers);
        System.out.println("Wprowadzone liczby: ");
        System.out.println(Arrays.toString(userNumbers));

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(49) + 1;
            for (int j = 0; j < i; j++) {
                if (randomNumbers[i] == randomNumbers[j]) {
                    i--;
                    break;
                }
            }
        }

        Arrays.sort(randomNumbers);
        System.out.println("Wylosowane liczby: ");
        System.out.println(Arrays.toString(randomNumbers));

        for (int i = 0; i < userNumbers.length; i++) {
            for (int j = 0; j < randomNumbers.length; j++) {
                if (userNumbers[i] == randomNumbers[j]) {
                    numberOfHits++;
                }
            }

        }

        System.out.println("Liczba trafień: " + numberOfHits);

        if (numberOfHits >= 3) {
            System.out.println("Gratulacje, trafiłeś: " + numberOfHits);
        } else {
            System.out.println("Tym razem się nie udało, liczba Twoich trafień: " + numberOfHits + ", zagraj jeszcze raz, szczęście sprzyja grającym.");
        }


    }

}

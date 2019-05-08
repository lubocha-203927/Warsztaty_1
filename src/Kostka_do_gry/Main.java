package Kostka_do_gry;

import java.util.Random;

public class Main {

    private static boolean contains(final int[] tab, final int key) {
        for (int elem : tab) {
            if (elem == key) {
                return true;
            }
        }
        return false;
    }

    private static int throwCubes(String throwCode) throws Exception {
        int numberOfThrows, numberOfWalls, modifier = 0, finalResult = 0;
        String[] buffer_arr;
        int[] typesOfCubes = {3, 4, 6, 8, 10, 12, 20, 100};
        Random random = new Random();

        if (!throwCode.matches("\\d*D\\d+([+-]\\d+)*")) {
            throw new Exception("Ciąg znaków nie pasuje do wzorca.");
        }

        buffer_arr = throwCode.split("D|[+-]");

        //ustalenie liczby rzutów
        if ("".equals(buffer_arr[0])) {
            numberOfThrows = 1;
        } else {
            numberOfThrows = Integer.parseInt(buffer_arr[0]);
        }

        //ustalenie liczby ścianek
        numberOfWalls = Integer.parseInt(buffer_arr[1]);

        //Sprawdzenie czy kosta o tylu ścianach istnieje
        if (!contains(typesOfCubes, numberOfWalls)) {
            throw new Exception("Nie istnieje kostka o podanej liczbie ścianek.");
        }

        //ustalenie modyfikatora
        if (throwCode.contains("+")) {
            modifier = Integer.parseInt(buffer_arr[2]);
        } else if (throwCode.contains("-")) {
            modifier = -1 * Integer.parseInt(buffer_arr[2]);
        }

        for (int i = 0; i < numberOfThrows; i++) {
            finalResult += random.nextInt(numberOfWalls) + 1;
        }

        return finalResult + modifier;

    }


    public static void main(String[] args) {

        try {
            System.out.println("Wynik dla 2D10+10: " +   throwCubes("2D10+10"));
            System.out.println("Wynik dla D6: " +   throwCubes("D6"));
            System.out.println("Wynik dla 2D3: " +   throwCubes("2D3"));
            System.out.println("Wynik dla D12-1: " +   throwCubes("D12-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

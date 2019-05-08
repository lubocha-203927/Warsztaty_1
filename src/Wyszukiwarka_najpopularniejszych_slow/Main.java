package Wyszukiwarka_najpopularniejszych_slow;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static void getPopularWords(String url) {
        Connection connect = Jsoup.connect(url);
        String[] words;

        try {
            FileWriter to_file = new FileWriter("popular_words.txt", true);

            Document document = connect.get();
            Elements links = document.select("span.title");

            for (Element elem : links) {
                words = elem.text().split(" ");

                for (String word : words) {
                    if (word.length() >= 3) {
                        to_file.write(word + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void filterFile(String fileName, String[] forbiddenWords) {
        String word;
        boolean toSave;

        try (Scanner from_file = new Scanner(new File(fileName));
             FileWriter to_file = new FileWriter("filtered_" + fileName, true)) {


            while (from_file.hasNext()) {
                word = from_file.next();
                toSave = true;

                for (String forbiddenWord : forbiddenWords) {
                    if (forbiddenWord.equals(word)) {
                        toSave = false;
                        break;
                    }
                }

                //jesli slowo nie jest zakazane
                if (toSave) {
                    to_file.write(word + "\n");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        getPopularWords("https://www.onet.pl/");

        filterFile("popular_words.txt", new String[]{"Znamy", "oraz", "ponieważ", "gdyż", "albo", "więc"});
    }
}

package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public List<String> findWordsInFile(File file, String keyword) {
        List<String> resultWords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\s+");
                for (String word : words) {

                    if (word.toLowerCase().contains(keyword.toLowerCase())) {
                        resultWords.add(word);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Loi khi đọc tệp: " + e.getMessage());
        }

        return resultWords;
    }

    public void displaySearchResult(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("Khong tim thay tu nao khop.");
        } else {
            for (String word : words) {
                System.out.println("Ket qua tim kiem: " + word);
            }
        }
    }
}
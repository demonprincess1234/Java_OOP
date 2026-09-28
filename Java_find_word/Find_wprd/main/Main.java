package main;

import java.io.File;
import java.util.List;
import service.FileService;
import validate.Validate;

public class Main {
    public static void main(String[] args) {

        File file = Validate.checkFileExist();

        String searchString = Validate.checkInputString();

        FileService fileService = new FileService();
        List<String> foundWords = fileService.findWordsInFile(file, searchString);
        fileService.displaySearchResult(foundWords);
    }
}
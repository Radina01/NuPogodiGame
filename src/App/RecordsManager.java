package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RecordsManager {
    List<String>names = readFileNames("nameRecords.txt");

    List<String> sortedNames = sortNames(names);

    public RecordsManager() throws FileNotFoundException {
    }

    // writeInFile("sortedNames.txt", sortedNames);
    public static List<String> readFileNames(String nameRecords) throws FileNotFoundException {
        File file = new File("nameRecords.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        List<String> names = new ArrayList<>();
        try {
            fileReader = new Scanner(file, StandardCharsets.UTF_8);
            while (fileReader.hasNextLine()) {
                names.add(fileReader.nextLine());
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            fileReader.close();
        }
        return names;

    }

    public static List<String> readFileResults(String resultRecords) throws FileNotFoundException {
        File file = new File("resultRecords.txt");
        Scanner fileReader = new Scanner(file, "windows-1251");
        List<String> results = new ArrayList<>();
        try {
            fileReader = new Scanner(file, StandardCharsets.UTF_8);
            while (fileReader.hasNextLine()) {
                results.add(fileReader.nextLine());
            }
        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            fileReader.close();
        }
        return results;
    }
    private static List<String> sortNames(List<String> results) {

        return results.stream().sorted().collect(Collectors.toList());

    }
}


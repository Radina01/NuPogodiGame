package App;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordsManager {

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

    public void writeInFile(String name) {
        try {
            FileWriter myWriter = new FileWriter("nameRecords.txt");
            myWriter.write(name);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


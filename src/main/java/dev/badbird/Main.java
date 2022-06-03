package dev.badbird;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import dev.badbird.object.DataEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final File IN_FILE = new File("data.csv");
    public static void main(String[] args) {
        try {
            List<DataEntry> data = new CsvToBeanBuilder<DataEntry>(new FileReader(IN_FILE))
                    .withType(DataEntry.class)
                    .build()
                    .parse();

            new PopulationParser(data).calculate();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

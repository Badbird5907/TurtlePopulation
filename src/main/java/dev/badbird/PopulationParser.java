package dev.badbird;

import com.opencsv.CSVWriter;
import dev.badbird.object.DataEntry;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PopulationParser {
    private Collection<DataEntry> data;
    public PopulationParser(Collection<DataEntry> data) {
        this.data = new ArrayList<>(data); // copy over so its mutable
    }

    public void calculate() {
        Map<Integer, Integer> count = new HashMap<>();

        int noDates = 0, total = 0;

        for (DataEntry entry : data) {
            String rawDate = entry.getDate_time();
            System.out.println("[Debug] Parsing date: " + rawDate);
            if (rawDate.isEmpty()) {
                noDates++;
                continue;
            }
            LocalDate date = LocalDate.parse(rawDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            int year = date.getYear();
            int counted = entry.getGroup_size();
            if (counted == 0) counted = 1; //since it's entered, we'll assume its one, even though the counted is not entered
            total += counted;
            if (count.containsKey(year)) {
                count.put(year, count.get(year) + counted);
            }else {
                count.put(year, counted);
            }
        }

        List<Pair<Integer, Integer>> sorted = new ArrayList<>();

        count.forEach((k,v)-> {
            sorted.add(new Pair<>(k, v));
        });

        sorted.sort(Comparator.comparing(Pair::getValue0));

        for (Pair<Integer, Integer> integerIntegerPair : sorted) {
            System.out.println("Year " + integerIntegerPair.getValue0() + ": " + integerIntegerPair.getValue1());
        }
        System.out.println("Counted: " + total);
        System.out.println("No dates: " + noDates);

        String[] header = {"year", "count", "", "Total: " + total, "No dates: " + noDates};
        List<String[]> rows = new ArrayList<>();
        rows.add(header);
        for (Pair<Integer, Integer> integerIntegerPair : sorted) {
            String[] row = {String.valueOf(integerIntegerPair.getValue0()), String.valueOf(integerIntegerPair.getValue1())};
            rows.add(row);
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
            writer.writeAll(rows);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Output written to output.csv");
    }
}

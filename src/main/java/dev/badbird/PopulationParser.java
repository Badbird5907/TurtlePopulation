package dev.badbird;

import dev.badbird.object.DataEntry;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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
        count.forEach((k,v)-> {
            System.out.println("Year " + k + ": " + v);
        });
        System.out.println("Counted: " + total);
        System.out.println("No dates: " + noDates);
    }
}

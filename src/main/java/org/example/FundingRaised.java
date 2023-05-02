package org.example;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FundingRaised {
    public List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<List<String>> csvData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(getClass().getResource("/startup_funding.csv").getPath()))) {
            while (scanner.hasNextLine()) {
                csvData.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        csvData.remove(0);

        if (options.containsKey("company_name")) {
            List<List<String>> results = new ArrayList<> ();

            for (int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i).get(1).equals(options.get("company_name"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("city")) {
            List<List<String>> results = new ArrayList<> ();

            for (int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i).get(4).equals(options.get("city"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("state")) {
            List<List<String>> results = new ArrayList<> ();

            for (int i = 0; i < csvData.size(); i++) {
                if(csvData.get(i).get(5).equals(options.get("state"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        if (options.containsKey("round")) {
            List<List<String>> results = new ArrayList<> ();

            for (int i = 0; i < csvData.size(); i++) {
                if (csvData.get(i).size() != 10) {
                    System.out.println("Error: " + i);
                }

                if(csvData.get(i).get(9).equals(options.get("round"))) {
                    results.add(csvData.get(i));
                }
            }
            csvData = results;
        }

        List<Map<String, String>> output = new ArrayList<>();

        for (int i = 0; i < csvData.size(); i++) {
            Map<String, String> mapped = new HashMap<> ();
            mapped.put("permalink", csvData.get(i).get(0));
            mapped.put("company_name", csvData.get(i).get(1));
            mapped.put("number_employees", csvData.get(i).get(2));
            mapped.put("category", csvData.get(i).get(3));
            mapped.put("city", csvData.get(i).get(4));
            mapped.put("state", csvData.get(i).get(5));
            mapped.put("funded_date", csvData.get(i).get(6));
            mapped.put("raised_amount", csvData.get(i).get(7));
            mapped.put("raised_currency", csvData.get(i).get(8));
            mapped.put("round", csvData.get(i).get(9));
            output.add(mapped);
        }

        return output;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<List<String>> csvData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(getClass().getResource("/startup_funding.csv").getPath()))) {
            while (scanner.hasNextLine()) {
                csvData.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        csvData.remove(0);

        Map<String, String> mapped = new HashMap<> ();

        for (int i = 0; i < csvData.size(); i++) {
            if (options.containsKey("company_name")) {
                if(csvData.get(i).get(1).equals(options.get("company_name"))) {
                    mapped.put("permalink", csvData.get(i).get(0));
                    mapped.put("company_name", csvData.get(i).get(1));
                    mapped.put("number_employees", csvData.get(i).get(2));
                    mapped.put("category", csvData.get(i).get(3));
                    mapped.put("city", csvData.get(i).get(4));
                    mapped.put("state", csvData.get(i).get(5));
                    mapped.put("funded_date", csvData.get(i).get(6));
                    mapped.put("raised_amount", csvData.get(i).get(7));
                    mapped.put("raised_currency", csvData.get(i).get(8));
                    mapped.put("round", csvData.get(i).get(9));
                } else {
                    continue;
                }
            }

            if (options.containsKey("city")) {
                if(csvData.get(i).get(4).equals(options.get("city"))) {
                    mapped.put("permalink", csvData.get(i).get(0));
                    mapped.put("company_name", csvData.get(i).get(1));
                    mapped.put("number_employees", csvData.get(i).get(2));
                    mapped.put("category", csvData.get(i).get(3));
                    mapped.put("city", csvData.get(i).get(4));
                    mapped.put("state", csvData.get(i).get(5));
                    mapped.put("funded_date", csvData.get(i).get(6));
                    mapped.put("raised_amount", csvData.get(i).get(7));
                    mapped.put("raised_currency", csvData.get(i).get(8));
                    mapped.put("round", csvData.get(i).get(9));
                } else {
                    continue;
                }
            }

            if (options.containsKey("state")) {
                if(csvData.get(i).get(5).equals(options.get("state"))) {
                    mapped.put("permalink", csvData.get(i).get(0));
                    mapped.put("company_name", csvData.get(i).get(1));
                    mapped.put("number_employees", csvData.get(i).get(2));
                    mapped.put("category", csvData.get(i).get(3));
                    mapped.put("city", csvData.get(i).get(4));
                    mapped.put("state", csvData.get(i).get(5));
                    mapped.put("funded_date", csvData.get(i).get(6));
                    mapped.put("raised_amount", csvData.get(i).get(7));
                    mapped.put("raised_currency", csvData.get(i).get(8));
                    mapped.put("round", csvData.get(i).get(9));
                } else {
                    continue;
                }
            }

            if (options.containsKey("round")) {
                if(csvData.get(i).get(9).equals(options.get("round"))) {
                    mapped.put("permalink", csvData.get(i).get(0));
                    mapped.put("company_name", csvData.get(i).get(1));
                    mapped.put("number_employees", csvData.get(i).get(2));
                    mapped.put("category", csvData.get(i).get(3));
                    mapped.put("city", csvData.get(i).get(4));
                    mapped.put("state", csvData.get(i).get(5));
                    mapped.put("funded_date", csvData.get(i).get(6));
                    mapped.put("raised_amount", csvData.get(i).get(7));
                    mapped.put("raised_currency", csvData.get(i).get(8));
                    mapped.put("round", csvData.get(i).get(9));
                } else {
                    continue;
                }
            }

            return mapped;
        }

        throw new NoSuchEntryException();
    }
}

class NoSuchEntryException extends Exception {}

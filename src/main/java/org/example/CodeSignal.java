package org.example;

import java.util.*;

public class CodeSignal {
    public static void main(String[] args) {
        String[][] queries = {
                {"ADD", "1"},
                {"ADD", "2"},
                {"ADD", "5"},
                {"ADD", "2"},
                {"EXISTS", "2"},
                {"EXISTS", "5"},
                {"EXISTS", "1"},
                {"EXISTS", "4"},
                {"EXISTS", "3"},
                {"EXISTS", "0"}
        };

        String[] solution = solution(queries);
        System.out.println(Arrays.toString(solution));
    }

    private static String[] solution(String[][] queries) {
        Set<Integer> container = new HashSet<>(); // Stores unique integer values
        List<String> result = new ArrayList<>();  // Stores the output results

        for (String[] query : queries) {
            String command = query[0];
            int value = Integer.parseInt(query[1]); // Convert string to integer

            if (command.equals("ADD")) {
                container.add(value); // Add to the set
                result.add("");       // Return empty string for "ADD"
            } else if (command.equals("EXISTS")) {
                result.add(String.valueOf(container.contains(value))); // Forces "true" and "false" as strings
            }
        }

        return result.toArray(new String[0]);
    }
}

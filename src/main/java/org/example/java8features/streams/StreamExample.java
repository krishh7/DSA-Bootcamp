package org.example.java8features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Transaction {
    private final String category;
    private final int amount;

    public Transaction(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
}
public class StreamExample {
    public static void main(String[] args) {
        List<Transaction> transactionList = Arrays.asList(
                new Transaction("Grocery", 5000),
                new Transaction("Entertainment", 10000),
                new Transaction("Utilities", 4000),
                new Transaction("Entertainment", 10000),
                new Transaction("Utilities", 4000),
                new Transaction("Grocery", 5000)
        );

        int sumOfEntertainment = transactionList.stream().filter(tx -> tx.getCategory().equals("Entertainment")).mapToInt(Transaction::getAmount).sum();
        System.out.println("Entertainment: " + sumOfEntertainment);

        int sumOfGrocery = transactionList.stream().filter(tx -> tx.getCategory().equals("Grocery")).mapToInt(Transaction::getAmount).sum();
        System.out.println("Grocery: " + sumOfGrocery);

        int sumOfUtilities = transactionList.stream().filter(tx -> tx.getCategory().equals("Utilities")).mapToInt(Transaction::getAmount).sum();
        transactionList.stream().filter(tx -> tx.getCategory().equals("Utilities")).mapToInt(Transaction::getAmount).forEach(System.out::println);
        System.out.println("Utilities: " + sumOfUtilities);

        double averageSum = transactionList.stream().mapToDouble(Transaction::getAmount).average().orElse(0.0);
        System.out.println(averageSum);
    }
}

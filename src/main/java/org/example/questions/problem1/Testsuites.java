package org.example.questions.problem1;

public class Testsuites {
    public static void main(String[] args) {
        String sample = "sequenceNumber^OrderNumber^Payload^OATUH^HEN^PING^CALL^DUTY^PUBG";

// Split the sample string by the caret (^) character
        String[] parts = sample.split("\\^");

// Remove the first element from the parts array
        String[] remainingParts = new String[parts.length - 1];
        System.arraycopy(parts, 2, remainingParts, 1, remainingParts.length);

// Join the remaining parts using the caret (^) delimiter
        String arrangedSample = String.join("^", remainingParts);

// Print the arranged sample
        System.out.println(arrangedSample);

    }




}

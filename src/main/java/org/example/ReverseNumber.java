package org.example;

/*
 * Find out reverse of a number
 */
public class ReverseNumber {
    public static void main(String[] args) {
        int number = 14325;
        int result = 0;
        System.out.println(number);

        while(number > 0) {
            int rem = number % 10;
            number = number/10;
            result = result*10 + rem;
        }
        System.out.println(result);
    }
}

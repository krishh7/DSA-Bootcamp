package org.example;

/*
 * Find out number of numbers in a whole number
 */
public class FindNumbers {
    public static void main(String[] args) {
        int number = 217534222;
        int count = 0;

        while(number > 0) {
            int rem = number % 10;
            if(rem == 2) {
                count++;
            }
            number = number/10;
        }
        System.out.println(count);
    }
}

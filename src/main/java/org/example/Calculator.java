package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int result = 0;

        while (true) {
            System.out.print("Enter operator : ");
            char op = scanner.next().trim().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op =='/' || op == '%') {
                System.out.print("Enter two numbers : ");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();

                if(op == '+')
                    result = num1 + num2;

                if(op == '-')
                    result = num1 - num2;

                if(op == '*')
                    result = num1 * num2;

                if(op == '/')
                    if(num2 != 0)
                        result = num1 / num2;


                if(op == '%')
                    result = num1 % num2;

            } else if (op == 'x' || op == 'X') {
                break;
            } else {
                System.out.println("Invalid operation");
            }
            System.out.println("Result is : " + result);
        }
    }
}

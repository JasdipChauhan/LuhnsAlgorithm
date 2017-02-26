package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your credit card number: ");
        String cardNumber = input.nextLine();

        String validity = isValidCreditCard(cardNumber) ? "valid" : "invalid";

        System.out.println("Your credit card is " + validity);

    }

    public static boolean isValidCreditCard(String cardNumber) {

        if (cardNumber.length() != 16) {
            System.out.println("Not a valid credit card, must be 16 digits long");
            return false;
        }

        int sumOfOddPlaces = 0;
        int sumofEvenPlaces = 0;

        for (int i = 1; i < cardNumber.length(); i += 2) {
            int digit = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
            sumOfOddPlaces += digit;
        }

        for (int i = 0; i < cardNumber.length(); i+= 2) {
            int digit = Integer.parseInt(String.valueOf(cardNumber.charAt(i)));
            digit *= 2;

            if (digit > 9) {
                sumofEvenPlaces += 1;
                sumofEvenPlaces += (digit %10);
            } else {
                sumofEvenPlaces += digit;
            }

        }

        int total = sumofEvenPlaces + sumOfOddPlaces;

        return total % 10 == 0;
    }
}

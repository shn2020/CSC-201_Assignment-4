/**
 * @assignment3: Chapter 7, Programming project 8
 * @author: Sang Nguyen (shn2020@vccs.edu)
 * @course: CSC 201(041N)
 * @instructor: Sabah Salin
 * @due: 11:59PM of May 27, 2016
 * @purpose: Create a program for password authentication
 * @language: Java
 */

import java.util.Scanner;

public class passwordDemo {
	private static int[] randomNum = new int[10];
	protected static int[] passwordPIN = new int[5];
	private static int[] responseNum = new int[5];
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		randomNum = generateRandomNumbers(randomNum);
		System.out.print("Enter your password as a five-digit number (00000 to 99999): ");
		int inputPassword = input.nextInt();
		passwordPIN = convertInttoArray(inputPassword);
		passwordAuthentication();
	}
	
	protected static void passwordAuthentication() {
		int attempt = 0;
		do {	
			attempt++;
			if (attempt > 1) System.out.println("Wrong authentication number");
			System.out.print("PIN: ");
			for (int i = 0; i < 10; i++ ) System.out.print(i + " ");
			System.out.println();
			System.out.print("NUM: ");
			for (int i = 0; i < randomNum.length; i++) System.out.print(randomNum[i] + " ");
			System.out.println();
			System.out.println("Please authenticate your password");
			System.out.print("Enter the random numbers that correspond to your PIN: ");
			int inputResponse = input.nextInt();
			responseNum = convertInttoArray(inputResponse);
			System.out.println("_________________________________");
		} while (!isCorrectPassword(passwordPIN,responseNum));
		
		System.out.println("Correct authentication number");
	}
	
	static int[] convertInttoArray(int num) {
		int[] array = new int[5];
		for (int i = 4; i >= 0; i--) {
			array[i] = num % 10;
			num = (int)(num/10);
		}
		return array;
	}
	
	static int[] generateRandomNumbers(int[] array) {
		for (int i = 0; i < array.length; i++) {
			do {
				array[i] = (int)(Math.random() * 4);
			} while (array[i] == 0);
		}
		return array;
	}
	
	static boolean isCorrectPassword(int[] array1, int[] array2) {
		for (int i = 0; i < array1.length; i++) {
			if (randomNum[array1[i]] != array2[i]) return false;
		}
		return true;
	}
}

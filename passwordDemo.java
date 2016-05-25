import java.util.Scanner;

public class passwordDemo {
	static int[] randomNum = new int[10];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] passwordPIN = new int[5];
		int[] responseNum = new int[5];
		randomNum = generateNUM(randomNum);
		
		System.out.print("Enter your password as a five-digit number (00000 to 99999): ");
		int inputPassword = input.nextInt();
		passwordPIN = convertInttoArray(inputPassword);
		
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
	
	public static int[] convertInttoArray(int num) {
		int[] array = new int[5];
		for (int i = 4; i >= 0; i--) {
			array[i] = num % 10;
			num = (int)(num/10);
		}
		return array;
	}
	
	public static int[] generateNUM(int[] array) {
		for (int i = 0; i < array.length; i++) {
			do {
				array[i] = (int)(Math.random() * 4);
			} while (array[i] == 0);
		}
		return array;
	}
	
	public static boolean isCorrectPassword(int[] array1, int[] array2) {
		for (int i = 0; i < array1.length; i++) {
			if (randomNum[array1[i]] != array2[i]) return false;
		}
		return true;
	}
}

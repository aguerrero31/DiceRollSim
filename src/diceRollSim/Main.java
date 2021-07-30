package diceRollSim;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> firstDie = new ArrayList<Integer>();
		ArrayList<Integer> secondDie = new ArrayList<Integer>();
		ArrayList<Integer> rolls = new ArrayList<Integer>(); // Holds combined rolls
		int[] numCount = new int[11]; // Holds the amount of times each number is rolled
		Scanner scanner = new Scanner(System.in);
		int rollCount = 0;
		
		//
		
		System.out.println("Welcome to the Dice Roll Simulator!");
		System.out.println("How many times do you wish to roll the dice?");
		rollCount = scanner.nextInt();
		scanner.nextLine(); // Flushing the scanner
		
		rollDie(firstDie, secondDie, rollCount);
		addRolls(firstDie, secondDie, rolls);
		countRolls(rolls, numCount);
		printRollRelativeFrequency(numCount, rollCount);
		
		scanner.close();

	}
	// Die1 ArrayList (empty), Die2 ArrayList (empty), Side Count (Lowest number of 2)
	private static void rollDie(ArrayList<Integer> firstD, ArrayList<Integer> secondD, int numOfRolls) {
		Random random = new Random();
		for (int i = 0; i < numOfRolls; i++) {
			firstD.add(random.nextInt(6) + 1);
			secondD.add(random.nextInt(6) + 1);
		}
	}
	// Die1 ArrayList, Die2 ArrayList, Combined Value ArrayList (empty)
	private static void addRolls(ArrayList<Integer> firstD, ArrayList<Integer> secondD, ArrayList<Integer> rollArray) {
		for (int i = 0; i < firstD.size(); i++) {
			rollArray.add(firstD.get(i) + secondD.get(i));
		}
	}
	// Combined Value ArrayList, Number Count Array(int)
	private static void countRolls(ArrayList<Integer> rollArray, int[] countList) {
		for (int i = 0; i < rollArray.size(); i++) {
			countList[rollArray.get(i) - 2] += 1;
		}
	}
	// Array (int)
	private static void relativeFrequency(int[] array) {
		int sum = 0;
		for (int num : array) {
			sum += num;
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = ((array[i] * 100) / sum);
		}
	}
	// Number Count Array (int), Number of Rolls 
	private static void printRollRelativeFrequency(int[] numCount, int numOfRolls) {
		System.out.print("--------------------------------- \n"
				+ "Simulation Results \n"
				+ "--------------------------------- \n"
				+ "Each [ * ] represents 1% of the total number of rolls \n"
				+ "Total number of rolls = " +  numOfRolls +  "\n");
		relativeFrequency(numCount);
		/*
		 * for (int num : numCount) { System.out.println(num); }
		 */
		for (int i = 0; i < numCount.length; i++) {
			System.out.print((i + 2) + ": ");
			for (int k = 0; k < numCount[i]; k++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}

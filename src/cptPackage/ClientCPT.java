package cptPackage;

import java.io.*;
import java.util.Scanner;

public class ClientCPT {
	
	private static int array[] = new int[3];
	private static int hours = 7;
	
	
	private static int [] read() throws FileNotFoundException {
		int x = 0;
		File text = new File("cpt.txt");
		Scanner input = new Scanner(text);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner linescan = new Scanner(line);
			while (linescan.hasNextInt()) {
				int lights = linescan.nextInt();
				array[x] = (lights);
				x++;
			}	
		}
		return(array);
	}
	
	private static double inUse(int[] unmodArray) {
		double localWatt = 0;
		localWatt = (unmodArray[0] * hours);
		return(localWatt);
	}
	
	private static double standby(int[] unmodArray) {
		double localWatt = 0;
		localWatt = (unmodArray[1] * hours);
		return(localWatt);
	}
	
	private static double off(int[] unmodArray) {
		double localWatt = 0;
		localWatt = (unmodArray[2] * hours);
		return(localWatt);
	}

	public static void main(String[] args) throws FileNotFoundException {
		int arrayClient[];
		final double GHG = 0.18;
		double inUseWattage = 0;
		double standbyWattage = 0;
		double offWattage = 0;
		double dayWattage = 0;
		double weekWattage = 0;
		
		arrayClient = read();
		inUseWattage = inUse(arrayClient);
		standbyWattage = standby(arrayClient);
		offWattage = off(arrayClient);
		dayWattage = ((inUseWattage + standbyWattage + offWattage) / 1000.0000);
		weekWattage = (dayWattage * 5.00);
		
		System.out.println("A small CPT program by Matteo Tullo");
		System.out.println("The appliance we are auditing is a student computer and monitor");
		System.out.println();
		System.out.println("In use wattage per day: " + inUseWattage + "Wh");
		System.out.println("Standby wattage per day: " + standbyWattage + "Wh");
		System.out.println("Off wattage per day: " + offWattage + "Wh");
		System.out.println("Total wattage per day (kWh): " + dayWattage + "kWh");
		System.out.println("Total wattage per week (kWh): " + weekWattage + "kWh");
		System.out.println("GHG per week: " + (weekWattage * GHG) + "kg CO2e");
		
		
		

	}

}

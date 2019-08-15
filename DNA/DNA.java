//Gg Tran
//CSE 142
//11/23/2017
//HW #7
//This program reads an input file containing named sequences of nucleotides 
//and produce information about them, such as: region name, nucleotide sequence, 
//number of each unique nucleotide, mass percentages, and whether the sequence is protein DNA



import java.util.*;
import java.io.*;

public class DNA {
	public static final int MIN_CODON = 5;
	public static final int MIN_PERCENT = 30;
	public static final int UNIQUE_NUC = 4;
	public static final int NU_PER_CODON = 3;
	
	public static void main(String[] args)throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		intro();
		output(console, input(console));
	}
	
	//Print out the introduction to the program
	public static void intro() {
		System.out.println("This program reports information about DNA");
		System.out.println("nucleotide sequences that may encode proteins.");
	}
	
	//Prompt user for input file name:
	public static Scanner input(Scanner console) throws FileNotFoundException {
		System.out.print("Input file name? ");
		Scanner input = new Scanner(new File(console.nextLine()));
		return input;
	}
	
	//Print content to output file
	public static void output(Scanner console, Scanner input)
	throws FileNotFoundException  {
		System.out.print("Output file name? ");
		PrintStream output = new PrintStream(new File (console.next()));
		while (input.hasNextLine()) {
			String name = input.nextLine();
			
			output.println("Region Name: " + name);
			String dna = input.nextLine();
			dna = dna.toUpperCase();
			String[] codon = codon(dna);
			output.println("Nucleotides: " + dna);
			
			int[] count = countNuc(dna);
			output.println("Nuc. Counts: " + Arrays.toString(count));
			
			//Print out pearcentage of each nucleotide and the total mass of all elements in a DNA string
			double massJunk = junk(dna);
			double[] uniqueNucMass = massNuc(count);
			double totalNucMass = totalNucMass(uniqueNucMass);
			double totalMass = totalMass(totalNucMass, massJunk);
			double[] percentNuc = massPercent(totalMass, uniqueNucMass);
			output.println("Total Mass%: " + Arrays.toString(percentNuc) + " of " + totalMass);
			
			output.println("Codons List: " + Arrays.toString(codon));
			
			boolean protein = isProtein(codon, percentNuc);
			output.print("Is Protein?: ");
			if (protein) {
				output.println("YES");
			} else {
				output.println("NO");
			}
			output.println();
		}
	}
	
	//Take in a DNA string, count the number of unique DNA and return that count
	public static int[] countNuc(String dna) {
		String uniqueNuc = "ACGT";
		int[] countNuc = new int[UNIQUE_NUC];
		for (int i = 0; i < dna.length(); i++) {
			char nuc = dna.charAt(i);
			int index = uniqueNuc.indexOf(nuc);
			if (index != -1) {
				countNuc[index]++;
			}
		}
		return countNuc;
	}
			
	//Take in the number of each nucleotide, calculate and return its mass
	public static double[] massNuc(int[] countNuc) {
		double totalNuc = 0;
		double[] massNuc = new double[UNIQUE_NUC];
		double[] mass = {135.128, 111.103, 151.128, 125.107};
		for (int i = 0; i < countNuc.length; i++) {
			massNuc[i] = countNuc[i] * mass[i];
		}
		return massNuc;
		
	}
	
	//Comebine mass of each unique nucleotide to get the total mass of all nucs
	public static double totalNucMass(double[] massNuc) {
		double totalNuc = 0;
		for (int i = 0; i < massNuc.length; i++) {
			totalNuc += massNuc[i];
		}
		return totalNuc;
		
	}
	
	//Calculate the total mass of all nucleotides and of junk
	public static double totalMass(double totalNuc, double massJunk) {
		double totalMass = totalNuc + massJunk;
		return round(totalMass);
	}
	
	//Take in the total mass of a DNA string
	//Calculate and return percentage of each unique nucleotide
	public static double[] massPercent(double totalMass, double[] massNuc) {
		double[] percentNuc = new double[UNIQUE_NUC];
		for (int i = 0; i < percentNuc.length; i++) {
			percentNuc[i] = round(massNuc[i] / totalMass * 100.0);
		}
		return percentNuc;
	}
		
	//Count the number of junk in a DNA string and return the mass of junk
	public static double junk(String dna) {
		int countJunk = 0;
		for (int i = 0; i < dna.length(); i++) {
			String uniqueNuc = "ACGT";
			char nuc = dna.charAt(i);
			int index = uniqueNuc.indexOf(nuc);
			if (index == -1) {
				countJunk++;
			}
		}
		double massJunk = countJunk * 100.000;
		return massJunk;
	}
	
	//Split DNA string into codon and return the array of codon
	public static String[] codon (String dna) {
		dna = dna.replace("-", "");
		int codonNum = dna.length() / NU_PER_CODON;
		String[] codon = new String[codonNum];
		for (int i = 0; i < codonNum; i++) {
			codon[i] = dna.substring(NU_PER_CODON * i, NU_PER_CODON * (i + 1));
		}
		return codon;
	}
	
	//Decide via the array of codon to see if the dna string is protein
	public static boolean isProtein(String[] codon, double[] percentNuc) {
		String start = codon[0];
		String end = codon[codon.length - 1];
		boolean endProtein = end.equals("TAA") || end.equals("TAG") || end.equals("TGA");
		double percentProtein = percentNuc[1] + percentNuc[2];
		if (start.equals("ATG") && endProtein && percentProtein >= MIN_PERCENT) {
			return true;
		} else {
			return false;
		}
	}
	
	//Round the mass percent of each nucleotide
	public static double round(double percentNuc) {
		double rounded = Math.round(percentNuc * 10.0) / 10.0;
		return rounded;
	}
}
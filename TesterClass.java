package edu.iastate.cs228.hw2.edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.util.Comparator;

public class TesterClass {
	
	
	public static void main(String[] args) throws NullPointerException, FileNotFoundException
	{
		
		char[] test = new char[6];
		test[0] = 'c';
		test[1] = 'b';
		test[2] = 'x';
		test[3] = 'a';
		test[4] = 'z';
		test[5] = 'p';
		Alphabet lol = new Alphabet(test);
		//System.out.println(lol.toString());
		Alphabet alpha_10 = new Alphabet("10.alphabet.txt");
		Alphabet alpha_100 = new Alphabet("100.alphabet.txt");
		/*	Alphabet alpha_1000 = new Alphabet("1000.alphabet.txt");
		Alphabet alpha_10000 = new Alphabet("10000.alphabet.txt");
		*/
		//System.out.println(alpha_10.toString());
		
		AlphabetComparator alphaC_10 = new AlphabetComparator(alpha_10);
		AlphabetComparator alphaC_100 = new AlphabetComparator(alpha_100);
		/*AlphabetComparator alphaC_1000 = new AlphabetComparator(alpha_1000);
		AlphabetComparator alphaC_10000 = new AlphabetComparator(alpha_10000);
		*/
		WordList w_10 = new WordList("10.wordlist.txt");
		WordList w_100 = new WordList("100.wordlist.txt");
		/*	WordList w_1000 = new WordList("1000.wordlist.txt");
		WordList w_10000 = new WordList("10000.wordlist.txt");
		*/
		WordList w_10_sorted = new WordList("10.sortedlist.txt");
		WordList w_100_sorted = new WordList("100.sortedlist.txt");
		/*WordList w_1000_sorted = new WordList("1000.sortedlist.txt");
		WordList w_10000_sorted = new WordList("10000.sortedlist.txt");
		*/
		MergeSorter mSort = new MergeSorter();
		QuickSorter qSort = new QuickSorter();
		InsertionSorter iSort = new InsertionSorter();
		
		//Testing my compare
		

		//System.out.println(alphaC_10.compare(w_10.get(0), w_10.get(1)));
		qSort.sort(w_10, alphaC_10);
	//	System.out.println(w_10.get(1));
		
		System.out.println(w_10.get(0));
		System.out.println(w_10.get(1));
		System.out.println(w_10.get(2));
		System.out.println(w_10.get(3));
		System.out.println(w_10.get(4));
		System.out.println(w_10.get(5));
		System.out.println(w_10.get(6));
		System.out.println(w_10.get(7));
		System.out.println(w_10.get(8));
		System.out.println(w_10.get(9));
		
		//System.out.println(alpha_10.toString());
	/*	System.out.println(alpha_100.toString());
		System.out.println(alpha_1000.toString());
		System.out.println(alpha_10000.toString());
		*/
	}

}

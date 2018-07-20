package edu.iastate.cs228.hw2.edu.iastate.cs228.hw2;


import java.io.FileNotFoundException;
import java.util.Comparator;


/**
 * An class that compares various methods of sorting.
 * 
 * @Nathan Irmiter
 */
public class SorterFramework
{
  /**
   * Loads data necessary to run the sorter statistics output, and runs it.
   * The only logic within this method should be that necessary to use the
   * given file names to create the {@link AlphabetComparator},
   * {@link WordList}, and sorters to use, and then using them to run the
   * sorter statistics output.
   * 
   * @param args
   *   an array expected to contain two arguments:
   *    - the name of a file containing the ordering to use to compare
   *      characters
   *    - the name of a file containing words containing only characters in the
   *      other file
   */
  public static void main(String[] args)
  {

    Alphabet alphabet;
    AlphabetComparator comparator;
    WordList words;
    Sorter[] sorters;

    try {
    	// alphabet = new Alphabet(args[0]);
    //	 words = new WordList(args[1]);
    	// comparator = new AlphabetComparator(alphabet);
    	 alphabet = new Alphabet("1000000.alphabet.txt");
    	 words = new WordList("1000000.wordlist.txt");
    	 comparator = new AlphabetComparator(alphabet);
    
    
    sorters = new Sorter[3];
    QuickSorter qSort = new QuickSorter();
    InsertionSorter iSort = new InsertionSorter();
    MergeSorter mSort = new MergeSorter();
    sorters[0]	= qSort;
    sorters[1] = mSort;
    sorters[2] = iSort;
    SorterFramework toRun = new SorterFramework(sorters, comparator, words,1000000);
    toRun.run();
    }
    catch(FileNotFoundException e) {
    	System.out.println(e.getClass());
    }
  }


  /**
   * The comparator to use for sorting.
   */
  private Comparator<String> comparator;

  /**
   * The words to sort.
   */
  private WordList words;

  /**
   * The array of sorters to use for sorting.
   */
  private Sorter[] sorters;

  /**
   * The total amount of words expected to be sorted by each sorter.
   */
  private int totalToSort;


  /**
   * Constructs and initializes the SorterFramework.
   * 
   * @param sorters
   *   the array of sorters to use for sorting
   * @param comparator
   *   the comparator to use for sorting
   * @param words
   *   the words to sort
   * @param totalToSort
   *   the total amount of words expected to be sorted by each sorter
   * @throws NullPointerException
   *   if any of {@code sorters}, {@code comparator}, {@code words}, or
   *   elements of {@code sorters} are {@code null}
   * @throws IllegalArgumentException
   *   if {@code totalToSort} is negative
   */
  public SorterFramework(Sorter[] sorters, Comparator<String> comparator,WordList words, int totalToSort)
    throws NullPointerException, IllegalArgumentException
  {
	  this.sorters = sorters;
	  this.comparator = comparator;
	  this.words = words;
	  this.totalToSort = totalToSort;
  }


  /**
   * Runs all sorters using
   * {@link Sorter#sortWithStatistics(WordList, Comparator, int)
   * sortWithStatistics()}, and then outputs the following information for each
   * sorter:
   *  - the name of the sorter
   *  - the length of the word list sorted each time
   *  - the total number of words sorted
   *  - the total time used to sort words
   *  - the average time to sort the word list
   *  - the number of elements sorted per second
   *  - the total number of comparisons performed
   */
  public void run() throws FileNotFoundException
  {
   for(int i = 0; i < sorters.length; i++) {
	   sorters[i].sortWithStatistics(this.words, this.comparator, this.totalToSort);
	   System.out.println("The name of the sorter is:" + sorters[i].getName());
	   System.out.println("The length of the word list is:" + words.length());
	   System.out.println("The total number of words sorted is:" + sorters[i].getTotalWordsSorted());
	   System.out.println("The total milliseconds to sort the list is:" + sorters[i].getTotalSortingTime());
	   System.out.println("The average time to sort the list is:" + (sorters[i].getTotalSortingTime() / (sorters[i].getTotalWordsSorted() / words.length())));
	   System.out.println("Average number of elements sorted per second is: "+ (sorters[i].getTotalWordsSorted() / sorters[i].getTotalSortingTime()));
	   System.out.println("Total number of comparisons is: " + sorters[i].getTotalComparisons());
   }
  }
}

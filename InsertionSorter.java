package edu.iastate.cs228.hw2.edu.iastate.cs228.hw2;


import java.util.Comparator;


/**
 * An implementation of {@link Sorter} that performs insertion sort
 * to sort the list.
 * 
 * @Nathan Irmiter
 */
public class InsertionSorter extends Sorter
{
  @Override
  public void sort(WordList toSort, Comparator<String> comp) throws NullPointerException
  {

    for (int i = 1; i < toSort.length(); i++) 
    {
    	String s = toSort.get(i);
    	int j = i - 1;
    	while (j >= 0 && comp.compare(s,toSort.get(j)) < 0) 
    	{
    		//cycle it back to proper place
    		toSort.set(j+1, toSort.get(j));  		
    		j = j - 1;
    	}
    	toSort.set(j+1, s);
    }
  }
}

package edu.iastate.cs228.hw2.edu.iastate.cs228.hw2;


import java.util.Comparator;


/**
 * An implementation of {@link Sorter} that performs quick sort
 * to sort the list.
 * 
 * @Nathan Irmiter
 */
public class QuickSorter extends Sorter
{
  @Override
  public void sort(WordList toSort, Comparator<String> comp) throws NullPointerException
  {
    quickSortRec(toSort,comp, 0, toSort.length() - 1);
  }

  private void quickSortRec(WordList list, Comparator<String> comp, int start, int end)
  {
	  if (start < end) {
		  
		  int partitionVal = partition(list,comp,start,end);
		  
		  //To sort elements before partition and after partition
		  quickSortRec(list,comp,start,partitionVal - 1);
		  quickSortRec(list,comp,partitionVal + 1, end);
	  }
	  
  }
  /**
   * Method for swapping values and determining the next midpoint for recursion
   * @param list
   * @param comp
   * @param start
   * @param end
   * @return
   */
  private int partition(WordList list, Comparator<String> comp, int start, int end)
  {
    String pivot = list.get(end);
    int i = start - 1;
    for (int j = start; j < end; j++)
    {
    	//if current element is smaller than or equal to pivot
    	if (comp.compare(list.get(j), pivot) <= 0)
    	{
    		i++;
    		String temp = list.get(i);
    		list.set(i, list.get(j));
    		list.set(j, temp);
    		
    	}
    }
    //swap element at i+1 and the pivot
    String temp = list.get(i + 1);
    list.set(i + 1, list.get(end));
    list.set(end, temp);
    
    return i+ 1;
  } 
  
 
}

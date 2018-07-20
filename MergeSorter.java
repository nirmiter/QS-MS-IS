package edu.iastate.cs228.hw2.edu.iastate.cs228.hw2;


import java.util.Comparator;


/**
 * An implementation of {@link Sorter} that performs merge sort
 * to sort the list.
 * 
 * @Nathan Irmiter
 */
public class MergeSorter extends Sorter
{
  @Override
  public void sort(WordList toSort, Comparator<String> comp) throws NullPointerException
  {
    mergeSortRec(toSort,comp,0,toSort.length() - 1);
  }
/**
 * Recursive method that takes extra arguments in order to mergesort the list
 * @param list
 * @param comp
 * @param start
 * @param end
 */
  private void mergeSortRec(WordList list, Comparator<String> comp, int start, int end)
  {
    if (start < end)
    {
    	int mid = (start + end) / 2;
    	//Sort first and second halves
    	mergeSortRec( list, comp, start, mid);
    	mergeSortRec( list, comp, mid + 1, end);
    	
    	merge(list, comp, start, mid, end);
    	
    	
    }
  }
  /**
   * After splitting, combines arrays in correct order
   * @param toSort
   * @param comp
   * @param s
   * @param m
   * @param e
   */
  private void merge( WordList toSort, Comparator<String> comp, int s, int m, int e)
  {
	  int arr1 = m - s + 1;
	  int arr2 = e - m;
	  //Creates temporary String arrays of proper size
	  String[] left = new String[arr1];
	  String[] right = new String[arr2];
	  
	  //Copies data to these temp arrays
	  for (int i = 0; i < arr1; i++)
	  {
		  left[i] = toSort.get(s + i);
	  }
	  for (int j = 0; j < arr2; j++) {
		  right[j] = toSort.get(m + 1 + j);
	  }
	  
	  //Now to merge them all back into the same one
	  int i = 0, j = 0;
	  
	  int k = s;
	  while(i < arr1 && j < arr2) {
		  if (comp.compare(left[i], right[j]) <= 0)
		  {
			  toSort.set(k, left[i]);
			  i++;
		  }
		  else
		  {
			  toSort.set(k, right[j]);
			  j++;
		  }
		  k++;
	  }
	  //To account for remaining elements in both arrays
	  while (i < arr1)
	  {
		  toSort.set(k, left[i]);
		  i++;
		  k++;
	  }
	  while (j < arr2)
	  {
		  toSort.set(k, right[j]);
		  j++;
		  k++;
	  }
	   
  }

}

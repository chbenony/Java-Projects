/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/********************************************************************* 
Purpose/Description: <Problem 1: Implements a MergeSort Algorithm to sort
*                      items in ascending order without the use of recursion>
Author’s Panther ID: <3816082>
Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
********************************************************************/

public class Problem1 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Integer [] array = {5, 2, 1, 12, 2, 10, 4, 13, 5} ;
       
        System.out.print("The original array: ");
        printArray(array) ;
        
        System.out.print("The sorted array: ");
        mergeSort(array) ;
        printArray(array);
        
    }
    /** 
     * printArray - function prints the array given in the main function
     * @param array, the original array
     */
    public static void printArray(Comparable[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }
    /**
     * merge - Function that implements the algorithm for merge
     * @param array, the original array
     * @param tempArray, the temporary array where the values are split
     * and compared, before being copied back into the original array
     * @param lower, the lower bound of the array
     * @param high, the upper bound of the array
    */           
    public static void merge(Comparable [] array, Comparable[] tempArray,
                                int lower, int mid, int high)
    {
        for(int k = lower ; k <= high ; k++)
            tempArray[k] = array[k] ;
        
        int i = lower, j = mid + 1 ;
        
        for (int k = lower; k <= high ; k++)
        {
            if (i > mid)
                array[k] = tempArray[j++] ;
            else if (j > high)
                array[k] = tempArray[i++] ;
            else if (tempArray[j].compareTo(tempArray[i]) < 0)
                array[k] = tempArray[j++] ;
            else
                array[k] = tempArray[i++] ;
        }
                                    
    }
    /**
     * mergeSort - Function that implements the MergeSort algorithm
     * @param array, the original array
     * The running time complexity of this algorithm is O(nlogn)
     * 
     **/
    
    
    public static void mergeSort(Comparable[] array)
    {
        Comparable[] tempArray = new Comparable[array.length];
        
        for(int i = 1 ; i < array.length ; i += i)
            for(int j = 0 ; j < array.length - i ; j += i + i)
                merge(array, tempArray, j, j+i-1, 
                        Math.min(j+i+i-1,array.length - 1)) ;
    }
    
}
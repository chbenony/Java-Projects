/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/********************************************************************* 
Purpose/Description: <Problem 2: Problem that implements a RadixSort algorithm
*                     to sort in descending order an array of non-negative
*                     integers>
Author’s Panther ID: <3816082>
Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
********************************************************************/

public class Problem2 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        int [] array = {5, 2, 1, 12, 2, 10, 4, 13, 5} ;
        System.out.print("The original array: ");
        printArray(array);
        radixSort(array);
        System.out.print("The sorted array: ");
        printArray(array) ;
    }
    
    public static void printArray(int [] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }
    /**
     * radixSort - function that implements the RadixSort algorithm
     * @param array, the original array, given in the main function
     * This algorithm has a running time complexity of O(n*k) in the worst case,
     * where n is the size of the input array and k is the length of the longest
     * key.
     * The algorithm has this complexity, because the algorithm must
     * first traverse the array to find the least significant digit.
     * Then, the algorithm must do one pass per digit, for k digits.
     * Therefore, the algorithm has a complexity of O(n*k)
     * 
     */
    public static void radixSort(int [] array)
    {
        int lsd = array[0], num = 1 ;
        int[] temp = new int[10];  
        
        for(int i = 1; i < array.length; i++)
            if(array[i] > lsd)
                lsd = array[i];
        while(lsd / num > 0){
            int[] bucket = new int[10] ;
            
            for (int i = 0 ; i < array.length ; i++)
                bucket[(array[i] / num) % 10]++ ;
            
            for (int i = 1 ; i < 10 ; i++)
                bucket[i] += bucket[i - 1];
            
            for (int i = array.length - 1; i >= 0 ; i--)
                temp[--bucket[(array[i] / num) % 10]] = array[i] ;
            
            for(int i = 0; i < array.length ; i++)
                array[i] = temp[i] ;
            
            num *= 10 ;
        }
        
    }
    
}

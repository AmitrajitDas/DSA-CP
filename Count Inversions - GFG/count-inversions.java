// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    
    static long merge(long arr[], long temp[], int low, int mid, int high) {

        long invCount = 0;
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        for (int it = low; it <= high; it++) arr[it] = temp[it];

        return invCount;
    }

    static long mergeSort(long arr[], long temp[], int low, int high) {
        long invCount = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            invCount += mergeSort(arr, temp, low, mid);
            invCount += mergeSort(arr, temp, mid + 1, high);
            invCount += merge(arr, temp, low, mid, high);
        }

        return invCount;
    }
    
    static long inversionCount(long arr[], long N) {
        int n = arr.length - 1;
        long[] temp = new long[n];
        return mergeSort(arr, temp, 0, n - 1);
    }
}

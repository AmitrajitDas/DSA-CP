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

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long[] temp=new long[arr.length];
        long res=merge_sort(arr,temp,0,arr.length-1);
        return res;
    }
    static long merge_sort(long arr[],long temp[],int l,int r)
    {
        long count=0;
        if(l<r) //If we re changing it to while then its saying "Time Limit Exceeded"
        {
            int mid=(l+r)/2;
            count+=merge_sort(arr,temp,l,mid); //for left subarray
            count+=merge_sort(arr,temp,mid+1,r); //for right subarray
            count+=merge(arr,temp,l,mid,r);
        }
        return count;
    }
    static long merge(long arr[],long temp[],int l,int mid,int r)
    {
        long count=0;
        // long temp[]=new long[arr.length];
        /** If we are declaring temp here then also the 100th test case is showing
         * Time Limit Exceeded **/
        int i=l;
        int j=mid+1;
        int k=l; //for storing elements in the temporary array (temp)
        while(i<=mid && j<=r)
        {
            if(arr[i]<=arr[j])
            {
                temp[k]=arr[i];
                i++;
                k++;
            }
            else
            {
                temp[k++]=arr[j++];
                //k++;
                //j++;
            /** Now we have to also increment count because every element in the
            left subarray will be greater than that element so they will each form one pair**/
                count=count+(mid-i+1);
            }
        }
        while(i<=mid) //right subarray exhaust so fill the remaining left subarray into temp
            temp[k++]=arr[i++];
        while(j<=r) //left subarray exhaust so fill the remaining right subarray into temp
            temp[k++]=arr[j++];
        //Now copy the elements of the temp array back into the original array
        for(int t=l;t<=r;t++)
            arr[t]=temp[t];
            
        return count;
    }
}
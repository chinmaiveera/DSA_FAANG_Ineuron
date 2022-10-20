import java.util.Arrays;
//Given two sorted arrays num1 and num2 of size m and n respectively,return the median of the two sorted arrays.
//Approach:we know that median is middle term in a sorted array if there are two middle terms find
//average of two.
//we are given two sorted arrays and we need to find the median of combined sorted array.
//here we combine two arrays,using merge algorithm,to find the median.
//But here we just need to combine upto middle element and don't need to store the sorted array.
public class find_median {
    public static void main(String[] args) {
        int[] first_array = {2,7,9,13},second_array = {3,5,10,11};

        int ans = find_med(first_array,second_array);
        System.out.println(ans);
        //Time complexity: O((m+n)/2),where m and n are lengths of first and second arrays respectively.
        //Space complexity: O(1)
    }
    static int find_med(int[] arr1,int[] arr2){
        //the median element will be present at (m+n)/2 where m = arr1 length, n = arr2 length
        int i=0,j=0,count=0,total = (arr2.length + arr1.length),curr=-1,prev = -1;
        //mid = (m+n)/2
        int mid = (arr2.length + arr1.length)/2;
        //combine the both arrays upto mid th element.
        while(i < arr1.length && j<arr2.length && count <= mid ){
            //as we are not storing elements in separate array we must keep track of previous element too.
            prev = curr;
            if(arr1[i] <= arr2[j]){
                curr = arr1[i];
                i+=1;
            } else{
                curr = arr2[j];
                j+=1;
            }
            count+=1;
        }
        while (i<arr1.length && count <= mid){

            prev = curr;
            curr = arr1[i];
            i+=1;
            count+=1;
        }
        while (j<arr2.length && count <= mid){

            prev = curr;
            curr = arr2[j];
            j+=1;
            count+=1;
        }

        if(total %2 != 0)
            return curr;
        else
            //if m+n is even median will be average of previous and current element
            return (prev + curr)/2;
    }
}

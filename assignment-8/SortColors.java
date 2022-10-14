import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortcolor(arr);
        System.out.println(Arrays.toString(arr));
        //time complexity: O(n).
    }
    static void sortcolor(int[] arr){

        int i=-1,j=0,k=arr.length;
        while(j<k){
            //if arr[j] is 2 then decrement k and swap k,j values
            if(arr[j] == 2){
                k-=1;
                swap(arr,j,k);
            }
            //if arr[j] is 0 then increment i and swap i,j values
            if(arr[j] == 0){
                i += 1;
                swap(arr,i,j);
            }
            j += 1;
        }
     //finally we will get all 0's from 0 to ith position
     //all 1's from i+1th to jth position
     //all 2's from kth to end position.
    }
    static void swap(int[] arr,int i,int j){
        if(i < arr.length && j < arr.length){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;}
        else
            System.out.println("cannot swap, out of index");
    }
}

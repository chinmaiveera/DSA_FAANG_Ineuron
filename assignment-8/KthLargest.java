import java.util.concurrent.ThreadLocalRandom;
//here our aim is to find kth smallest element in un-sorted array
//we are taking similar approach to quick sort but here we only search on the side
//where our target position lies.
public class KthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int n = nums.length;
        //kth largest element in an element is n-k+1 th smallest element
        //so we are finding n-k+1 th smallest element
        System.out.println(Quick(nums,0,n-1,n-k+1));
        //timecomplexity:
        //best case:O(n) the first pivot element might be the kth smallest
        //average case:O(nlogn)
        //worst case:O(n^2)
    }
    static int Quick(int[] arr,int p,int q,int k){

        if(p>=q)
            return arr[q];
        int mid = partition(arr,p,q);
        //here we are getting the array sorted at mid th position
        //if our target position is mid th then return mid
        //else if mid th position is smaller than out target position then call Quick(arr,mid+1,q,k)
        //else call Quick(arr,p,mid-1,k);
        if(mid == k-1)
            return arr[mid];
        else if(mid > k-1)
            return Quick(arr,p,mid-1,k);
        else
            return Quick(arr,mid+1,q,k);

    }
    static int partition(int[] arr,int p,int q){
        int pivot = ThreadLocalRandom.current().nextInt(p+1, q+1);
        swap(arr,pivot,p);
        int i = p,j = p+1;
        while(j <= q){
            if(arr[j] <= arr[p]){
                i = i+1;
                swap(arr,i,j);
            }
            j += 1;
        }
        swap(arr,i,p);
        return i;
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

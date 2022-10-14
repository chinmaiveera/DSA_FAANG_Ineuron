import java.util.concurrent.ThreadLocalRandom;
//Given array nums of size n, return the majority element present in the array.
//Assume that the majority element always exists in an array.
//Approach: as we know the majority element exist in a sorted array the majority element
//definitely occupies more than half of the array
//So, we can say that element must present at the middle most position if the array is sorted.
//So, now our goal is to find the middle most element in sorted array.
//So, we are finding the mth smallest element in the given array.where m is middle
//most position in a given array
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2,2};
        int mid = (arr.length - 1)/2;//mid is the middle most position in a given array
        int ans = Quick(arr,0,arr.length-1,mid);//we are finding the mth smallest element in the given array.where m is middle
        System.out.println(ans);
        //timecomplexity:
        //best case:O(n) the first pivot element might be the kth smallest
        //average case:O(nlogn)
        //worst case:O(n^2)
    }
    static int Quick(int[] arr,int p,int q,int k){

        if(p>=q)
            return arr[q];
        int mid = partition(arr,p,q);
        if(mid == k)
            return arr[mid];
        else if(mid > k)
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

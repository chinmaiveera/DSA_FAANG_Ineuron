//1. Given an integer array nums of length n and an integer target, find three integers in nums
//such that the sum is closest to the target.[Amazon]
import static java.lang.Integer.MAX_VALUE;
import java.lang.Math;
//Here our aim is to find the best triplet from given unsorted array.
//nearer the triplet sum to given target number, better the triplet.
//Approach: (i)first we sort the array in ascending order using heap sort.
//(ii)in every run we find the first two best co-ordinates using greedy approach.
//(iii)for every best pair of co-ordinates we find the third number in between which forms triplet
//that is as near as possible to the target.As array is sorted we can use binary search.
//(iv)we record the best sum that is as near as possible to target


//Time Complexity: (i) We are using heap sort to sort the elements.Its worst case time complexity is n*logn
// (i) At each run, time complexity to find the third number is log(n) and time
//     complexity to find first two numbers is 1. And we have n such runs. Therefore, time complexity is n*logn.
// (ii)total time complexity = n*logn + n*logn = O(nlogn)
public class FindTriplet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -5};//input array
        int target = 10;//target
        build_heap(arr);
        sort(arr,arr.length);
        int ans = nearst_sum(arr,arr.length,target);
        System.out.println(ans);

    }
    static int nearst_sum(int[] arr,int n,int target){
        //initially take first and last elements as first two elements i.e i,j
        int i=0,j=n-1,k,local_target,sum,nearest = MAX_VALUE,diff;
        while(j-i > 1){
            local_target = target - (arr[i] + arr[j]);
            //find best third element "k" between i,j such that sum is as near as possible to target.
            k = find_best_third_number(arr,i+1,j-1,local_target);
            sum = arr[i] + arr[j] + arr[k];
            if(sum == target){
                return sum;
            }
            //if sum is less than target make i = i+1, else make j = j+1
            if(sum < target)
                i += 1;
            else
                j -= 1;
            //if current sum is nearer than the nearest sum yet. then record current sum as nearst.
            if(Math.abs(target-sum) < Math.abs(target-nearest))
                nearest = sum;
        }
        return nearest;
    }
    static int find_best_third_number(int[] arr,int i,int j,int target){
        //Here we are finding the best third number b/w i,j that makes the sum as near as possible to target.
        //As array is sorted we are using binary search to find the same.
        int start = i;
        int mid;
        while(i<j){
            mid = i + (j-i)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }
        // if the target is in b/w two elements then we return the element that is nearer to the target.if target is lesser than first element
        // then return first element.
        if(i == start || Math.abs(arr[i] - target) < Math.abs(arr[i-1] - target))
            return i;
        else
            return i-1;
    }
    static void build_heap(int[] arr){
        for(int i = arr.length / 2 - 1;i >= 0;i--){
            heapify(arr,arr.length,i);
        }
    }
    static void heapify(int[] arr,int n,int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l < n && arr[l] > arr[largest])
            largest = l;
        if(r < n && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            swap(arr,i, largest);
            heapify(arr,n, largest);}
    }
    static void swap(int[] arr,int i,int j){
        if(i < arr.length && j < arr.length){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;}
        else
            System.out.println("cannot swap, out of index");
    }
    static void sort(int[] arr,int n){
        for(int i = n-1;i>=0;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }
}


import java.util.Arrays;
//Do the implementation of the count of a number of inversions
public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {15,10,1,4,16,5,7,11,13,6,2};
        int ans = count_inversions(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(ans);
        //Time Complexity: As we are applying the merge sort time complexity is NLogN.where N is length of array
    }

    static int count_inversions(int[] arr, int s, int e){
        if(s == e)
            return 0 ;
        int mid = s + (e-s)/2;
        return count_inversions(arr,s,mid) + count_inversions(arr,mid+1,e) + MergeandCount(arr,s,mid,e);
    }
    static int MergeandCount(int[] arr, int s, int mid, int e){
        int length = e-s+1;
        int[] local = new int[length];
        //here count is the no of inversion
        int i=s,j=mid+1,k=0,count=0;

        while (i <= mid && j <= e){
            if(arr[i] <= arr[j]){
                local[k] = arr[i];
                //for every element in first array add count of all the elements in second array
                //that are lesser than the current element.
                count += j-mid-1;
                i++;
            }
            else {
                local[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid){
            //for every element in first array add count of all the elements in second array
            //that are lesser than the current element.
            count += j-mid-1;
            local[k] = arr[i];
            i++;
            k++;
        }
        while (j<= e){
            local[k] = arr[j];
            j++;
            k++;
        }
        i = s;
        for(k=0;k<length;k++){
            arr[i] = local[k];
            i++;
        }
        //return the no of inversions
        return count;
    }

}


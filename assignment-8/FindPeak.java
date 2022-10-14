//The peak element is the element that is strictly greater than its neighbors.
//If an array contains multiple peak elements,
// return the index of any of the peak elements.
//Approach: in 2d plane if we want to reach a peak of mountain we need to move towards
//up stream.
public class FindPeak {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(findPeakElement(arr));
        //time complexity: as we are performing binary search the worst case time
        //complexity will be O(logn)
        //and best case will be O(1).
    }

    static int findPeakElement(int[] nums) {
        int[] arr = nums;
        int i=0,j=arr.length - 1, mid;
        while(i<j){
            mid = i + (j-i)/2;
            //edge case
            if(mid == 0){
                if(arr[mid] > arr[mid + 1])
                    return 0;
                else
                    return 1;
            }
            //if element of both sides are smaller the we reached peak
            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return mid;
            //if the up stream is right words then search for peak on right side
            if(arr[mid] < arr[mid + 1])
                i = mid + 1;
            else//if the up stream is left words then search for peak on left side
                j = mid -1;
        }
        return i;

    }

}

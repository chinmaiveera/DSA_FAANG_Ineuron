//3. An e-commerce site tracks the purchases made each day. The product that is purchased
//the most one day is the featured product for the following day. If there is a tie for the product
//purchased most frequently, those product names are ordered alphabetically ascending and
//the last name in the list is chosen.[Amazon]
import java.util.Arrays;

public class FeaturedProduct {
    public static void main(String[] args) {
        String[] arr = new String[] {"yellowShirt", "redHat", "blackShirt", "bluePants", "redHat","pinkHat", "blackShirt", "yellowShirt",
                "greenPants", "greenPants", "greenPants"};
        //here we are using heap sort to sort string array in lexicographical order.
        sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
        //findProduct function is used to find the product that is going to feature next day.
        System.out.println(findProduct(arr));
        //Time Complexity: (i)time taken by heap sort in worst case is n*logn
        //                 (ii)time taken to find the best product is n
        //                 therefore time complexity = n*logn + n = O(n*logn)
    }
    static void build_heap(String [] arr){
        for(int i = arr.length / 2 - 1;i >= 0;i--){
            heapify(arr,arr.length,i);
        }
    }
    static void heapify(String[] arr,int n,int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;
        if(r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;
        if(largest != i){
            swap(arr,i, largest);
            heapify(arr,n, largest);}
    }
    static void swap(String[] arr,int i,int j){
        if(i < arr.length && j < arr.length){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;}
        else
            System.out.println("cannot swap, out of index");
    }
    static void sort(String[] arr,int n){
        build_heap(arr);
        for(int i = n-1;i>=0;i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }

    static String findProduct(String[] arr){
        //in this function we are initially taking first product in array as final product and product with larger count
        //takes its place
        String str = arr[0],curr_str = arr[0];
        int count = 1,max = 0;
        for(int i=1;i< arr.length;i++){
            if(curr_str.compareTo(arr[i]) == 0){
                count++;
            }
            else{
                if(count > max){
                    //if we find a string that has more frequency than current solution, we replace
                    str = arr[i-1];
                    max = count;
                }
                curr_str = arr[i];
                count = 1;
            }
        }
        return str;
    }
}


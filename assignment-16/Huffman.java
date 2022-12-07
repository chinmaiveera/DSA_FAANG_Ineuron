import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class CustomObjectComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o1.val > o2.val ? 1 : -1;
    }
}
class Node{
    Integer val;
    Node left;
    Node right;
    Character enc;
    Node(Integer a){
        this.val = a;
        this.left = null;
        this.right = null;
        this.enc = null;
    }
    Node(Integer a,Character b){
        this.val = a;
        this.enc = b;
        this.left = null;
        this.right = null;
    }
}


//Do the implementation of Huffman code according to the approach and pseudocode
//discussed in the live session. Consider the same example discussed in the live session
//only so that you can verify the results as well.
//a = 45, b = 15, c = 2, d = 30, e = 5, f = 3
public class Huffman {
//    static class CustomObjectComparator implements Comparator<Node> {
//
//        @Override
//        public int compare(Node o1, Node o2) {
//            return o1.val > o2.val ? 1 : -1;
//        }
//    }
    //driver code
    public static void main(String[] args) {
        //record charecters and their respective frequencies.
        char[] letters = new char[]{'a','b','c','d','e','f'};
        int[] freq = new int[]{45,15,2,30,5,3};
        PriorityQueue<Node> objheap = new PriorityQueue<>(new CustomObjectComparator());
        //add those letters with their frequencies in min heap according to their frequencies.
        for(int i=0;i<freq.length;i++){
            objheap.add(new Node(freq[i],letters[i]));
        }
        //build huffman tree
        Node huffmanTree = buildhuffman(objheap);

        for(int i=0;i<letters.length;i++){
        ArrayList<Character> encoding = new ArrayList<>();
        encode(letters[i],encoding,huffmanTree);
        System.out.println("encoding of letter "+letters[i]+" is "+encoding.toString());
        }
//        while (!objheap.isEmpty()) {
//            System.out.println(objheap.poll().enc);
//        }
    }
    //below function takes the min heap of letters and their frequencies,build huffman tree and
    //return the root of huffman tree
    public static Node buildhuffman(PriorityQueue<Node> heap){
        //build a new node and value of that node will sum of two minimum nodes in current tree
        //and add that node back to min heap.
        while (heap.size()>1) {
            //pop two minimum values from heap
            Node A = heap.poll();
            Node B = heap.poll();
            Node P = new Node(A.val+ B.val);
            //make those two nodes as children to new node
            P.left = A;
            P.right = B;
            //finally add that new node to minheap
            heap.add(P);
        }
        //at last only one node will be left that is root node of huffman tree
        return heap.poll();
    }
    //below recursive funtion takes the letter arraylist and fill that arraylist with encoding of given letter
    //and returns true.
    public static boolean encode(char c, ArrayList<Character> arr, Node curr){
        if(curr == null)
            return false;
        //if found desired letter return true
        if(curr.enc != null && curr.enc == c)
            return true;
       //else add '0' to the encoding and move left
        arr.add('0');
        //if letter found return true;
        if(encode(c,arr,curr.left))
            return true;
        //else backtrack and remove the '0'
        arr.remove(arr.size()-1);
        //try the same adding 1 and moving right
        arr.add('1');
        //if letter found return true;
        if(encode(c,arr,curr.right))
            return true;
        //else backtrack and remove the '1' and return false.
        arr.remove(arr.size()-1);
        return false;
    }

}

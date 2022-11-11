import javafx.util.Pair;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
//Hashing using middle square method hash function.
public class MidSquare {
    //Time Complexity:
    //finding hash value:independent of no of key value pairs.
    //searching for value of corresponding key:O(1)
    //adding value of key to table:O(1)
    public static void main(String[] args) {
        //input with keys and their corresponding values
        Pair<String,Integer>[] p = new Pair[4];
        p[0] = new Pair<>("20",1);
        p[1] = new Pair<>("21",2);
        p[2] = new Pair<>("22",3);
        p[3] = new Pair<>("23",4);
        //size of hash table
        int m = 10;
        //declaring hash table of size m initializing with null
        ArrayList<Integer> hashtable = new ArrayList<>(Collections.nCopies(m,null));
        //adding key value pairs to hash table
        for(int i=0;i<4;i++)
            add(p[i],hashtable,m);
        //print the entire hash table
        hashtable.forEach(integer -> System.out.println(integer));
        //print the value of key "22"
        System.out.println("value is "+getvalue("22",hashtable,m));
    }
    public static int getvalue(String key,ArrayList<Integer> table,int m){
        //this function returns the value of corresponding key
        return table.get(hashvalue(key,m));
    }
    public static void add(Pair<String,Integer> p,ArrayList<Integer> table,int m){
        //this function takes the key value pairs and add them to hashtable
        //find the value of hash function
        int value = hashvalue(p.getKey(),m);
        //add the value of key at location of hash value
        table.set(value,p.getValue());
    }

    public static int hashvalue(String key,int m){
        //this function takes key and calculates the hash value.
        int sum = 0;
        //add all ascii values of string to "sum"
        for(char i : key.toCharArray())
            sum += i;
        //find square of sum and store it in "sum"
        sum = sum*sum;
        //count of no of digits of hash value.
        int count = (int)Math.log10(m-1) + 1;
        //count the no of digits of sum
        int keycount = (int)Math.log10(sum) + 1;
        int c = keycount/2 - count/2 ;
        int temp = sum;
        //remove all the digits succeeding hash value.
        while ( c > 0){
            temp = temp/10;
            c -= 1;
        }
        int mod = (int)Math.pow(10,count);
        //remove all the digits before hash value and return.
        return temp%mod;
    }
}

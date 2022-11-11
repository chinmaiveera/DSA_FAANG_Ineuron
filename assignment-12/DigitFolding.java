import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
//Hasing using digit folding hash function.
public class DigitFolding {
    //Time Complexity:
    //finding hash value:independent of no of key value pairs.
    //searching for value of corresponding key:O(1)
    //adding value of key to table:O(1)
    public static void main(String[] args) {
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
        int hash_value = hashvalue(p.getKey(),m);
        //add the value of key at location of hash value
        table.set(hash_value,p.getValue());
    }

    public static int hashvalue(String key,int m){
        int sum = 0;
        for(char i : key.toCharArray())
            sum += i;
        int temp = sum;
        int result = 0;
        //cut the sum into digits of  size of hashvalue's and add all of them.
        while (temp > 0){
            result += temp%m;
            temp = temp/m;
        }
        //reduce the result to size of hashvalue and return.
        return result%m;
    }
}

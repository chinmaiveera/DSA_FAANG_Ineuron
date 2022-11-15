import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class DoubleHash {
    public static void main(String[] args) {
        Pair<String,Integer>[] p = new Pair[7];
        p[0] = new Pair<>("0",1);
        p[1] = new Pair<>("1",2);
        p[2] = new Pair<>("2",3);
        p[3] = new Pair<>("3",4);
        p[4] = new Pair<>("11",5);
        p[5] = new Pair<>("12",6);
        p[6] = new Pair<>("16",7);
        //size of hash table
        int m = 10;
        //declare hash table that stores key value pairs and initialize with null
        ArrayList<Pair<String,Integer>> hashtable = new ArrayList<>(Collections.nCopies(m,null));
        //add key value pairs to hashtable
        for(int i=0;i<7;i++){
            add(p[i],hashtable,m);
        }
        //print hash table
        hashtable.forEach(keyvalue -> System.out.println(keyvalue));
        //enter key you wanted to search
        String key = "89";
        //get the value for key using getvalue() function
        Integer val = getvalue(key,hashtable,m);
        //if value is null means key not present in hashtable/
        if(val != null)
        System.out.println("value of "+key+" is "+getvalue(key,hashtable,m));
        else
            System.out.println("key no present");

    }
    public static Integer getvalue(String key,ArrayList<Pair<String,Integer>> table,int m){
        //this function returns the value of corresponding key
        Integer position = doublehash(key,table,m);
        if(table.get(position)!=null)
            return table.get(position).getValue();
        else
            return null;
    }


    public static void add(Pair<String,Integer> p,ArrayList<Pair<String,Integer>> table,int m){
        //this function takes the key value pairs and add them to hashtable
        //find the value of hash function
        int position = doublehash(p.getKey(),table,m);
        //add the key value pair at location of hash value
        table.set(position,p);
    }
    public static int doublehash(String key, ArrayList<Pair<String,Integer>> table, int m){
        //this function uses double hashing to find position for given keypair.
        int sum = 0;
        //find sum of all ascii values of key
        for(char s: key.toCharArray()){
            sum += s;
        }
        int hf1 = sum%m;
        int hf2 = (sum%(m-2)) + 1;
        int postion = hf1,i=1;
        //continue modifing the position according to algrithm until we find empty space or same key
        while (table.get(postion) != null && table.get(postion).getKey() != key){
//            System.out.println(postion);
           postion = (hf1 + (hf2*i))%m;
            i+=1;
        }
        //return that position
        return postion;
    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisionModWithProbing {
    //hasing using division modulo hash function and probing techniques for collision resolution.
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
        int position = hashval(key.toCharArray(),m);
        position = probing(position,key,table,m);
        return table.get(position).getValue();
    }
    public static int probing(int position,String key,ArrayList<Pair<String,Integer>> table,int m){
        return linearprob(position,key,table,m);
        //uncomment below and comment above to use quadratic probing
//        return quadprobing(position,key,table,m);
    }
    public static int quadprobing(int position,String key,ArrayList<Pair<String,Integer>> table,int m){
        int i=1,c1=1,c2=1;
        int temp = position;
        while(table.get(position) != null && table.get(position).getKey() != key){
            position = (temp + c1*i + c2+i*i)%m;
            i += 1;
        }
        return position;
    }
    public static int linearprob(int position,String key,ArrayList<Pair<String,Integer>> table,int m){
        while(table.get(position) != null && table.get(position).getKey() != key){
            position = (position+1)%m;
        }
        return position;
    }

    public static void add(Pair<String,Integer> p,ArrayList<Pair<String,Integer>> table,int m){
        int position = hashval(p.getKey().toCharArray(),m);
        position = probing(position,p.getKey(),table,m);
        table.set(position,p);
    }
    public static int hashval(char[] key,int m){
        int sum = 0;
        for(char s: key ){
            sum += s;
        }
        return sum%m;
    }


}

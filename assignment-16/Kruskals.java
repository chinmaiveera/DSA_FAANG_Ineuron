import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

class MinSpanTree{
    ArrayList<int[]> edges;
    Integer cost;
    MinSpanTree(ArrayList<int[]> edges,Integer mincost){
        this.edges = edges;
        cost = mincost;
    }
}
class Edge{
    Integer v1;
    Integer v2;
    Integer weight;
    Edge(int v1,int v2,int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
}


//Do the implementation of Kruskal’s algorithm using heap data structure as discussed in
//live session.
public class Kruskals {
    //driver code
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1,2,4));
        edges.add(new Edge(2,4,5));
        edges.add(new Edge(4,3,8));
        edges.add(new Edge(1,3,7));
        edges.add(new Edge(1,4,8));
        MinSpanTree minSpanTree = findMinSpanTree(edges);
        System.out.print("cost of minimum spanning tree is ");
        System.out.println(minSpanTree.cost);
        System.out.println("edges of minimum spanning tree are");
        minSpanTree.edges.forEach(ints -> System.out.println(""+ints[0]+" "+ints[1]));
        //Time COmplexity: O(ElogE).
    }
    //below function takes the edges of graph and uses kruskals algorithm
    // to return minimum spanning tree and cost of it.
    static MinSpanTree findMinSpanTree(ArrayList<Edge> edges){
        //in kruskals algo we needed to do cycledetection. For cycle detection we use unionfind&pathcomression algorithm
        //we are creating two dictionaries to store ultimate_parent and rank of each node respectively.
        Dictionary<Integer,Integer> parent = new Hashtable<>();
        Dictionary<Integer,Integer> rank = new Hashtable<>();
        //initially every vertex is ultimate parent of itself and rank is 0.
        for(Edge i:edges){
            if(parent.get(i.v1) == null){
                parent.put(i.v1,i.v1);
                rank.put(i.v1,0);
            }
            if(parent.get(i.v2) == null){
                parent.put(i.v2,i.v2);
                rank.put(i.v2,0);
            }
        }
        //we are sorting edges in ascending order of weights.
        Collections.sort(edges,(a,b)-> a.weight - b.weight);
        //we are creating an arraylist that stores the edges of minimum spanning tree
        ArrayList<int[]> sptree = new ArrayList<>();
        int cost = 0;
        Edge curr;
        //iterating trough all the edges from least weight to highest weight.
        for(int i=0;i<edges.size();i++){
            curr = edges.get(i);
            //add current vertices to spanning tree and check if this edge forms cycle.
            boolean cycleExist = ifCycle(parent,rank,new int[]{curr.v1, curr.v2});
            //if cycle exists add that tree to spanning tree and add its cost
            if(!cycleExist){
                //add the cost of current edge to total cost.
                cost += curr.weight;
                sptree.add(new int[]{curr.v1, curr.v2});
            }
        }
        //return edges of minimum spanning tree and its cost.
        return new MinSpanTree(sptree,cost);
    }


    static boolean ifCycle(Dictionary<Integer,Integer> parent, Dictionary<Integer,Integer> rank, int[] edge){
            //find the ultimate parent of two vertices of given edge using path compression
            int parent1 = findparent(parent, edge[0]);
            int parent2 = findparent(parent, edge[1]);
            //if ultimate parents of two vertices are same, it means current edge forms cycle so return true
            if(parent1 == parent2){
                return true;
            }
            //make ultimate-parent of higher rank the parent of ultimate-parent of lower rank.
            //and update the rank of parent.
            if(rank.get(parent1) >= rank.get(parent2)){
                parent.put(parent2,parent1);
                //update rank
                rank.put(parent1,Math.max(rank.get(parent1),rank.get(parent2)+1));
            }
            else{
                parent.put(parent1,parent2);
                //update rank
                rank.put(parent2,Math.max(rank.get(parent2),rank.get(parent1)+1));
            }
        return false;
    }
    //path compression
    static int findparent(Dictionary<Integer,Integer> parent,int i){
        if(parent.get(i) == i)
            return i;
        parent.put(i,findparent(parent,parent.get(i)));
        return parent.get(i);
    }
}

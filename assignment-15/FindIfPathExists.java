//BELOW CODE EXECUTED AND PASSED 100% TESTCASES ON LEETCODE
class FindIfPathExists {
    //below function takes the edges,source,destination in a graph and returns true if there is a valid path
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //first we built a graph from given edges and store it in adjacency list.
        ArrayList<Integer>[] graph = buildgraph(edges,n);
        //create a boolean array to keep track of visited nodes
        boolean[] checked = new boolean[n];
        //initialize checked list with false as we all nodes are unvisited
        Arrays.fill(checked,Boolean.FALSE);
        //mark source as checked as we start form there.
        checked[source] = true;
        //find whether valid path exist from source to destination 
        boolean ispath = ifpath(graph,source,destination,checked);
        return ispath;
    }
    //below function takes the edges and no of nodes of a graph and build a graph from it and return that in form of adjacency list.
    public ArrayList<Integer>[] buildgraph(int[][]edges,int n){
        //initialize an array of array list to store adjacency list
        ArrayList<Integer>[] graph = new ArrayList[n];
        //initialize the list
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        //add all connected nodes of node n in graph[n].as it is bidirectional graph we do both ways
        for(int[] i:edges){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }
        //return that adjacency list
        return graph;
    }
    //below recursive function finds weather there is a path that exists b/w source and destination using BFT.
    public boolean ifpath(ArrayList<Integer>[] grid,int curr,int dest,boolean[] checked){
        //if we reached destination then return true
        if(curr == dest)
            return true;
        boolean istrue = false;
        ArrayList<Integer> edges = grid[curr];
        //perform bst and check any of pahts from current node returns true
        for(int i=0;i<edges.size();i++){
            if(!checked[edges.get(i)]){
                checked[edges.get(i)] = true;
                istrue = (istrue || ifpath(grid,edges.get(i),dest,checked));
            }
        }
        return istrue;
    }
                          
}

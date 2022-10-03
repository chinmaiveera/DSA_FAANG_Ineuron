//2. Given three points, check whether they lie on a straight (collinear) or not. [Google]
import static java.lang.Math.sqrt;

public class IfCollinear {
    //Here we are given co-ordinates of three points, we need to find weather the three points
    //are collinear or not.
    //Approach: Any three given point connected forms a triangle.
    //          In a triangle if sum of two of its smallest sides is equal to the largest side
    //          then its smaller sides coinside with largest side and forms a straight line.
    //          Hence, we check weather the longest side is equal to sum of smaller sides.
    public static void main(String[] args) {
        int[][] arr = {{0,5},{1,3},{4,3}};
        System.out.println(isCollinear(arr));
        //Time Complexity: Here the problem is of constant time complexity as no of points always same.
        // So, O(1).
        // Note: Math.sqrt() is an inbuilt java function,to find square root,that takes constant time.
    }
    static String isCollinear(int[][] arr){
        double[] dist = new double[3];
        for(int i=0;i<3;i++){
            //here we are finding the distance b/w every two points
            // and storing those distances in an array.
            dist[i] = findDist(arr[i][0],arr[i][1],arr[(i+1)%3][0],arr[(i+1)%3][1]);

        }
        //Here we are finding the largest of three sides and checking weather
        //it is equal to sum of smaller sides.
        //and returning "yes" if above condition holds true.
        if(dist[0] < dist[1])
            swap(dist,0,1);
        if(dist[0] < dist[2])
            swap(dist,0,2);

        if(dist[0] == (dist[1] + dist[2]))
            return "yes";
        else
            return "no";
    }
    static double findDist(int x1,int y1,int x2,int y2){
        // distance d b/w to points (x1,y1) and (x2,y2) is d=√((x2 – x1)² + (y2 – y1)²).
        return sqrt((x2 - x1)*(x2 - x1) + (y2-y1)*(y2-y1));
    }
    static void swap(double[] arr,int i,int j){
        //swap arr[i],arr[j]
        if(i < arr.length && j < arr.length){
            double temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;}
        else
            System.out.println("cannot swap, out of index");
    }

}


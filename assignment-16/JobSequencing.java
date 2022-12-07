import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Job{
    String id;
    Integer profit;
    Integer deadline;
    Job(String id,Integer profit,Integer deadline){
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}

//Implementation of Job Sequencing with Deadline using the heap-based data structure.
public class JobSeq {
    //driver code
    public static void main(String[] args) {
        Job[] jobs = new Job[9];
        jobs[0] = new Job("j1",55,5);
        jobs[1] = new Job("j2",65,2);
        jobs[2] = new Job("j3",75,7);
        jobs[3] = new Job("j4",60,3);
        jobs[4] = new Job("j5",70,2);
        jobs[5] = new Job("j6",50,1);
        jobs[6] = new Job("j7",85,4);
        jobs[7] = new Job("j8",68,5);
        jobs[8] = new Job("j9",45,3);
        ArrayList<Job> Jobs = new ArrayList<>();
        for(int i=0;i<jobs.length;i++){
            Jobs.add(jobs[i]);
        }
        Jobs = findMaxProfit(Jobs);
        int maxprofit = 0;
        //iterate trough optimal sequence and find the total profit
        for(int i=0;i<Jobs.size();i++) {
            if(Jobs.get(i) != null){
            maxprofit += Jobs.get(i).profit;
            System.out.println("day "+(i+1)+" "+Jobs.get(i).id);
            }
            else
                System.out.println("day "+(i+1)+" null");

        }
        System.out.println("max profit = "+maxprofit);
        //Time Complexity:
        //for sorting: eloge , e is no of edges.
        //for finding job at that day loge, e is no of edges.
        //no of days d, d is highest deadline of any job
        //therefore, timecomplexity =  eloge + dloge = O((e+d)loge) where e is no of edges and d is total no of days
    }

    //below function takes the profits and deadlines of each job and returns the jobs in optimal sequence for max profit.
    static ArrayList<Job> findMaxProfit(ArrayList<Job> jobs){
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) ->  b.profit - a.profit);
        ArrayList<Job> result = new ArrayList<>();
        //sort the jobs in descending order of deadlines
        Collections.sort(jobs,(Job a,Job b) -> b.deadline - a.deadline );
        int start = jobs.get(0).deadline;
        int top=0;
        //we start from the last day
        for(int i=start;i>0;i--){
            //add all the jobs which can be completed on or after current day.
            while(top< jobs.size() && jobs.get(top).deadline >= i){
                maxHeap.add(jobs.get(top));
                top++;
            }
            //add the job with highest profit of all the jobs that can be completed on or after current day.
            if(!maxHeap.isEmpty())
                result.add(0,maxHeap.poll());//as we are filling from last day add current job at start of array
            else
                result.add(0,null);
        }
        //return the array with jobs in optimal sequence
        return result;
    }
}

//Given two integers, dividend and divisor, divide the two integers without using multiplication, division, and mod operator.
public class Divide {
    public static void main(String[] args) {
        int dividend = 1214748364;
        int divisor = 7;
        int ans = divide_two(dividend,divisor);
        System.out.println(ans);
    }
    static int divide_two(int dividend,int divisor){
        //computes the quotient of given dividend and divisor only by using additions and subtractions
        //our target is to take variable "num" as near as possible to dividend
        //and we keep track of no of divisors added to num using variable "count"
        //Note: Quotient = no of divisors that adds upto dividend;So, count will be our Quotient
        int prev_num=0,prev_count=0,num=0,count=0, count_adder =1,timer = 0,numadder=divisor,psum=0,pcount=0;
        //we keep on increasing num until |dividend - num| < divisor
        while(dividend - num >= divisor || dividend - num < -divisor){
//            //here the value to be added to the num is decided by adder,adder starts with divisor
              //the value to be added to the count is decided by count_adder,count_adder starts with divisor
           timer++;
            if(dividend - num >= divisor){
                //we record the previous count value and previous num value before proceeding further
                prev_count = count;
                prev_num = num;
            }
            else{
                //if num > dividend we reset adder to divisor
                //and count_adder to 1;
                //we record the previous count and previous num to pcount and psum as this also
                //will be added to num and count at each step further.
                numadder = divisor;
                psum = prev_num;
                count_adder = 1;
                pcount = prev_count;
            }
            numadder = numadder + numadder;
            count_adder = count_adder + count_adder;
            count = pcount + count_adder;
            num = psum + numadder;
        }
        System.out.println("it took "+ timer+" steps to compute");
        //|dividend - num| < divisor;
        int diff = dividend - num;
        if(diff >= 0){
            //if num is just lesser than dividend
            return count;
        }
        else
            //if num is just grater than dividend we take lower bound
            return count - 1;
    }

}

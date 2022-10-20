//Implement pow(x,n) which calculates x raised to the power n (i.e. x^n)
public class FindPower {
    public static void main(String[] args) {
        int x = 2;
        int n = -2;
        float ans = find_power(x, n);
        System.out.println(ans);
        //Time Complexity : O(log(power))
        //space complexity:O(1)
    }
    static int pow(int x, int n){

        int ans;
        if(n == 1)
            return x;
        //if power is odd find x*x^(n-1)/2*x^(n-1)/2
        //if power is even find x^(n-1)/2*x^(n-1)/2
        if(n %2 == 0)
            ans = pow(x, n /2);
        else
            ans = x * pow(x,(n -1)/2);
        //to avoid overlapping of sub-problem find half of power and multiply itself.
        return ans * ans;
    }
   static float find_power(int x, int n){
        //if power is equal to 0 return 1
        if(n == 0)
            return 1;
        //if power is less than 0 find 1/base^|power|;
        if(n < 0){
            n = n * (-1);
            return (float) 1/ pow(x, n);
        }
        else
            return pow(x, n);
    }

}



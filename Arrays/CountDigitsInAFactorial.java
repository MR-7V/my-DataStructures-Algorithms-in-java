//https://practice.geeksforgeeks.org/problems/count-digits-in-a-factorial3957/1
//

class CountDigitsInAFactorial{
    public static void main(String args[]){
        int n = 5;
        System.out.println(facDigits(n));
    }

    static int facDigits(int N){
        if(N==0)
            return 0;
        if(N<=1)
            return 1;
        double digit = 0;
        for(int i=2;i<=N;i++){
            digit += Math.log10(i);
        }
        return (int)(Math.floor(digit))+1;
    }
}

/*
We know,
log(a*b) = log(a) + log(b)

Therefore
log( n! ) = log(1*2*3....... * n) = log(1) + log(2) + ........ +log(n)

Now, observe that the floor value of log base 
10 increased by 1, of any number, gives the
number of digits present in that number.

Hence, output would be : floor(log(n!)) + 1.

*/
//https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1

class TrailingZeroesInFactorial{
    public static void main(String args[]){
        int n = 251;
        System.out.println(trailingZeroes(n));
    }

    static int trailingZeroes(int N){
        int res = 0;
        for(int i=5;i<=N;i*=5)
            res+=N/i;
        return res;
    }
}
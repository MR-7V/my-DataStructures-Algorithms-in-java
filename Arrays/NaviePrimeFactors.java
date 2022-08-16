
public class NaviePrimeFactors
{
	public static void main(String[] args) {
        factors(12);
	}
	
	public static boolean isPrime(int n){
        if(n<=1)
            return false;
        if(n==2 || n==3)
            return true;    
        if(n%2==0 || n%3==0)
            return false;
        for(int i=5;i*i<n;i+=6){
            if(n%i==0 || n%(i+2)==0)
                return false;
        }
        return true;
	}
	
	public static void factors(int n){
        for(int i=2;i<n/2;i++){
            if(isPrime(i)){
                int x = i;
                while(n%x==0){
                    System.out.println(i);
                    x*=i;
                }
            }
        }
	}
	
}

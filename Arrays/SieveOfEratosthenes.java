//print primes upto n
//https://www.geeksforgeeks.org/sieve-of-eratosthenes/

class SieveOfEratosthenes {

    public static void main(String[] args) {
        int n = 100;
        boolean[] prime = new boolean[n + 1]; // create array of size n and make all "true".
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) { // for n=100, i=2,3,4,....10
            if (prime[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.println(i);
        }
    }
}
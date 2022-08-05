//To check element is prime or not in efficent way.
//https://www.geeksforgeeks.org/java-program-to-check-if-a-number-is-prime-or-not/

class SieveOfEratosthenes2 {
    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0 && num % 3 == 0)
            return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }
        return true;
    }
}

/*
 * 5 AUG 2022
 * Time complexity of this solution is O(√n)
 * 
 * Optimized School Method
 * We can do following optimizations:
 * 
 * Instead of checking till n, we can check till √n because a larger factor of n
 * must be a multiple of smaller factor that has been already checked.
 * The algorithm can be improved further by observing that all primes are of the
 * form 6k ± 1,
 * with the exception of 2 and 3.
 */
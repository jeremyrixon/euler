package org.rixon.primes;

public class Fermat {

    public static long gcd(long a, long b) {
        while (true) {
            if (a > b) {
                a = a % b;
                if (a == 0) {
                    return b;
                }
            } else {
                b = b % a;
                if (b == 0) {
                    return a;
                }
            }
        }
    }

    public static long expMod(long base, long exponent, long modulus) {
        long result = 1;

        while(exponent > 0) {
            if ((exponent & 1l) == 1l) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent >>= 1;
        }
        return result;
    }

    public static boolean fermatPseudoprime(long base, long p) {
        return expMod(base, p - 1, p) == 1;
    }

//    public static boolean strongPseudoprime(long p) {
//        long d = p - 1;
//        int s = 0;
//        while ((d & 1) == 0) {
//            d = d >> 1;
//            s++;
//        }
//        if (expMod(2, d, p) == 1) {
//            return true;
//        }
//        for (int r = 0; r < s; r++) {
//            //if (expMod())
//        }
//
//    }

    public static void main(String[] args) {
        int N = 3000;
        Sieve s = new Sieve(N);

        for (int p = 3; p < N; p+=2) {
            boolean isPrime = s.isPrime(p);
            boolean isfermatPseudoprime = fermatPseudoprime(2, p);
            if (!isPrime && isfermatPseudoprime) {
                System.out.format("%5d (%5d) %b%n", p, expMod(2, p - 1, p), fermatPseudoprime(2, p));
            }
        }
    }
}

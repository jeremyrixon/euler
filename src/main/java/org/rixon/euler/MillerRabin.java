package org.rixon.euler;

@SuppressWarnings("WeakerAccess")
public class MillerRabin {

    // calcul a^n%mod
    static long power(long a, long n, long mod)
    {
        long power = a;
        long result = 1;

        while (n != 0)
        {
            if ((n & 1) == 1)
                result = (result * power) % mod;
            power = (power * power) % mod;
            n >>= 1;
        }
        return result;
    }

    // n−1 = 2^s * d with d odd by factoring powers of 2 from n−1
    static boolean witness(long n, long s, long d, long a)
    {
        long x = power(a, d, n);
        long y = 0;

        while (s != 0) {
            y = (x * x) % n;
            if (y == 1 && x != 1 && x != n-1)
                return false;
            x = y;
            --s;
        }

        if (y != 1)
            return false;
        return true;
    }

    static boolean witness(long n, long s, long d, long... alist)
    {
        for(long a: alist) {
            if (!witness(n,s,d,a)) return false;
        }
        return true;
    }

    static boolean is_prime_mr(long n) {
        if ((((n & 1) == 0) && n != 2) || (n < 2) || (n % 3 == 0 && n != 3))
            return false;
        if (n <= 3)
            return true;

        long d = n / 2;
        long s = 1;
        while ((d & 1) == 0) {
            d /= 2;
            ++s;
        }

        // https://en.wikipedia.org/wiki/Miller–Rabin_primality_test#Testing_against_small_sets_of_bases
        if (n < 2047) return witness(n, s, d, 2);
        if (n < 1373653) return witness(n, s, d, 2, 3);
        if (n < 9080191) return witness(n, s, d, 31, 73);
        if (n < 4759123141L) return witness(n, s, d, 2, 7, 61);
        if (n < 1122004669633L) return witness(n, s, d, 2, 13, 23, 1662803);
        if (n < 2152302898747L) return witness(n, s, d, 2, 3, 5, 7, 11);
        if (n < 3474749660383L) return witness(n, s, d, 2, 3, 5, 7, 11, 13);
        if (n < 3825123056546413051L) return witness(n, s, d, 2, 3, 5, 7, 11, 13, 17);
        return witness(n, s, d, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37);

    }

    public static void main(String[] args) {

        assert(is_prime_mr(Long.MAX_VALUE));

        for(long l = 2, n = 0; n <= 100000000; l++) {
            if (is_prime_mr(l)) {
                n++;
                if (n == 1000) assert(l == 7919);
                if (n == 10000) assert(l == 104729);
                if (n == 100000) assert(l == 1299709);
                if (n == 1000000) assert(l == 15485863);
                if (n == 10000000) assert(l == 179424673);
                if (n == 100000000) assert(l == 2038074743);
            }
        }
    }
}

package org.rixon.euler;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.Arrays;

public class Util {
	public static BigInteger sqrt(BigInteger n) {
		BigInteger b = ZERO;
		while (n.compareTo(ZERO) >= 0) {
			n = n.subtract(b);
			b = b.add(ONE);
			n = n.subtract(b);
		}
		return b.subtract(ONE);
	}
	
	public static long totient(long n, Primes p) {
		long numerator = n;
		long denominator = 1;
		
		int primeIdx = 1;
		long prime = p.getPrime(primeIdx);
		while (n > 1) {
			if (n % prime == 0) {
				denominator *= prime;
				numerator *= prime - 1;
				while (n % prime == 0) {
					n /= prime;
				}
			}
			prime = p.getPrime(++primeIdx);
		}
		
		return numerator / denominator;
	}
	
	public static long factorial(int n) {
		int f = 2;
		for (; n > 2; n--) {
			f *= n;
		}
		return f;
	}

	
	public static int totient(int n, int[] primes) {
		long numerator = n;
		long denominator = 1;
		int maxPrime = n;
		int primeIdx = 0;
		int prime = primes[primeIdx];

		while (n > 1 && prime <= maxPrime) {
			if (n % prime == 0) {
				denominator *= prime;
				numerator *= prime - 1;
				while (n % prime == 0) {
					n /= prime;
				}
			}
			primeIdx++;
			if (primeIdx == primes.length) {
				break;
			}
			prime = primes[primeIdx];
		}
		
		return (int) (numerator / denominator);
	}
	
	
	public static boolean arePermutations(long a, long b) {
		int[] digits = new int[10];
		for (int i = 0; i < 10; i++) {
			digits[i] = 0;
		}
		while (a > 0) {
			int digit = (int) (a % 10);
			digits[digit]++;
			a /= 10;
		}
		while (b > 0) {
			int digit = (int) (b % 10);
			digits[digit]--;
			b /= 10;
		}
		for (int i = 0; i < 10; i++) {
			if (digits[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static long gcd(long a, long b) {
	    if (a == 0)
	        return b;

	    while (b != 0) {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }

	    return a;
	}	
	
	public static boolean areCoprime(int a, int b, int[] primes) {
		for (int prime: primes) {
			if (prime > a || prime > b) {
				break;
			}
			if (a % prime == 0 && b % prime == 0) {
				return false;
			}
		}
		return true;
	}

	public static int highestPrimeEqualOrLower(int n, int[] primes) {
		int high = primes.length - 1;
		int low = 0;
		while (true) {
			if (primes[high] <= n) {
				return high;
			}
			if (primes[low] == n) {
				return low;
			}
			if (high == low + 1) {
				return low;
			}
			int guess = (high + low) / 2;
			if (primes[guess] > n) {
				high = guess;
			} else {
				low = guess;
			}
		}
	}
	
	
	public static int distinctPrimeSums(int n, int[] primes) {
		int count = 0;
		int primeIdx = 0;
		
		return count;
	}
	
	public static boolean isPerfectSquare(long n) {
		if ((n & 0x2) == 0x2) {
			return false;
		}
		long sq = isqrt(n);
		return sq * sq == n;
	}

	public static boolean isPerfectSquare(int n) {
		if ((n & 0x2) == 0x2) {
			return false;
		}
		int sq = isqrt(n);
		return sq * sq == n;
	}
	
	public static long isqrt(long n) {
		  long b = 0;
		  while(n >= 0)
		  {
		    n = n - b;
		    b = b + 1;
		    n = n - b;
		  }
		  return b - 1;
	}
	
	public static int isqrt(int n) {
		  int b = 0;
		  while(n >= 0)
		  {
		    n = n - b;
		    b = b + 1;
		    n = n - b;
		  }
		  return b - 1;
	}
	
	public static int[] divisors(int n) {
		int[] divisors = new int[n / 2 + 2];
		divisors[0] = 1;
		divisors[1] = n;
		int num = 2;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				divisors[num++] = i;
				if (i * i < n) {
					divisors[num++] = n / i;
				}
			}
		}
		return Arrays.copyOf(divisors, num);
	}

	public static int[] properDivisors(int n) {
		int[] divisors = new int[(n / 2 + 1)];
		divisors[0] = 1;
		int num = 1;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				divisors[num++] = i;
				if (i * i < n) {
					divisors[num++] = n / i;
				}
			}
		}
		return Arrays.copyOf(divisors, num);
	}
	
	public static int dotProduct(int[] a, int[] b) {
		int dp = 0;
		for (int i = 0; i < a.length; i++) {
			dp += a[i]*b[i];
		}
		return dp;
	}
	
	
}

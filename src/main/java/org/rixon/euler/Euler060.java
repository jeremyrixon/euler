package org.rixon.euler;

public class Euler060 {

	public static void main(String[] args)  {
		int MAX = 10000;
		long lowestSum = Long.MAX_VALUE;
		Primes primes = new Primes();
		for(long a = 3; a < MAX; a = primes.nextPrime(a)) {
			for(long b = primes.nextPrime(a); b < MAX; b = primes.nextPrime(b)) {
				//System.out.println("b=" + b);
				if (alwaysPrime(primes, a, b)) {
					for(long c = primes.nextPrime(b); c < MAX ; c = primes.nextPrime(c)) {
						//System.out.println("c=" + c);
						if (alwaysPrime(primes, a, b, c)) {
							for(long d = primes.nextPrime(c); d < MAX; d = primes.nextPrime(d)) {
								if (alwaysPrime(primes, a, b, c, d)) {
									System.out.println("abcd: " + a + ", " + b + ", " + c + ", " + d);
									for(long e = primes.nextPrime(d); e < MAX; e = primes.nextPrime(e)) {
										if (alwaysPrime(primes, a, b, c, d, e)) {
											long sum = a + b + c + d + e;
											if (sum < lowestSum) {
												lowestSum = sum;
												System.out.println(lowestSum + ": " + a + ", " + b + ", " + c + ", " + d + ", " + e);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("Done");
		System.out.println(lowestSum);
	}

	private static boolean alwaysPrime(Primes primes, long ... p) {
		for (int i = 0; i < p.length - 1; i++) {
			int j = p.length - 1;
			String s1 = Long.toString(p[i], 10);
			String s2 = Long.toString(p[j], 10);
			if (!primes.isPrime(Long.valueOf(s1 + s2))) {
				return false;
			}
			if (!primes.isPrime(Long.valueOf(s2 + s1))) {
				return false;
			}
		}
		return true;
	}
}

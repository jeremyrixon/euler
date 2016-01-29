package org.rixon.euler;

public class Euler072 {
	
	public static void main(String[] args) {

		int N = 12000;
		int[] primes = new Sieve(N).getPrimes();
		int count = 0;
		
		for (int d = 1; d <= N; d++) {
			for (int n = 1; 2 * n < d; n++) {
				if (n * 3 > d && Util.areCoprime(n, d, primes)) {
					//System.out.format("%d/%d%n", n, d);
					count++;
				}
			}
		}
		System.out.println(count);
		
/*		
		long count = 0;
		for (int i = 2; i <= N; i++) {
			count += Util.totient(i, primes);
		}
		System.out.println(count);
*/
	}
}

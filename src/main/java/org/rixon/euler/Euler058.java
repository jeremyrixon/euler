package org.rixon.euler;

public class Euler058 {

	public static void main(String[] args)  {
		Primes primes = new Primes();
		long total = 1;
		long primeCount = 0;
		for (long n = 2; ; n++) {
			for (long m = 0; m <= 6; m+=2) {
				long c = ( 2 * n - 1) * (2 * n - 1) - m * (n - 1);
				///System.out.println(c);
				total++;
				if (primes.isPrime(c)) {
					primeCount++;
				}
			}
			//System.out.println("Side length:" + (n * 2 - 1));
			//System.out.println("Total:" + total);
			//System.out.println("Primes:" + primeCount);
			//double ratio =  (double) primeCount / (double) total;
			//System.out.println("Ratio:" + ratio);
			if (primeCount * 10 < total) {
				System.out.println("Side length:" + (n * 2 - 1));
				return;
			}
		}
	}
}

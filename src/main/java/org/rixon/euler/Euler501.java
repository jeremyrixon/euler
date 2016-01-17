package org.rixon.euler;
import java.math.BigInteger;


public class Euler501 {

	public static void main(String[] args) {
		BigInteger count = BigInteger.ZERO;

		/*
		 * There are 1229 primes less than 10,000.
		 */
		BigInteger a = BigInteger.valueOf(1229);
		BigInteger b = a.subtract(BigInteger.ONE);
		BigInteger c = b.subtract(BigInteger.ONE);
		count = count.add(a.multiply(b).multiply(c));
		
		/*
		 * There are 6,721,737,844 primes less than or equal to 166,666,666,666.
		 * The 6,721,737,844th prime is 166,666,666,651.
		 * There are (6,721,737,844 - 1229) primes between 1,000,000 and 166,666,666,666.
		 */
		count = count.add(BigInteger.valueOf(6721737844l - 1229l));

		/*
		 * There are 2,792,083,254 primes less than or equal to 66,666,666,666
		 * The 2,792,083,254th prime is 66,666,666,643.

		 */
		
		
		Primes p = new Primes();
		System.out.println(p.getPrime(1229));
		System.out.println(p.getPrime(1230));
		
		System.out.println(p.getPrime(1000000));

		/*
		long count = 0;
		long prime1, prime2, prime3;
		for (long p1 = 0; (prime1 = p.getPrime(p1)) <= n/4; p1++) {
			for (long p2 = p1 + 1; (prime2 = p.getPrime(p2)) * prime1 <= n/2; p2++) {
				for (long p3 = p2 + 1; (prime3 = p.getPrime(p3)) *  prime1 * prime2  <= n; p3++) {
					count++;
					//System.out.println(prime1 + " * " + prime2 + " * " + prime3 + " = " + prime1 * prime2 * prime3);
				}
			}
		}

		for (long p1 = 0; (prime1 = p.getPrime(p1)) <= n/6; p1++) {
			for (long p2 = 0; (prime2 = p.getPrime(p2)) * prime1 * prime1 * prime1 <= n; p2++) {
				if (p1 != p2) {
					count++;
					//System.out.println(prime1 + " * " + prime1 + " * " + prime1 +  " * " + prime2 + " = " + prime1 * prime1 * prime1 * prime2);
				}
			}
		}

		int p1 = 0;
		long primePow7 = 128;
		while (primePow7 <= n) {
			count++;
			//System.out.println(prime1 + "^7 = " + primePow7);
			p1++;
			prime1 = p.getPrime(p1);
			primePow7 = prime1 * prime1 * prime1 * prime1 * prime1 * prime1 * prime1;
		}

		System.out.println(count);
		*/
	}
}

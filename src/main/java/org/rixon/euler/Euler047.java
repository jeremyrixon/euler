package org.rixon.euler;

import java.util.HashSet;
import java.util.Set;

public class Euler047 {

	public static void main(String[] args) {
		Primes primes = new Primes();
		int count = 0;
		for(long n = 1; ; n++) {
			Set<Long> factors = new HashSet<Long>(primes.factors(n));
			if (factors.size() == 4) {
				count++;
				if (count == 4) {
					System.out.println(n - count + 1);
				}
			} else {
				count = 0;
			}
			//.addAll(primes.factors(n));
			//System.out.println(factors.size());
		}
	}
}

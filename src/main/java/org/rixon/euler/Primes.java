package org.rixon.euler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Primes implements Iterable<Long> {
	ArrayList<Long> primes = new ArrayList<>();
	int highestRequest = 0;

	
	public Primes() {
		primes.add(2l);
		primes.add(3l);
		highestRequest = 3;
	}

	public boolean isPrime(long n) {
		boolean lastResult;
		while (n > highestRequest) {
			highestRequest+=2;
			lastResult = addIfPrime(highestRequest);
		}
		
		return Collections.binarySearch(primes, n) >= 0;
	}

	public Long getPrime(int nth) {
		nth--;
		while (nth >= primes.size()) {
			highestRequest += 2;
			addIfPrime(highestRequest);
		}
		return primes.get((int) nth);
	}
	
	List<Long> factors(long n) {
		ArrayList<Long> f = new ArrayList<>();
		if (n < 4 || isPrime(n)) {
			f.add(n);
		} else {
			long factor = 2;
			while (factor != n) {
				if (n % factor == 0) {
					f.add(factor);
					n /= factor;
				} else {
					factor = nextPrime(factor);
				}
			}
			f.add(factor);
		}
		return f;
	}
	
	public Long nextPrime(Long p) {
		if (!isPrime(p)) {
			throw new IllegalArgumentException("Not prime: " + p);
		}
		int n = primes.indexOf(p);
		return getPrime(n + 2);
	}
	
	private boolean addIfPrime(long i) {
		for (Long prime: primes) {
			if (i % prime == 0) {
				return false;
			}
			if (prime * prime > i) {
				break;
			}
		}
		primes.add(i);
		return true;
	}

	@Override
	public PrimeIterator iterator() {
		return new PrimeIterator(this);
	}

	public int getHighestPrimeEqualOrBelow(long max) {
		if (max < 2) {
			return 1;
		}
		if (isPrime(max)) {
			return primes.indexOf(max);
		}
		
		for (int i = primes.size() - 1; ; i--) {
			if (primes.get(i) < max) {
				return i;
			}
		}
	}
}

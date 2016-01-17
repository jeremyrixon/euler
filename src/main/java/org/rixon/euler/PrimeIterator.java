package org.rixon.euler;

import java.util.Iterator;

public class PrimeIterator implements Iterator<Long> {
	private Primes primes;
	private int n = 1;

	public PrimeIterator(Primes primes) {
		this.primes = primes;
	}

	public PrimeIterator(Primes primes, int startingPrime) {
		this.primes = primes;
		this.n = startingPrime;
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Long next() {
		return primes.getPrime(n++);
	}
	
	public PrimeIterator clone() throws CloneNotSupportedException {
		PrimeIterator clone = (PrimeIterator) super.clone();
		clone.primes = this.primes;
		clone.n = this.n;
		return clone;
	}
}

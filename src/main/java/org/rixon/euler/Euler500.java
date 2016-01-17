package org.rixon.euler;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

public class Euler500 {
	Primes primes = new Primes();
	ArrayList<Integer> exponents = new ArrayList<>();
	BigInteger theNumber = BigInteger.valueOf(2);
	
	public Euler500() {
		exponents.add(1);
	}

	public static void main(String[] args) {
		Euler500 e = new Euler500();
		//e.euler(500500);
		Date before = new Date();
		e.euler(500500);
		Date after = new Date();
		long elapsed = after.getTime() - before.getTime();
		System.out.println(elapsed / 1000);
	}

	private void euler(int n) {
		for (int log2NumDivisors = 1; log2NumDivisors < n; log2NumDivisors++) {
			int lowestNextExponentNumber = exponents.size();
			BigInteger lowestNext = trialValue(lowestNextExponentNumber);
			for (int trialExponentNumber = 0; trialExponentNumber < exponents.size(); trialExponentNumber++) {
				if (trialExponentNumber == 0 || exponents.get(trialExponentNumber) < exponents.get(trialExponentNumber - 1)) {
					BigInteger trial = trialValue(trialExponentNumber);
					if (lowestNext == null || trial.compareTo(lowestNext) < 0) {
						lowestNext = trial;
						lowestNextExponentNumber = trialExponentNumber;
					}
				}
			}
			if (lowestNextExponentNumber == exponents.size()) {
				exponents.add(1);
			} else {
				exponents.set(lowestNextExponentNumber, exponents.get(lowestNextExponentNumber) * 2 + 1);
			}
			theNumber = lowestNext;
		}
		System.out.println(theNumber.mod(BigInteger.valueOf(500500507)));

	}

	private BigInteger trialValue(int trialExponentNumber) {
		int exponent = trialExponentNumber < exponents.size() ? exponents.get(trialExponentNumber) : 0;
		BigInteger p = BigInteger.valueOf(primes.getPrime(trialExponentNumber));
		return theNumber.multiply(p.pow(exponent + 1));
	}
}

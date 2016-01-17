package org.rixon.euler;
import java.util.BitSet;
import java.util.Date;


public class Eratosthenes {
	private BitSet bitset;
	private int[] wheel = {
		-1, // 0
		 0, // 1
		-1, // 2
		-1, // 3
		-1, // 4
		 1, // 5
		-1, // 6
		 2, // 7
		-1, // 8
		-1, // 9
		-1, // 10
		 3, // 11
		-1, // 12
		 4, // 13
		-1, // 14
		-1, // 15
		-1, // 16
		 5, // 17
		-1, // 18
		 6, // 19
		-1, // 20
		-1, // 21
		-1, // 22
		 7, // 23
		-1, // 24
		-1, // 25
		-1, // 26
		-1, // 27
		-1, // 28
		 8  // 29
	};
	private int innerWheelSize = 9;
	private int outerWheelSize = 30;
	private int innerSieveSize;
	private long outerSieveSize;

	
	public static void main(String[] args) {
		int n = 1000;
		while (true) {
			long before = new Date().getTime();
			Eratosthenes e = new Eratosthenes(n);
			e.sieve();
			long elapsed = new Date().getTime() - before;
			System.out.println(n + " - " + elapsed / 1000);
			n = n * 2;
		}
	}
	
	public Eratosthenes(long n) {
		outerSieveSize = n;
		innerSieveSize = (int) (((outerSieveSize + 1) / outerWheelSize) * innerSieveSize);
		bitset = new BitSet(innerSieveSize);
	}
	
	public void sieve() {
		for (int i = 7; i < Math.sqrt(outerSieveSize); i++) {
			if (isPrime(i)) {
				for (int j = i * i; j <outerSieveSize; j += i) {
					setPrime(j, false);
				}
			}
		}
	}
	
	public boolean isPrime(long n) {
		if (n < 2) {
			return false;
		}
		if (n == 2 || n == 3 || n == 5) {
			return true;
		}
		int wheelNumber = (int) (n / outerWheelSize);
		int wheelOffset = (int) (n % outerWheelSize);
		int lookup = wheel[wheelOffset];
		return lookup < 0 ? false : !bitset.get(wheelNumber * innerWheelSize + lookup);
	}

	public void setPrime(long n, boolean isPrime) {
		int wheelNumber = (int) (n / outerWheelSize);
		int wheelOffset = (int) (n % outerWheelSize);
		int lookup = wheel[wheelOffset];
		if (lookup >=0) {
			bitset.set(wheelNumber * innerWheelSize + lookup, !isPrime);
		}
	}
	
}

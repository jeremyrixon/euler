package org.rixon.euler;

public class Euler051 {
	
	public static void main(String[] args) {
		Primes primes = new Primes();
		
		int familySize = 8;
		
		for (long n = 0; ; n++) {
			String template = Long.toString(n, 11);
			if (isFamily(template, familySize, primes)) {
				System.out.println(template);
			}
			
		}
	}
	
	private static boolean isFamily(String template, int familySize, Primes primes) {
		if (!template.contains("a")) {
			return false;
		}
		int maxComposites = 10 - familySize;
		int composites = 0;
		final char[] chars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (char ch: chars) {
			if (ch == '0' && template.startsWith("a")) {
				if (++composites > maxComposites) {
					return false;
				}
			} else {
				String candidate = template.replace('a', ch);
				if (!primes.isPrime(Long.valueOf(candidate))) {
					if (++composites > maxComposites) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static long exp(long x, long n) {
		long y = 1;
		while (n > 1) {
			if ((n & 1) == 0) {
				x = x * x;
				n /= 2;
			} else {
				y = x * y;
				x = x * x;
				n = (n-1)/2;
			}
		}
		return x * y;
	}
	
}

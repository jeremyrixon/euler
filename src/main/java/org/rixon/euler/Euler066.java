package org.rixon.euler;

import java.math.BigInteger;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.ONE;

public class Euler066 {
	public static BigInteger TWO = BigInteger.valueOf(2);
	public static BigInteger THOUSAND = BigInteger.valueOf(1000);

	public static void main(String[] args)  {
		BigInteger biggestSolution = ZERO;
		BigInteger biggestD = ZERO;
		System.out.format("%40s %40s\n", "D", "x");
		for (BigInteger D = TWO; D.compareTo(THOUSAND) <= 0; D = D.add(ONE)) {
			BigInteger solution = getMinimalSolution(D);
			System.out.format("%40s %40s\n",  D, solution);
			if (solution.compareTo(biggestSolution) > 0) {
				biggestSolution = solution;
				biggestD = D;
			}
		}
		System.out.println(biggestD);
	}
	
	private static long getMinimalSolution(long D) {

		long rSolution = -1; 
		//System.out.format("\n\n%15s %15s %15s %15s %15s %15s %15s %15s\n", "D", "rn", "rSolution", "pn", "qn", "an", "Pn", "Qn");
		
		long a0 = isqrt(D);
		long pn_2 = a0;
		long qn_2 = 1;
		long rn_2 = 0;
		//System.out.format("%15d %15d %15d %15d %15d %15d\n", D, rn_2, rSolution, pn_2, qn_2, a0);

		long Pn_1 = a0;
		long Qn_1 = D - a0 * a0;
		if (Qn_1 == 0) {
			return 0;
		}
		long an_1 = (a0 + Pn_1) / Qn_1;
		long pn_1 = a0 * an_1 + 1;
		long qn_1 = an_1;
		long rn_1 = 1;
		//System.out.format("%15d %15d %15d %15d %15d %15d %15d\n", D, rn_1, rSolution, pn_1, qn_1, an_1, Pn_1, Qn_1);


		for (int i = 0; ; i++) {
			long Pn = an_1 * Qn_1 - Pn_1;
			long Qn = (D - Pn * Pn) / Qn_1;
			long an = (a0 + Pn) / Qn;
			long pn = an * pn_1 + pn_2;
			long qn = an * qn_1 + qn_2;
			long rn = rn_1 + 1;
			
			if (rSolution < 0 && an == 2 * a0) {
				if (rn_1 % 2 == 1) {
					return pn_1;
				} else {
					rSolution = 2 * rn_1 + 1;
				}
			} else {
				if (rn == rSolution) {
					return pn;
				}

			}
			
			//System.out.format("%15d %15d %15d %15d %15d %15d %15d %15d\n", D, rn, rSolution, pn, qn, an, Pn, Qn);

			
			pn_2 = pn_1;
			qn_2 = qn_1;

			Pn_1 = Pn;
			Qn_1 = Qn;
			an_1 = an;
			pn_1 = pn;
			qn_1 = qn;
			rn_1 = rn;
		}	
	}
	
	private static BigInteger getMinimalSolution(BigInteger D) {

		long rSolution = -1; 
		//System.out.format("\n\n%15s %15s %15s %15s %15s %15s %15s %15s\n", "D", "rn", "rSolution", "pn", "qn", "an", "Pn", "Qn");
		
		
		BigInteger a0 = sqrt(D);
		BigInteger pn_2 = a0;
		BigInteger qn_2 = ONE;
		long rn_2 =0;
		//System.out.format("%15d %15d %15d %15d %15d %15d\n", D, rn_2, rSolution, pn_2, qn_2, a0);

		BigInteger Pn_1 = a0;
		BigInteger Qn_1 = D.subtract(a0.multiply(a0));
		if (Qn_1.compareTo(ZERO) == 0) {
			return ZERO;
		}
		BigInteger an_1 = (a0.add(Pn_1)).divide(Qn_1);
		BigInteger pn_1 = a0.multiply(an_1).add(ONE);
		BigInteger qn_1 = an_1;
		long rn_1 = 1;
		//System.out.format("%15d %15d %15d %15d %15d %15d %15d\n", D, rn_1, rSolution, pn_1, qn_1, an_1, Pn_1, Qn_1);


		while (true) {
			BigInteger Pn = an_1.multiply(Qn_1).subtract(Pn_1);
			BigInteger Qn = D.subtract(Pn.multiply(Pn)).divide(Qn_1);
			BigInteger an = a0.add(Pn).divide(Qn);
			BigInteger pn = an.multiply(pn_1).add(pn_2);
			BigInteger qn = an.multiply(qn_1).add(qn_2);
			long rn = rn_1 + 1l;
			
			if (rSolution < 0 && an.compareTo(a0.multiply(TWO)) == 0) {
				if (rn_1 % 2 == 1) {
					return pn_1;
				} else {
					rSolution = 2 * rn_1 + 1;
				}
			} else {
				if (rn == rSolution) {
					return pn;
				}

			}
			
			//System.out.format("%15d %15d %15d %15d %15d %15d %15d %15d\n", D, rn, rSolution, pn, qn, an, Pn, Qn);
			
			pn_2 = pn_1;
			qn_2 = qn_1;

			Pn_1 = Pn;
			Qn_1 = Qn;
			an_1 = an;
			pn_1 = pn;
			qn_1 = qn;
			rn_1 = rn;
		}	
	}	

	public static boolean isPerfectSquare(long n) {
		if ((n & 0x2) == 0x2) {
			return false;
		}
		long sq = isqrt(n);
		return sq * sq == n;
	}
	
	private static long isqrt(long n) {
		  long b = 0;
		  while(n >= 0)
		  {
		    n = n - b;
		    b = b + 1;
		    n = n - b;
		  }
		  return b - 1;
	}
	
	public static BigInteger sqrt(BigInteger n) {
		BigInteger b = ZERO;
		  while(n.compareTo(ZERO) >= 0)
		  {
		    n = n.subtract(b);
		    b = b.add(ONE);
		    n = n.subtract(b);
		  }
		  return b.subtract(ONE);
	}	
	
}

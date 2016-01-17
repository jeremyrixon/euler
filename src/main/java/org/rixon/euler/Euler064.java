package org.rixon.euler;

public class Euler064 {

	public static void main(String[] args)  {
		
		int oddCount = 0;
		for (int i = 2; i <= 100; i++) {
			System.out.format("%3d %s\n", i, getContinuedFraction(i));
			int period = period(i);
			if (period != 0 && period % 2 == 1) {
				oddCount++;
			}
		}
		System.out.println(oddCount);
	}

	private static int period(int s) {
		int a0 = isqrt(s);
		int mn = 0;
		int dn = 1;
		int an = a0;

		int period = 0;
		while ((an != a0 * 2) && (a0 * a0 != s)) {
			//System.out.println("mn=" + mn + ",\tdn=" + dn + ",\tan=" + an);
			mn = dn * an - mn;
			dn = (s - (mn * mn) ) / dn;
			an = (a0 + mn) / dn;
			period++;
		}
		//System.out.println("mn=" + mn + ",\tdn=" + dn + ",\tan=" + an);
		return period;
	}
	
	private static String getContinuedFraction(int s) {
		int a0 = isqrt(s);
		int mn = 0;
		int dn = 1;
		int an = a0;
		StringBuilder stringForm = new StringBuilder("["+a0+";(");

		while ((an != a0 * 2) && (a0 * a0 != s)) {
			mn = dn * an - mn;
			dn = (s - (mn * mn) ) / dn;
			an = (a0 + mn) / dn;
			stringForm.append(an);
			stringForm.append(',');
		}
		stringForm.replace(stringForm.length()-1,stringForm.length(),")]"); // Get rid of the last comma
		return stringForm.toString();
	}
	
	private static int isqrt(int n) {
		  int b = 0;

		  while(n >= 0)
		  {
		    n = n - b;
		    b = b + 1;
		    n = n - b;
		  }

		  return b - 1;
	}

}

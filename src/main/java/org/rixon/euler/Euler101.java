package org.rixon.euler;

public class Euler101 {
	public static void main(String[] args) {
		for (long n = 1; n < 20; n++) {
			long n2 =  n * n;
			long n3 = n2 * n;
			long n4 = n3 * n;
			long n5 = n4 * n;
			long n6 = n5 * n;
			long n7 = n6 * n;
			long n8 = n7 * n;
			long n9 = n8 * n;
			long n10 = n9 * n;
			
			long u = 1 - n + n2 - n3 + n4 - n5 + n6 - n7 + n8 - n9 + n10;
			System.out.println(u);
		}
	}
}

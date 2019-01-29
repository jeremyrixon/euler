package org.rixon.euler;

public class Euler119 {
	public static void main(String[] args) {
	    long total = 0;

        System.out.println(total);
	}

	long digitSum(long n) {
	    long sum = 0;
	    while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
	    return sum;
    }
}

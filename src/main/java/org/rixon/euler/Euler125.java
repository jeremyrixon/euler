package org.rixon.euler;

import java.util.HashSet;
import java.util.Set;

public class Euler125 {

	static long N = 100000000;

	public static void main(String[] args) {

		Set<Long> all = new HashSet<>();
		for (long from = 1; from * from < N; from++) {
			for (long to = from + 1; to * to < N; to++) {
				long c = check(from, to);
				if (c > 0) {
					all.add(c);
				}
			}
		}

		long sum = 0;
		for(Long c: all) {
			sum += c;
		}
		System.out.println(sum);
	}

	private static long check(long from, long to) {
		long sum = 0;
		for (long i = from; i <= to; i++) {
			sum += i * i;
			if (sum >= N || sum < 0) {
				return 0;
			}
		}
		String s = Long.toString(sum);
		return isPalindrome(s) ? sum : 0;
	}

	private static boolean isPalindrome(String s) {
		for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}

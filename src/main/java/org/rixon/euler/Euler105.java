package org.rixon.euler;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Euler105 {
	public static void main(String[] args) throws IOException {

		long sum = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("p105_sets.txt"))) {
			for(String line = br.readLine(); line != null; line = br.readLine()) {
				String[] strings = line.split(",");
				int[] ints = new int[strings.length];
				for(int i = 0; i < strings.length; i++) {
					ints[i] = Integer.valueOf(strings[i]);
				}
				boolean b = isSSS(ints);
				System.out.format("%s: %b%n", Arrays.toString(ints), b);
				if (b) {
					for(int i: ints) {
						sum += i;
					}
				}
			}
		}
		System.out.println(sum);

	}

	private static boolean isSSS(int[] is) {

		for (int[][] subsetPair: getAllDisjointSubsetPairs(is)) {
			if (subsetPair[0].length == 0 || subsetPair[1].length == 0) {
				continue;
			}
			if (!rule1(subsetPair[0], subsetPair[1])) {
				return false;
			}
			if (!rule2(subsetPair[0], subsetPair[1])) {
				return false;
			}
		}
		return true;
	}

	private static int[][][] getAllDisjointSubsetPairs(int[] a) {
		if (a.length == 0) {
			return new int[][][] {{{},{}}};
		}

		int[][][] subsets = getAllDisjointSubsetPairs(Arrays.copyOf(a, a.length - 1));

		int[][][] retval = new int[subsets.length * 3][][];
		for (int i = 0; i < subsets.length; i++) {
			retval[i*3    ] = subsets[i];
			retval[i*3 + 1] = new int[][] { add(subsets[i][0], a[a.length -1]), subsets[i][1] };
			retval[i*3 + 2] = new int[][] { subsets[i][0], add(subsets[i][1], a[a.length -1]) };

		}

		return retval;
	}

	private static int[] add(int[] a, int i) {
		int[] b  = Arrays.copyOf(a, a.length + 1);
		b[a.length] = i;
		return b;
	}

	private static boolean rule1(int[] a, int[] b) {
		return sum(a) != sum(b);
	}

	private static boolean rule2(int[] a, int[] b) {
		if (a.length > b.length) {
			return sum(a) > sum(b);
		} else if (b.length > a.length) {
			return sum(b) > sum(a);
		} else {
			return true;
		}
	}

	private static long sum(int[] a) {
		long sum = 0;
		for (int i : a) {
			sum += i;
		}
		return sum;
	}

}

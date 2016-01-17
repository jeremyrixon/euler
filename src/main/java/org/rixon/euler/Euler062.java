package org.rixon.euler;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Euler062 {

	public static void main(String[] args)  {
		Map<String, CubeAndCount> counts = new HashMap<>();
		
		for (long n = 1; ; n++ ) {
			BigInteger cube = BigInteger.valueOf(n);
			cube = cube.multiply(cube).multiply(cube);
			String canonical = getCanonical(cube);
			CubeAndCount cac = counts.get(canonical);
			if (cac == null) {
				cac = new CubeAndCount();
				cac.cube = cube.toString();
				cac.count = 1;
				counts.put(canonical, cac);
			} else {
				cac.count++;
				if (cac.count == 5) {
					System.out.println(cac.cube);
					return;
				}
			}
		
		}
		
	}
	
	private static String getCanonical(BigInteger cube) {
		String s = cube.toString();
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return String.copyValueOf(chars);
	}

	static class CubeAndCount {
		String cube;
		int count;
	}

}

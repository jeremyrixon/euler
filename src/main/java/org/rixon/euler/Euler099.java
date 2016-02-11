package org.rixon.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Euler099 {

	public static void main(String[] args) throws IOException {
		try (
			FileReader fr = new FileReader("p099_base_exp.txt");
			BufferedReader br = new BufferedReader(fr);
		) {
			double max = 0;
			int currentlineNumber = 1;
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] a = line.split(",");
				double i =  Double.valueOf(a[1]) * Math.log(Double.valueOf(a[0]));
				if (i > max) {
					max = i;
					System.out.format("%3d %s %f%n", currentlineNumber, line, i);
				}
				currentlineNumber++;
			}
			
		}
				
	}
	
}

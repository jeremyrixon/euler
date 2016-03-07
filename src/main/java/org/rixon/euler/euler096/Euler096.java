package org.rixon.euler.euler096;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Euler096 {

	public static void main(String[] args) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("p096_sudoku.txt"))) {
			long sum = 0;
			
			for (int i = 0; i < 50; i++) {
				System.out.println(br.readLine());
			
				Sudoku s = new Sudoku();
				for (int y = 0; y < 9; y++) {
					String line = br.readLine();
					for (int x = 0; x < 9; x++) {
						s.set(x, y, line.charAt(x) - '0');
					}
				}
				//System.out.println(s);
				Sudoku solution = s.solve();
				System.out.println(solution);
				sum += solution.get(0, 0) * 100;
				sum += solution.get(1, 0) * 10;
				sum += solution.get(2, 0);
							
			}
			
			System.out.println(sum);
		}
	}

	
}




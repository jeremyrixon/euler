package org.rixon.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;

import org.apache.commons.math3.util.Combinations;

public class Euler096a {
	static BitSet takenRows = new BitSet(9);
	static BitSet takenCols = new BitSet(9);
	static BitSet takenSquares = new BitSet(9);
	static long c = 0;

	public static void main(String[] args) throws IOException {
		int count = count(1);
		
		/*
		try (BufferedReader br = new BufferedReader(new FileReader("p096_sudoku.txt"))) {
			for (int i = 0; i < 50; i++) {
				System.out.println(br.readLine());
			
				Sudoku s = new Sudoku();
				for (int y = 0; y < 9; y++) {
					String line = br.readLine();
					for (int x = 0; x < 9; x++) {
						s.set(x, y, line.charAt(x) - '0');
					}
				}
				boolean solved = s.solve();
				System.out.format("%b%n", solved);
				//for (int y = 0; y < 9; y++) {
				//	for (int x = 0; x < 9; x++) {
				//		System.out.print(s.grid[x][y]);
				//	}
				//	System.out.println();
				//}
							
			}
		}
		*/
	}
	
	private static int count(int i) {
		if (i > 9) {
			return 1;
		}
		int count = 0;
		for (int x = 0; x < 9; x++) {
			if (!takenCols.get(x)) {
				takenCols.set(x);
				for (int y = 0; y < 9; y++) {
					if (!takenRows.get(y) && !takenSquares.get((x / 3) * 3 + y / 3)) {
						takenRows.set(y);
						takenRows.set((x / 3) * 3 + y / 3);
						count += count(i + 1);
						takenRows.clear(y);
						takenRows.clear((x / 3) * 3 + y / 3);
					}
				}
				takenCols.clear(x);
			}
		}
		if (count > c) {
			System.out.println(count);
			c = count;
		}
		return count;
	}

	private static class Sudoku {
		private int[][] grid = new int[9][9];
		private int[] counts = new int[10];

		public void set(int x, int y, int value) {
			grid[x][y] = value;
			counts[value]++;
		}
		
		boolean solve() {
			for (int a = 1; a < 10; a++) {
				if (counts[a] < 9) {
					for (int x = 0; x < 9 && counts[a] < 9; x++) {
						for (int y = 0; y < 9 && counts[a] < 9; y++) {
							int v = grid[x][y];
							if (v == 0) {
								grid[x][y] = a;
								counts[a]++;
								if (isValid()) {
									boolean solved = solve();
									if (solved) {
										return true;
									}
								}
								grid[x][y] = 0;
								counts[a]--;
							}
						}
					}
				}
			}
			return false;
		}
		
		boolean isValid() {
			for (int y = 0; y < 9; y++) {
				BitSet bs = new BitSet(10);
				for (int x = 0; x < 9; x++) {
					int v = grid[x][y];
					if (v != 0 && bs.get(v)) {
						return false;
					}
					bs.set(v);
				}
			}

			for (int x = 0; x < 9; x++) {
				BitSet bs = new BitSet(10);
				for (int y = 0; y < 9; y++) {
					int v = grid[x][y];
					if (v != 0 && bs.get(v)) {
						return false;
					}
					bs.set(v);
				}
			}
			
			for (int x = 0; x < 9; x+=3) {
				for (int y = 0; y < 9; y+=3) {
					BitSet bs = new BitSet(10);
					for (int xx = 0; xx < 3; xx++) {
						for (int yy = 0; yy < 3; yy++) {
							int v = grid[x + xx][y + yy];
							if (v != 0 && bs.get(v)) {
								return false;
							}
							bs.set(v);
						}
					}
				}
			}
			
			return true;
		}
	}
}

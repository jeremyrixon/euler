package org.rixon.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Euler082 {
	static int N = 80;
	static int[][] costs = new int[N][];
	static int[][] mins  = new int[N][];

	public static void main(String[] args) throws IOException {
		
		try (
				FileReader fr = new FileReader("p082_matrix.txt");
				BufferedReader br = new  BufferedReader(fr);
		) {
			for (int y = 0; y < N; y++) {
				String[] line = br.readLine().split(",");
				costs[y] = new int[N];
				mins[y]  = new int[N];
				for (int x = 0; x < N; x++) {
					costs[y][x] = Integer.valueOf(line[x]);
					mins[y][x] = -1;
				}
			}
			
			PriorityQueue<int[]> todo = new PriorityQueue<int[]>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			for (int y = 0; y < N; y++) {
				todo.add(new int[] { y, 0, 0 });
			}
			
			while (!todo.isEmpty()) {
				int[] yxc = todo.remove();
				int y = yxc[0];
				int x = yxc[1];
				int c = yxc[2];
				if (mins[y][x] == -1) {
					c += costs[y][x];
					mins[y][x] = c;
					if (x < N - 1) {
						todo.add(new int[] { y, x + 1, c });
					}
					if (y < N - 1) {
						todo.add(new int[] { y + 1, x, c });
					}
					if (y > 0) {
						todo.add(new int[] { y - 1, x, c });
					}
				}
			}

			for (int y = 0; y < N; y++) {
				System.out.println(mins[y][N-1]);
			}
		}
	}
}

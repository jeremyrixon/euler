package org.rixon.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// A(-340,495), B(-153,-910), C(835,-947)

public class Euler102 {
	public static void main(String[] args) throws IOException {
		int count = 0;
		try (
				FileReader fr = new FileReader("p102_triangles.txt");
				BufferedReader br = new  BufferedReader(fr);
		) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] s = line.split(",");
				int[][] points = new int[][] {
					{ Integer.valueOf(s[0]),  Integer.valueOf(s[1]) },
					{ Integer.valueOf(s[2]),  Integer.valueOf(s[3]) },
					{ Integer.valueOf(s[4]),  Integer.valueOf(s[5]) }
				};
				boolean result = f102(points);	
				System.out.println(result);
				if (result) {
					count++;
				}
			}
		}
		System.out.println(count);
		
	}

	private static boolean f102(int[][] points) {
		int n = points.length;
		
		int m = 0;
		int[][][] lines = new int[n * (n - 1) / 2][2][2];
		for (int a = 1; a < n; a++) {
			for(int b = 0; b < a; b++) {
				lines[m][0] = points[a];
				lines[m][1] = points[b];
				m++;
			}
		}
		
		int[] y_intercepts = new int[2];
		int[] x_intercepts = new int[2];
		int num_x_intercepts = 0;
		int num_y_intercepts = 0;
		for (int i = 0; i < m; i++) {
			if (lines[i][0][0] * lines[i][1][0] < 0) {
				//System.out.format("Y Axis: (%d,%d) (%d,%d)%n", lines[i][0][0], lines[i][0][1], lines[i][1][0], lines[i][1][1]);
				int[] p1 = lines[i][0];
				int[] p2 = lines[i][1];
				int x1 = p1[0];
				int y1 = p1[1];
				int x2 = p2[0];
				int y2 = p2[1];
				int dx2 = x2 - x1;
				int dy2 = y2 - y1;
				int x3 = 0;
				int dx3 = x3 - x1;
				int dy3 = dx3 * dy2 / dx2;
				int y3 = y1 + dy3;
				System.out.println("Y Intercept: " + y3);
				y_intercepts[num_y_intercepts++] = y3;
			}
			if (lines[i][0][1] * lines[i][1][1] < 0) {
				//System.out.format("X Axis: (%d,%d) (%d,%d)%n", lines[i][0][0], lines[i][0][1], lines[i][1][0], lines[i][1][1]);
				int[] p1 = lines[i][0];
				int[] p2 = lines[i][1];
				int x1 = p1[0];
				int y1 = p1[1];
				int x2 = p2[0];
				int y2 = p2[1];
				int dx2 = x2 - x1;
				int dy2 = y2 - y1;
				int y3 = 0;
				int dy3 = y3 - y1;
				int dx3 = dy3 * dx2 / dy2;
				int x3 = x1 + dx3;
				System.out.println("X Intercept: " + x3);
				x_intercepts[num_x_intercepts++] = x3;
			}
		}
		boolean result = false;
		if (num_x_intercepts == 2 && x_intercepts[0] * x_intercepts[1] < 0) {
			result = true;
		}
		if (num_y_intercepts == 2 && y_intercepts[0] * y_intercepts[1] < 0) {
			result = true;
		}
		return result;
	}
}

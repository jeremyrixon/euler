package org.rixon.euler;

import java.util.Arrays;

public class NchooseK {

	public static void main(String[] args) {
		
		/*
		int[] choices = new int[] {0, 1, 2, 3, 4}; 
		int[][] p = permutations(choices);
		for (int[] permutation: p) {
			System.out.println(Arrays.toString(permutation));
		}
		System.out.println(p.length);
		*/
		

		int[][] choices = choose(10, 4);
		for (int[] choice: choices) {
			System.out.println(Arrays.toString(choice));
		}
	}

	public static int[][] choose(int n, int k) {
		int num_choices = (int) (Util.factorial(n) / Util.factorial(k) / Util.factorial(n - k));
		int[][] choices = new int[num_choices][k];
		
		int[] choice = new int[k];
		for (int i = 0; i < k; i++) {
			choice[i] = i;
		}
		
		for (int j = 0; j < num_choices; j++) {
			choices[j] = choice.clone();
			for(int i = 0; i < k; i++) {
				int min = i == 0 ? 0 : choice[i - 1] + 1;
				int max = i == k - 1 ? n : choice[i + 1];
				if (choice[i] < max - 1) {
					choice[i]++;
					break;
				} else {
					choice[i] = min;
				}
			}
		}
		return choices;
	}

	public static int[][] permutations(int[] choices) {
		int length = choices.length;
		if (length < 2) {
			return new int[][] { choices };
		}
		
		int[][] temp = permutations(Arrays.copyOf(choices, length - 1));
		int[][] permutations = new int[temp.length * length][choices.length];
		int insertion = choices[length - 1];
		for (int i = 0; i < permutations.length; i++) {
			int position = i % length;
			int k = i / length;
			for (int j = 0; j < length; j++) {
				if (j == position) {
					permutations[i][j] = insertion;
				} else {
					permutations[i][j] = j < position ? temp[k][j] : temp[k][j - 1];
				}
			}
		}
		
		return permutations;
		
	}
}

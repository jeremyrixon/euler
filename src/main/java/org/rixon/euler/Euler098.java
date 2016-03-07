package org.rixon.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Euler098 {

	public static void main(String[] args) throws IOException {
		
		TreeMap<String, ArrayList<String>> palindromes = new TreeMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("p098_words.txt"))) {
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				String[] words = line.split("\",\"|\"");
				for (String word: words) {
					if (word.length() > 0) {
						char[] chars = word.toCharArray();
						Arrays.sort(chars);
						String key = String.copyValueOf(chars);
						ArrayList<String> pals = palindromes.get(key);
						if (pals == null) {
							pals = new ArrayList<String>();
							palindromes.put(key, pals);
						}
						pals.add(word);
					}
				}
			}
		}
			
		palindromes.entrySet().removeIf(e-> e.getValue().size() == 1 );
		palindromes.entrySet().forEach(e -> System.out.format("%20s %s%n", e.getKey(), e.getValue()));

		for (Entry<String, ArrayList<String>> entry: palindromes.entrySet()) {
			if (entry.getKey().length() == 5) {
				go(entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
			}
		}
	
	}

	private static void go(String key, String a, String b) {
		ArrayList<Character> chars = new ArrayList<>();
		for (char c: key.toCharArray()) {
			if (!chars.contains(c)) {
				chars.add(c);
			}
		}
		
		int n = chars.size();
		
		int[][] choices = NchooseK.choose(10, n);
		for (int[] choice: choices) {
			// System.out.format("Choice: %s%n", Arrays.toString(choice));
			int[][] permutations = NchooseK.permutations(choice);
			for (int[] permutation: permutations) {
				String s1 = a;
				String s2 = b;
				for (int i = 0; i < n; i++) {
					s1 = s1.replace(chars.get(i), (char) ('0' + permutation[i]));
					s2 = s2.replace(chars.get(i), (char) ('0' + permutation[i]));
				}
				int n1 = Integer.valueOf(s1);
				int n2 = Integer.valueOf(s2);
				if (Util.isPerfectSquare(n1) && Util.isPerfectSquare(n2)) {
					System.out.format("%20s %20s %20s %20s %20s %20s%n", Arrays.toString(choice), Arrays.toString(permutation), a, b, s1, s2);
				}
			}
		}
	}
}

package org.rixon.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.IntUnaryOperator;

public class Euler061 {

	public static void main(String[] args)  {
		HashMap<Integer, HashMap<String, List<String>>> nums = new HashMap<>();
		
		addNums(nums, 8, n -> n * (3 * n - 2)    );
		addNums(nums, 7, n -> n * (5 * n - 3) / 2);
		addNums(nums, 6, n -> n * (2 * n - 1)    );
		addNums(nums, 5, n -> n * (3 * n - 1) / 2);
		addNums(nums, 4, n -> n * (    n    )    );
		addNums(nums, 3, n -> n * (    n + 1) / 2);

		removeDuds(nums);
		
		for (Entry<Integer, HashMap<String, List<String>>> entry: nums.entrySet()) {
			System.out.println(entry.getKey());
			for (Entry<String, List<String>> entry2: entry.getValue().entrySet()) {
				System.out.println("\t" + entry2.getKey());
				for (String s: entry2.getValue()) {
					System.out.println("\t\t" + s);
				}
			}
		}
		
		Set<Integer> alreadyUsed = new HashSet<>();
		alreadyUsed.add(8);
		for (Entry<String, List<String>> entry: nums.get(8).entrySet()) {
			for (String s: entry.getValue()) {
				if (attempt(nums, alreadyUsed, s, s.substring(0, 2))) {
					System.out.println(s);
					System.out.println();
				}
			}
		}
		
	}

	private static boolean attempt(HashMap<Integer, HashMap<String, List<String>>> nums, Set<Integer> alreadyUsed, String s, String start) {
		if (alreadyUsed.size() > 5) {
			return s.substring(2).equals(start);
		} else {
			for (Entry<Integer, HashMap<String, List<String>>> entry: nums.entrySet()) {
				if (!alreadyUsed.contains(entry.getKey())) {
					alreadyUsed.add(entry.getKey());
					List<String> nexts = entry.getValue().get(s.substring(2));
					if (nexts != null) {
						for (String next: nexts) {
							if (attempt(nums,alreadyUsed, next, start)) {
								System.out.println(next);
								return true;
							}
						}
					}
					alreadyUsed.remove(entry.getKey());
				}
			}
		}
		return false;
	}

	private static void removeDuds(HashMap<Integer, HashMap<String, List<String>>> nums) {
		Set<String> prefixes = new HashSet<>();
		for (Entry<Integer, HashMap<String, List<String>>> entry: nums.entrySet()) {
			prefixes.addAll(entry.getValue().keySet());
		}

		for (Entry<Integer, HashMap<String, List<String>>> entry: nums.entrySet()) {
			for (Entry<String, List<String>> entry2: entry.getValue().entrySet()) {
				Set<String> duds = new HashSet<>();
				for (String s: entry2.getValue()) {
					String suffix = s.substring(2);
					if (!prefixes.contains(suffix)) {
						duds.add(entry2.getKey());
					}
				}
				for (String dud: duds) {
					entry2.getValue().remove(dud);
				}
			}
		}
	}

	private static void addNums(HashMap<Integer, HashMap<String, List<String>>> nums, int i, IntUnaryOperator op) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (int n = 1, o = op.applyAsInt(n); o < 10000; n++, o = op.applyAsInt(n)) {
			if (o >= 1000) {
				String s = Integer.toString(o);
				String p = s.substring(0,  2);
				List<String> list = map.get(p);
				if (list == null) {
					list = new ArrayList<>();
					map.put(p,  list);
				}
				list.add(s);
			}
		}
		nums.put(i, map);
	}
}

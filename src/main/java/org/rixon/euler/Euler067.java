package org.rixon.euler;


public class Euler067 {
	static boolean[] taken = new boolean[10];
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			taken[i] = false;
		}
		for (int o1 = 1; o1 < 7; o1++) {
			take(o1);
			for (int o2 = o1 + 1; o2 <= 10; o2++) {
				take(o2);
				for (int o3 = o1 + 1; o3 <= 10; o3++) {
					if (taken(o3)) {
						continue;
					}
					take(o3);
					for (int o4 = o1 + 1; o4 <= 10; o4++) {
						if (taken(o4)) {
							continue;
						}
						take(o4);
						for (int o5 = o1 + 1; o5 <= 10; o5++) {
							if (taken(o5)) {
								continue;
							}
							take(o5);
							for (int i1 = 1; i1 <=10; i1++) {
								if (taken(i1)) {
									continue;
								}
								take(i1);
								for (int i2 = 1; i2 <=10; i2++) {
									if (taken(i2)) {
										continue;
									}
									take(i2);
									for (int i3 = 1; i3 <=10; i3++) {
										if (taken(i3)) {
											continue;
										}
										take(i3);
										for (int i4 = 1; i4 <=10; i4++) {
											if (taken(i4)) {
												continue;
											}
											take(i4);
											for (int i5 = 1; i5 <=10; i5++) {
												if (taken(i5)) {
													continue;
												}
												int t1 = o1 + i1 + i2;
												int t2 = o2 + i2 + i3;
												if (t1 != t2) {
													continue;
												}
												int t3 = o3 + i3 + i4;
												if (t1 != t3) {
													continue;
												}
												int t4 = o4 + i4 + i5;
												if (t1 != t4) {
													continue;
												}
												int t5 = o5 + i5 + i1;
												if (t1 != t5) {
													continue;
												}
												System.out.format("%d%d%d%d%d%d%d%d%d%d%d%d%d%d%d\n",o1,i1,i2,o2,i2,i3,o3,i3,i4,o4,i4,i5,o5,i5,i1);
											}
											release(i4);
										}
										release(i3);
									}
									release(i2);
								}
								release(i1);
							}
							release(o5);
						}
						release(o4);
					}
					release(o3);
				}
				release(o2);
			}
			release(o1);
		}
	}
	
	public static void take(int i) {
		taken[i-1] = true;
	}

	public static void release(int i) {
		taken[i-1] = false;
	}

	public static boolean taken(int i) {
		return taken[i-1];
	}
}

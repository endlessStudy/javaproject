package com.lxy.sort;

/**
 * <p>
 *
 * </p>
 * @author liuyl
 * @date 2018-11-26
 */
public class Demo {
	public static void main(String[] args) {
		// System.out.println(Integer.parseInt("0001111", 2) & 15);
		// System.out.println(Integer.parseInt("0011111", 2) & 15);
		// System.out.println(Integer.parseInt("0111111", 2) & 15);
		// System.out.println(Integer.parseInt("1111111", 2) & 15);
		// System.out.println(Integer.parseInt("1001111", 2) & 15);
       /* int a = -5;
        Integer integer = new Integer(-5);
        System.out.println(Long.parseLong("1111111111111111111111111111011", 2));
        System.out.println(Long.parseLong("1111111111111111111111111111010", 2));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString( 5));
        System.out.println(Integer.toBinaryString(15 >>> 2));
        System.out.println(Integer.toBinaryString(8 >>> 2));*/
		System.out.println(Integer.toBinaryString(-5));
		String string = "string";
		String string1 = "ri";
		System.out.println(string.indexOf(string1));
		System.out.println(string.contains(string1));
	}

	public static void bm(String string) {
		string = string.substring(1);
		long l = Long.parseLong(string, 2) - 1;
		string = String.valueOf(Long.toBinaryString(l));
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			stringBuilder.append(string.charAt(i) == 49 ? 0 : 1);
		}
		Long l1 = Long.parseLong(stringBuilder.toString(), 2);


	}
}

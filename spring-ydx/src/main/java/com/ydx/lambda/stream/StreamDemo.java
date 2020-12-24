package com.ydx.lambda.stream;

import org.springframework.scheduling.annotation.EnableAsync;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@EnableAsync
public class StreamDemo {


	public static void main(String[] args) {

		SecureRandom secureRandom = null;

		List<Integer> integerList = new ArrayList<>();

		try {
			secureRandom = SecureRandom.getInstanceStrong();
			for (int i = 0; i < 30; i++) {
				integerList.add(secureRandom.nextInt(30));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		System.out.println(integerList);
		System.out.println(test1(integerList));
		System.out.println(test2(integerList));
		System.out.println(test3(integerList));
		System.out.println(test4(integerList));

	}


	private static List<Integer> test1(List<Integer> integerList) {
		return integerList.stream().sorted((i1, i2) -> i1 - i2).collect(Collectors.toList());
	}

	private static List<Integer> test2(List<Integer> integerList) {
		return integerList.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
	}

	private static List<Integer> test3(List<Integer> integerList) {
		return integerList.stream().filter(i -> i>10).collect(Collectors.toList());
	}

	private static boolean test4(List<Integer> integerList){
		return integerList.stream().allMatch(i->i<20);
	}


}

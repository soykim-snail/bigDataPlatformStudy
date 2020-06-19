package lamdaexam_lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise3 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list);
		System.out.println("기본은 오름차순 : "+list);
		Collections.sort(list, (String s1, String s2) -> s2.compareTo(s1));
		System.out.println("내림차순으로 정렬하려면 두번째 매개변수를 기준으로 비교하는 Comparator 객체 전달 : "+list);
	}
}






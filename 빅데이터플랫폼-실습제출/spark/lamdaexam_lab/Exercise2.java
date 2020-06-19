package lamdaexam_lab;

@FunctionalInterface // 함수형 인터페이스 체크 어노테이션
interface MyNumber {
	int getMax(int num1, int num2);
}

public class Exercise2 {
	public static void main(String[] args) {
		MyNumber max = (x,y) -> (x >=y) ? x : y;
		System.out.println(max.getMax(100, 300));
	}
}

package lamdaexam_lab;

interface Calculation {
	public int add(int a, int b);
}

public class Exercise1 {
	public static void exec(Calculation com) {
		int k = 10;
		int m = 20;
		int value = com.add(k, m);
		System.out.println("덧셈 결과 : " + value);
	}

	public static void main(String[] args) {
		exec((x,y) -> x+y);
	}
}

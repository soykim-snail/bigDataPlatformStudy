package lamdaexam_lab;

interface ActionExpression {
	void exec(Object... param);
}

interface FuncExpression<T> {
	T exec(Object... param);
}

public class Exercise5 {
	public static void Test1(ActionExpression action) {
		action.exec("hello world");
	}

	public static void Test2(FuncExpression<String> func) {
		String ret = func.exec("hello world");
		System.out.println(ret);
	}

	public static void main(String[] args) throws Exception {
		Test1(data ->
				System.out.println("Test1 - " + data[0]));
		Test2(data -> {	System.out.println(data[0]); return "OK"; });
	}
}

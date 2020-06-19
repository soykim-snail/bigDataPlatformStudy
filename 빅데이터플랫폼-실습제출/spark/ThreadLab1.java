package threadexam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ThreadLab1 extends Thread{

	public static void main(String[] args) {

		ThreadLab1 t = new ThreadLab1();
//		t.setDaemon(true);
		t.start();

	}
	
	@Override
	public void run() {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		t1.start();
		t2.start();
		
		
//		두 개의 스레드를 기동한 다음에
//        3초에 한번씩 "number of milliseconds since 
//        January 1, 1970, 00:00:00 GMT" 시간을 10번 화면에 출력 

		for (int i=0; i<10; i++) {
			long milsec = new Date().getTime();
			System.out.println(milsec);
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

}

class MyThread1 extends Thread {
	
	@Override
	public void run() {
		int month = LocalDate.now().getMonthValue();
		int day = LocalDate.now().getDayOfMonth();
		for (int i=0 ; i <3 ; i++) {
			System.out.printf("오늘은 %d월 %d일 입니다.\n", month, day);
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class MyThread2 extends Thread {
	
	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			int hour = LocalTime.now().getHour();
			int min = LocalTime.now().getMinute();
			int sec = LocalTime.now().getMinute();
			
			System.out.printf("%d시 %d분 %d초 \n", hour, min, sec);
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

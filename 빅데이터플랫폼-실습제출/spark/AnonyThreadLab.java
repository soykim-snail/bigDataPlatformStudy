package innerexam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class AnonyThreadLab {

	public static void main(String[] args) {		
	
		Thread t1 = new Thread() {
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
			
		};
		Thread t2 = new Thread() {
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
		};
		t1.start();
		t2.start();		
		
		
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


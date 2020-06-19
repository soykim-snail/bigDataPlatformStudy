package lamdaexam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class LamdaThreadLab {

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			LocalDate today = LocalDate.now();
			for (int i = 0; i < 3; i++) {
				System.out.printf("오늘은 %tm월 %1$td일 입니다. \n", today);
				try {
					Thread.sleep(10 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				LocalTime now = LocalTime.now();
				System.out.printf("%tH시 %1$tM분 %1$tS초 \n", now);
				try {
					Thread.sleep(5 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		t1.start();
		t2.start();

		for (int i = 0; i < 10; i++) {
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

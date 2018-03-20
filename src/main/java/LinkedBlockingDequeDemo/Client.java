package LinkedBlockingDequeDemo;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable{
	private LinkedBlockingDeque<String> deque;
	public Client(LinkedBlockingDeque<String> deque) {
		this.deque = deque;
	}
	public void run() {
		for(int a=0;a<3;a++) {
			for(int b=0;b<5;b++) {
				try {
					deque.put(a+":"+b);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(a+":"+b+"---"+(new Date()));
			}
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

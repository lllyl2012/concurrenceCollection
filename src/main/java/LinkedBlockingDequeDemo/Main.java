package LinkedBlockingDequeDemo;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
/**
 * 阻塞式线程安全列表，LinkedBlockingDeque.（有界阻塞队列）
 * Client类使用put()将字符串插入到列表中，如果列表已经满了，
 * 则该线程被阻塞到列表有空位位置；
 * Main类使用take()将字符串取出，如果列表已空。
 * 则该线程被阻塞到列表不为空；
 * 
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {
		LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>(3);
		Client c = new Client(deque);
		Thread t = new Thread(c);
		t.start();
		
		for(int a=0;a<5;a++) {
			for(int b = 0;b<3;b++) {
				try {
					String str = deque.take();
					System.out.println("Main:"+str);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end");
	}

}

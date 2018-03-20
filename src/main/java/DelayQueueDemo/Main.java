package DelayQueueDemo;

import java.util.Date;
import java.util.concurrent.DelayQueue;
/**
 * 这是个有趣的带有延迟元素的数据结构。
 * DelayQueue：
 * 它的元素带有激活日期，在到激活日期前，这个元素是不可见的，
 * 存放在DelayQueue中的元素必须继承Delayed接口。
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {

		DelayQueue<Event> queue = new DelayQueue<Event>();
		Thread[] threads = new Thread[5];
		for(int a=0;a<5;a++) {
			Task t = new Task(a+1,queue);
			threads[a] = new Thread(t);
			threads[a].start();
		}
		for(int a=0;a<threads.length;a++) {
			try {
				threads[a].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		do {
			int counter = 0;
			Event event;
			do {
				event = queue.poll();
				if(event!=null) {counter++;}
			}while(event!=null);
			System.out.println((new Date())+"is read"+counter);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(queue.size()>0);
	}

}

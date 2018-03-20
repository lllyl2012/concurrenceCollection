package ConcurrentLinkedDequeDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
/**
 * 非阻塞式线程安全列表，ConcurrentLinkedDeque。
 * 可以并发大量线程，同时向列表写入或同时取出；
 * 在取出的时候，如果列表为空，则返回null;
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(time);
		ConcurrentLinkedDeque<String> list =	new ConcurrentLinkedDeque<String>();
		Thread[] tarr = new Thread[100];
		for(int a=0;a<100;a++) {
			AddTask t = new AddTask(list);
			tarr[a] = new Thread(t);
			tarr[a].start();
		}
		for(int a=0;a<tarr.length;a++) {
			try {
				tarr[a].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int a=0;a<100;a++) {
			PollTask t = new PollTask(list);
			tarr[a] = new Thread(t);
			tarr[a].start();
		}
		for(int a=0;a<tarr.length;a++) {
			try {
				tarr[a].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("the size of tarr:"+list.size());
		long time1 = System.currentTimeMillis();
		System.out.println((time1-time));
	}

}

package PriorityBlockingQueueDemo;

import java.util.concurrent.PriorityBlockingQueue;
/**
 * 按优先级排序的阻塞式线程安全表，PriorityBlockingQueue.
 * 有一种经典需求，要实现有一个有序列表；
 * 所有添加进PriorityBlockingQueue的元素都要实现Comparable接口中的cpmpareTo(Object o)，
 * 最终实现一个从小到大排序的列表。
 * PriorityBlockingQueue是个阻塞式的列表，如果它的方法被调用
 * 并且不能被执行时，调用这个方法的线程将被阻塞到执行成功。
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {

		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<Event>();
		Thread[] tarr = new Thread[5];
		for(int a=0;a<tarr.length;a++) {
			Task t = new Task(a,queue);
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
		for(int a=0;a<tarr.length*1000;a++) {
			Event e = queue.poll();
			System.out.println("Main:"+e.getThread()+":"+e.getPriority());
		}
		System.out.println("end");
	}

}

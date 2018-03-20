package DelayQueueDemo;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class Task implements Runnable{
	private int id;
	private DelayQueue<Event> queue;
	public Task(int id,DelayQueue<Event> queue) {
		this.id = id;
		this.queue = queue;
	}
	public void run() {
		Date now = new Date();
		Date delay = new Date();
		delay.setTime(now.getTime()+id*1000);
		System.out.println("Thread:"+id+":"+delay);
		for(int a=0;a<100;a++) {
			Event e = new Event(delay);
			queue.add(e);
		}
	}
}

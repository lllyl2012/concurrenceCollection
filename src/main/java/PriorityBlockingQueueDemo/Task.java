package PriorityBlockingQueueDemo;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable{
	private PriorityBlockingQueue<Event> queue;
	private int id;
	public Task(int id,PriorityBlockingQueue<Event> q) {
		this.queue = q;
		this.id = id;
	}
	public void run() {
		for(int a=0;a<1000;a++) {
			Event event = new Event(id,a);
			queue.add(event);
		}
	}
}

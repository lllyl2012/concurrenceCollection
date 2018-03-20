package ConcurrentLinkedDequeDemo;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable{
	private ConcurrentLinkedDeque<String> list;
	public PollTask(ConcurrentLinkedDeque<String> list) {
		this.list = list;
	}


	public void run() {
		for(int a=0;a<5000;a++) {
			list.pollFirst();
			list.pollLast();
		}
	}
}

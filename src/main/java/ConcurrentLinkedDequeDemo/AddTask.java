package ConcurrentLinkedDequeDemo;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class AddTask implements Runnable{
	private ConcurrentLinkedDeque<String> list;
	public AddTask(ConcurrentLinkedDeque<String> list) {
		this.list  = list;
	}
	

	public void run() {
		String name = Thread.currentThread().getName();
		for(int a=0;a<10000;a++) {
			list.add(name+":"+a);
		}
	}

}

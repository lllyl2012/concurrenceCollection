package ThreadLocalRandomDemo;

import java.util.concurrent.ThreadLocalRandom;

public class TaskLocalRandom implements Runnable{
	public TaskLocalRandom() {
		ThreadLocalRandom.current();
	}
	public void run() {
		for(int a=0;a<10;a++) {
			System.out.println(Thread.currentThread().getName()+":"+ThreadLocalRandom.current().nextInt(10));
		}
	}

}

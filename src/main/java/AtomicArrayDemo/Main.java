package AtomicArrayDemo;

import java.util.concurrent.atomic.AtomicIntegerArray;
/**
 * Java也引入了原子数组，提供对integer和long数字数组的原子操作。
 * 利用AtomicIntegerArray的原子数组；
 * 采取比较和交换机制不需要使用同步锁，不仅可以避免死锁，而且性能更佳；
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {

		final int THREADS = 100;
		AtomicIntegerArray arr = new AtomicIntegerArray(1000);
		Incrementer incrementer = new Incrementer(arr);
		Decrementer decrementer = new Decrementer(arr);
		Thread[] threadIncrementer = new Thread[THREADS];
		Thread[] threadDecrementer = new Thread[THREADS];
		for(int a=0;a<THREADS;a++) {
			threadIncrementer[a] = new Thread(incrementer);
			threadDecrementer[a] = new Thread(decrementer);
			
			threadIncrementer[a].start();
			threadDecrementer[a].start();
		}
		for(int a=0;a<THREADS;a++) {
			try {
				threadIncrementer[a].join();
				threadDecrementer[a].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		for(int a=0;a<arr.length();a++) {
			if(arr.get(a)!=0) {
				System.out.println("Main:arr  "+arr.get(a));
			}
		}
		System.out.println("end");
	}

}

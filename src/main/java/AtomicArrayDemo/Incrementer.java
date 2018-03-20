package AtomicArrayDemo;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Incrementer implements Runnable{
	private AtomicIntegerArray vector;
	public Incrementer(AtomicIntegerArray v) {
		this.vector = v;
	}
	public void run() {
		for(int a=0;a<vector.length();a++) {
			vector.getAndIncrement(a);
		}
	}

}

package AtomicArrayDemo;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Decrementer implements Runnable{
	private AtomicIntegerArray vector;
	public Decrementer(AtomicIntegerArray v) {
		this.vector = v;
	}
	public void run() {

		for(int a=0;a<vector.length();a++) {
			vector.getAndDecrement(a);
		}
	}
}

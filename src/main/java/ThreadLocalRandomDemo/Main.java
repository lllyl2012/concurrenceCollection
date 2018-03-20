package ThreadLocalRandomDemo;
/**
 * 在TaskLocalRandom类的构造函数中调用了ThreadLocalRandom的
 * current()方法，该方法返回与当前线程关联的ThreadLocalRandom对象，
 * 所以可以使用这个对象生成随机数。
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {
		Thread[] threads = new Thread[5];
		for(int a=0;a<threads.length;a++) {
			TaskLocalRandom t = new TaskLocalRandom();
			threads[a] = new Thread(t);
			threads[a].start();
		}
	}

}

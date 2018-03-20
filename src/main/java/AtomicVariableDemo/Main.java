package AtomicVariableDemo;
/**
 * 利用原子变量，使用CAS原子操作代替线程同步，
 * 能提高效率。AtomicLong表示一个原子Long；
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {

		Account account = new Account();
		Company c = new Company(account);
		Bank b = new Bank(account);
		Thread cthread = new Thread(c);
		Thread bthread = new Thread(b);
		cthread.start();
		bthread.start();
		
		try {
			cthread.join();
			bthread.join();
			System.out.println("Main:account"+account.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package AtomicVariableDemo;

public class Bank implements Runnable{
	private Account account;
	public Bank(Account a) {
		this.account = a;
	}
	public void run() {
		for(int a=0;a<10;a++) {
			account.subtractAmount(500);
		}
	}

}

package AtomicVariableDemo;

public class Company implements Runnable{
	private Account account;
	public Company(Account a) {
		this.account = a;
	}
	public void run() {
		for(int a=0;a<10;a++) {
			account.addAmount(1000);
		}
	}
}

package ConcurrentSkipListMapDemo;

import java.util.concurrent.ConcurrentSkipListMap;

public class Task implements Runnable{
	private ConcurrentSkipListMap<String,Contact> map;
	private String id;
	

	public Task(ConcurrentSkipListMap<String, Contact> map, String id) {
		this.map = map;
		this.id = id;
	}


	public void run() {
		for(int a=0;a<1000;a++) {
			Contact contact = new Contact(id,String.valueOf(a+1000));
			map.put(id+contact.getPhone(), contact);
		}
	}

}

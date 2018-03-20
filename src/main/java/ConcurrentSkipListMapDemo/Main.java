package ConcurrentSkipListMapDemo;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/**
 * 使用线程安全可遍历的映射，ConcurrentSkipListMap。一个非阻塞式列表。
 * 从内如实现机制上看，它使用了一个Skip List来存放数据，效率与二叉树相近;
 * @author soft01
 *
 */
public class Main {

	public static void main(String[] args) {
		ConcurrentSkipListMap<String,Contact> map = new ConcurrentSkipListMap<String,Contact>();
		Thread[] threads = new Thread[25];
		int counter = 0;
		for(char a='A';a<'Z';a++) {
			Task task = new Task(map,String.valueOf(a));
			threads[counter] = new Thread(task);
			threads[counter].start();
			counter++;
		}
		for(int a=0;a<25;a++) {
			try {
				threads[a].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Main:size of map"+map.size());
		
		Map.Entry<String, Contact> element;
		Contact contact;
		element = map.firstEntry();
		contact = element.getValue();
		System.out.println("Main: First Entry"+contact.getName()+":"+contact.getPhone());
		element = map.lastEntry();
		contact = element.getValue();
		System.out.println("Main:Last Entry"+contact.getName()+":"+contact.getPhone());
		System.out.println("Main:A1996 to B1002");
		ConcurrentNavigableMap<String,Contact> submap = map.subMap("A1996", "B1002");
		do {
			element = submap.pollFirstEntry();
			if(element!= null) {
				contact = element.getValue();
				System.out.println("  ..."+contact.getName()+":"+contact.getPhone());
			}
		}while(element!=null);
	}

}

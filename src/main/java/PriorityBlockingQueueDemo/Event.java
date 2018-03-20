package PriorityBlockingQueueDemo;

public class Event implements Comparable<Event>{
	private int thread;
	private int priority;
	public Event(int t,int p) {
		this.thread = t;
		this.priority = p;
	}
	public int getThread() {
		return thread;
	}
	public int getPriority() {
		return priority;
	}
	public int compareTo(Event e) {
		if(e.priority > this.priority) {
			return -1;
		}else if(e.priority < this.priority) {
			return 1;
		}else {
			return 0;
		}
	}
}

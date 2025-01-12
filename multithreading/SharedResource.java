package multithreading;
import java.util.*;

public class SharedResource {
	
	private Queue<Integer> q; 
	private int buffer;
	
	public SharedResource(Queue<Integer> q, int buffer) {
		this.q = q; 
		this.buffer = buffer; 
	}

	public synchronized void produce(int item) throws Exception{
		
		while(q.size() == buffer) {
			System.out.println("q is full, producer is waiting for consumer");
			
			wait(); 
		}
		
		q.offer(item); 
		
		System.out.println("Produced: "+ item);
		
		notify(); 
	}
	
	
	public synchronized void consume() throws Exception{
		
		while(q.isEmpty()) {
			System.out.println("q is empty, consumer is waiting for producer");
			
			wait(); 
		}
		
		System.out.println("consumed: "+ q.poll());
		
		notify(); 
	}
	
}

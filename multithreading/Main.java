package multithreading;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Queue<Integer> q= new LinkedList<>(); 
		
		int buffer = 2; 
		System.out.println("Program started!!");
	
		SharedResource sr = new SharedResource(q, buffer);
		
		Thread producerThread = new Thread(() -> {
			
			try {
				for(int i=0; i<5; i++) {
					sr.produce(i); 
				}
			} catch (Exception e) {
				System.out.println("Error: "+ e.getMessage());
			}
		});
		
		
		Thread consumerThread = new Thread(() -> {
			try {
				for(int i=0; i<5; i++) {
					sr.consume(); 
				}
			} catch (Exception e) {
				System.out.println("Error: "+ e.getMessage());
			}
		});
		
		
		producerThread.start();
		consumerThread.start();
		
	}
	

}

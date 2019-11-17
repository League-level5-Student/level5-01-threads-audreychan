package _03_Threaded_Reverse_Greeting;

public class ThreadedReverseGreeting {
  //Write a program that creates a thread (Thread 1) that creates another thread (Thread 2); 
  //Thread 2 creates Thread 3; and so on, up to Thread 50. 
  //Each thread should print "Hello from Thread <num>!", 
  //but you should structure your program such that the threads print their greetings in reverse order.
	
	/* HINT: You will most likely need to do this with recursion */
	//int num = -1;
	//int numDown = 50;
	
	public static void main(String[] args) {
		ThreadedReverseGreeting greet = new ThreadedReverseGreeting();
		greet.makeThread(50);
	}
	
	void makeThread(int num) {
		if(num > 0) {
			int j = num-1;
			Thread t = new Thread(()->makeThread(j));
			t.start();
		}
		System.out.println("Hello from Thread " + num);
	}
}

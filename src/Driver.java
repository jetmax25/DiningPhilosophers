import java.util.Random;
import java.util.Scanner;


public class Driver {
	
	public static void main(String[] args){
	
	int numPhilosophers = 0;
		if (args.length > 0) {
		    try {
		    	numPhilosophers = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[0] + " must be an integer.");
		        System.exit(1);
		    }
		}
	
	Random rand = new Random();
	Philosopher[] philosophers = new Philosopher[numPhilosophers];
	Scanner in = new Scanner(System.in);
	
	Chopstick[] chopsticks = new Chopstick[numPhilosophers];
	
	for(int i = 0; i < numPhilosophers; i++)
	{
		chopsticks[i] = new Chopstick(i);
	}
	
	for(int i = 0; i < numPhilosophers; i++)
	{
		philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i+1) % numPhilosophers], i, rand.nextInt(20), rand.nextInt(10));
		philosophers[i].start();
	}
	
	while(true){
		if(in.next().equals("n")){
			for(Philosopher phil: philosophers){
				phil.interrupt();
			}
			System.exit(0);
		}
	}
	}
}

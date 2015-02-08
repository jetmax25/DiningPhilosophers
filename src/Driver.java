import java.util.Random;
import java.util.Scanner;


public class Driver {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		
	Random rand = new Random();
	Philosopher[] philosophers = new Philosopher[5];
	Scanner in = new Scanner(System.in);
	
	Chopstick[] chopsticks = new Chopstick[5];
	
	for(int i = 0; i < 5; i++)
	{
		chopsticks[i] = new Chopstick(i);
	}
	
	for(int i = 0; i < 5; i++)
	{
		philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i+1) % 5], i, rand.nextInt(1), rand.nextInt(1));
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

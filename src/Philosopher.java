
public class Philosopher extends Thread{

	private int eatTime;
	private int thinkTime;
	private int id; 
	private Chopstick chopstick1, chopstick2;
	
	public Philosopher(Chopstick one, Chopstick two, int id, int think, int eat) {
		eatTime = eat;
		thinkTime = think;
		this.id = id;
		chopstick1 = one;
		chopstick2 = two; 
	}
	
	public void run(){

		while(true)
		{
			try {
				this.sleep(eatTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(id + " is now hungry");
			while(!eat()){
			}		
		}
		
	}
	
	private boolean eat(){
		if(chopstick1.setFlag()){
			if(chopstick2.setFlag()){
				
				synchronized(chopstick1){
					synchronized(chopstick2)
					{
						chopstick1.pickUp(id);
						chopstick2.pickUp(id);
						System.out.println(id + " is now eating");
						try {
							this.sleep(thinkTime);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						chopstick1.putDown(id);
						chopstick2.putDown(id);
						System.out.println(id + " is now thinking");
						chopstick2.resetFlag();
						}
						chopstick1.resetFlag();
				}
			}
			else{
				chopstick1.resetFlag();
				return false;
			}
		}
		else{
			return false;
		}
		return true;
	}
}
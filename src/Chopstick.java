
public class Chopstick {

	private int num;
	private boolean flag = false;
	
	public Chopstick(int num)
	{
		this.num = num;
	}
	
	public void pickUp(int id){

	//System.out.println("Philospher " + id + " has chopstick " + num);
	}
	
	public void putDown(int id)
	{
		//System.out.println("Philospher " + id + " put down the chopstick " + num);
	}
	
	public synchronized boolean setFlag(){
		if(!flag){
			flag = true;
			return true;
		}
		else return false;
	}
	
	public void resetFlag(){
		flag = false;
	}
}

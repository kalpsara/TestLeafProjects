package week3.day1.classroom;

public class IOS {
	/*startApp    
increaseVolume   
shutdown*/
	
	public void startApp() {
		
		System.out.println(this.getClass()+" startApp");
		
	}
	
public void increaseVolume() {
	System.out.println(this.getClass()+" increaseVolume");
		
	}

public void shutdown() {
	
	System.out.println(this.getClass()+" shutdown");
	
}



	public static void main(String[] args) {
		
		IOS iosObject1=new IOS();
		iosObject1.startApp();
		iosObject1.increaseVolume();
		iosObject1.shutdown();
		

	}

}

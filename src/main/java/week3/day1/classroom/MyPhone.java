package week3.day1.classroom;

public class MyPhone {

	/*
	 * Create Object for iPhone Confirm you can access 5 methods !! Confirm you
	 * cannot access iPad methods
	 */

	public static void main(String[] args) {

		iPhone realme = new iPhone();
		realme.makeCall();
		realme.increaseVolume();
		realme.sendSMS();
		realme.startApp();
		realme.shutdown();

		// cannot access

	}

}

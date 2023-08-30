package week3.day1.classroom;

public class Samsung extends AndroidTV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void chromeCasting() {
		System.out.println("Chrome casting overrided");
		
	}

	@Override
	public void startApp() {
		System.out.println("start app implemented in concrete class samsung");
		
	}

	@Override
	public void increaseVolume() {
		System.out.println("increaseVolumeimplemented in concrete class samsung");
		
	}

	@Override
	public void shutdown() {
		System.out.println("shutdown implemented in concrete class samsung");
		
	}

}

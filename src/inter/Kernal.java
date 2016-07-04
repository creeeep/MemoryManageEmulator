package inter;

public class Kernal {
	private static Kernal kernal;
	private Kernal(){}
	public static Kernal createNewInstance(){
		if(kernal==null)
			kernal=new Kernal();
		return kernal;
	}
	public static Kernal getInstance(){
		return kernal;
	}
	public PCB allocatePCB(){
		return null;
	}
}

package inter;

import java.util.Properties;

import tool.ConfLoader;
import tool.ConfLoader.ConfType;

public class Kernal {
	
	public final static int
		RANDOM=0,FIFO=1,LRU=2;
	
	private static Kernal kernal;
	private Kernal(){}
	
	private static int replacePolicy=RANDOM;
	public static int LABN=-1;
	public static int PABN=-1;
	
	//allcote pcb number
	private static int PidMaxIndex=0;
	public static int PageTableMaxIndex=0;
	public static Kernal createNewInstance(){
		if(kernal==null)
			kernal=new Kernal();
		
		//load conf
		Properties properties=ConfLoader.getPropertiesByConfType(ConfType.Kernal);
		LABN=Integer.valueOf(properties.getProperty("LABN"));
		PABN=Integer.valueOf(properties.getProperty("PABN"));
		switch (properties.getProperty("ReplacePolicy")) {
		case "FIFO":
			replacePolicy=FIFO;
			break;
		case "LRU":
			replacePolicy=LRU;
			break;
		case "RANDOM":
			replacePolicy=RANDOM;
			break;
		default:
			System.err.println("error data from ConfLoader.Kernal");
			break;
		}
		return kernal;
	}
	public static Kernal getInstance(){
		return kernal;
	}
	public PCB allocatePCB(){
		PidMaxIndex++;
		PageTableMaxIndex++;
		PCB pcb=new PCB(PidMaxIndex,PageTableMaxIndex);
		return pcb;
	}
}

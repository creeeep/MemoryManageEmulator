package inter;

import java.util.Properties;

import tool.ConfLoader;
import tool.ConfLoader.ConfType;

public class TLB {
	private static TLB tlb;
	private TLB(){}
	public static TLB createNewInstance(){
		if(tlb==null)
			tlb=new TLB();
		//load conf
		Properties properties=ConfLoader.getPropertiesByConfType(ConfType.TLB);
		
		return tlb;
	}
	public static TLB getInstance(){
		return tlb;
	}
}

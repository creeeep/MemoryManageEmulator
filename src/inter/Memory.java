package inter;

import java.util.ArrayList;

public class Memory {
	private ArrayList pages=new ArrayList<Page>();
	public Memory(){
		
	}
	public Page getPage(int index){
		Page p=(Page) pages.get(index);
		return p;
	}
}

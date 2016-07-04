package inter;

import java.util.ArrayList;

import tool.AccessTableLoader;

public class Process {
	private PCB pcb=null;
	private ArrayList<Integer> accessTable=null;
	private int PC=0;
	public static final int READ=0,WRITE=1;
	public Process(){
		//allocate pcb through kernal
		pcb=Kernal.getInstance().allocatePCB();
		//getAccessTable;
		accessTable=AccessTableLoader.loadAccessTableByPid(pcb.pid);
	}
	public boolean accessNext(){
		int result=MMU.getInstance().addressTranslate(pcb.ptIndex,
				accessTable.get(PC), READ, null);
		if(result==0){ //success
			
		}else if(result==-1){//page fault
			MMU.getInstance().addressTranslate(pcb.ptIndex,
					accessTable.get(PC), READ, null);
		}
		PC++;
		return true;
	}
}

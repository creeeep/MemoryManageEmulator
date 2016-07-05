package inter;

import java.util.ArrayList;
import java.util.Random;

import tool.AccessTableLoader;

public class Process {
	private PCB pcb=null;
	private ArrayList<Integer> accessTable=null;
	private ArrayList<Float>exetimeTable=null;
	private ArrayList<Float>waittimeTable=null;
	
	private int PC=0;
	private long arrivetime=0;
	public static final int READ=0,WRITE=1;
	public Process(){
		//allocate pcb through kernal
		pcb=Kernal.getInstance().allocatePCB();
		//getAccessTable;
		accessTable=AccessTableLoader.loadAccessTableByPid(pcb.pid);
		arrivetime=System.currentTimeMillis();
	}
	public boolean accessNext(){
		long pretime=System.currentTimeMillis();
		long watetime=pretime-arrivetime;
		Float watetimef=new Float(watetime);
		waittimeTable.add(PC, watetimef);
		/*int result=MMU.getInstance().addressTranslate(pcb.ptIndex,
				accessTable.get(PC), READ, null);
		if(result==0){ //success
			
		}else if(result==-1){//page fault
			MMU.getInstance().addressTranslate(pcb.ptIndex,
					accessTable.get(PC), READ, null);
		}
	
*/
		Random rantime=new Random();
		float sleeptime=rantime.nextFloat();
		try {
			Thread.sleep((long)sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long afttime=System.currentTimeMillis();
		long exetime=afttime-pretime;
		Float exetimef=new Float(exetime);
		exetimeTable.add(PC, exetimef);
		print();
		PC++;
		
		return true;
	}

	
	public void print(){
		int i;
		for(i=0;i<PC;i++){
			System.out.println(i+" "+accessTable.get(i)+""
					+ " "+"execute time="+exetimeTable.get(i)+" "+"waittime="+waittimeTable.get(i));
			
		}
	}
}

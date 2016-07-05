package test;
import inter.Kernal;
import inter.MMU;
import inter.Process;
import inter.TLB;
public class ProcessTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kernal.createNewInstance();
		MMU.cerateNewInstance();
		TLB.createNewInstance();
		Process process=new Process();
		for(int i=0;i<5;i++){
		process.accessNext();
		}

	}

}

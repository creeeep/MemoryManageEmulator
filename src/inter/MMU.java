package inter;

public class MMU {
	private static MMU mmu;
	private MMU(){}
	public static MMU cerateNewInstance(){
		if(mmu==null)
			mmu=new MMU();
		return mmu;
	}
	public static MMU getInstance(){
		return mmu;
	}
	/*
	 * @return 
	 */
	public int addressTranslate(int ptindex,int va,int accessType,String data){
		
		return 0;
	}
}

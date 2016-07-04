package inter;

public class PTE {
	public boolean validbit;
	public int ppn;
	protected int ppnbitcount=-1; 
	
	public String toString(){
		return (validbit?"1":"0") +" : "+ppn;
	}
}

package inter;

public class PTE {
	public boolean validbit;
	public int ppn;
	
	
	public String toString(){
		return (validbit?"1":"0") +" : "+ppn;
	}
}

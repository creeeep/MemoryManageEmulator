package inter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;
public class Disk {

	private int platterCount;
	private int trackCount;
	private int sectorCount;
	private String path;
	private Hashtable<Integer,String>dataTable;
	public Disk() throws IOException{
		dataTable=new Hashtable<Integer,String>();
		loadConf();
		platterCount=2;
		trackCount=8;
		sectorCount=16;
	//	Init();
	}
	private void loadConf(){}
	private void print(int address){
		int platter=address/(trackCount*sectorCount);
		int track=(address/sectorCount)%trackCount;
		int sector=address%sectorCount;
		String imfor="data in platter:"+platter+" track:"+track+" sector:"+sector;
		System.out.println(imfor);
		
	}
	/*private void Init() throws IOException{
		int address;
		String data;
		Scanner s=new Scanner( new FileReader(path));
		while(s.hasNextLine()){
			String line=s.nextLine();
			Scanner si=new Scanner(line);
			si.nextInt();
			address=si.nextInt();
			System.out.println(address);
			int platter=address/(trackCount*sectorCount);
			int track=(address/sectorCount)%trackCount;
			int sector=address%sectorCount;
			data="data in platter:"+platter+" track:"+track+" sector:"+sector;
			dataTable.put(new Integer(address), data);			
		}
	}
	
	private String dataAccess(int address){
		int platter=address/(trackCount*sectorCount);
		int track=(address/sectorCount)%trackCount;
		int sector=address%sectorCount;
		String data="data in platter:"+platter+" track:"+track+" sector:"+sector;
		dataTable.put(new Integer(address), data);
		return data;
	}
	*/
	public String read(int address){
		String data;
		data=dataTable.get(new Integer(address));
		print(address);
		return data;
	}
	public boolean writeBack(int address,String newData){
		dataTable.remove(new Integer(address));
		if(dataTable.put(new Integer(address), newData)!=null)
		{
			print(address);
			return true;
		}
		else return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Disk d=new Disk();
		
		d.writeBack(432, "new");
		d.read(432);
		
	}

}

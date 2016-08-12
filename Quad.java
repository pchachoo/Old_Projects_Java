import java.io.*;

public class Quad {
	
	private int collectionSize;
	private House HouseArray[];
	private static int count=0;
	
	public Quad()
	{
		setcollectionSize(12);
	}
	
	public Quad(int size)
	{
		setcollectionSize(size);
	}

	
	public void setcollectionSize(int size)
	{
		collectionSize=size;
		HouseArray = new House[collectionSize];
	}
	
	public int getcollectionSize()
	{
		return collectionSize;
	}
	
	public int getHouseCount()
	{
		return count;		
	}
	
	public void setHouseCount(int i)
	{
		count=count+i;		
	}
	
	
	public boolean AddHouse(House h)
	{//calls house count, compares to collectionSize to see if there is space; adds new house data if yes.
		
		int Index=getHouseCount();
		if(Index<getcollectionSize())
		{//if(h.getHouseName()!="No Name")
	//		{
				HouseArray[Index]=(House) h.clone();
				setHouseCount(1);
				return true;
	//		}
		}
		else return false;
		
	}
	
	public String toString()
	{
		String display="\n";
		display=display+"Number of Houses in Quad:"+getHouseCount()+"\n";
		for(int i=0;i<getHouseCount(); i++) //HouseCount or collectionSize? how many objects are to be printed?
		{
			display=display+"House Number #"+(i+1)+
			"\nHouse Name:"+HouseArray[i].getHouseName()+
			"\nNumber of Men:"+HouseArray[i].getMenNumber()+
			"\nNumber of Women:"+HouseArray[i].getWomenNumber()+
			"\nMale/Female Ratio:"+HouseArray[i].ratioMaleFemale()+"\n"; 
		}
		return display;
	}
	
	public void balance()
	{
		int maxRatioIndex=0;
		for(int i=1;i<getHouseCount(); i++)
			if(HouseArray[i].ratioMaleFemale()>HouseArray[maxRatioIndex].ratioMaleFemale())
				maxRatioIndex=i;
		int minRatioIndex=0;
		for(int i=1;i<getHouseCount(); i++)
			if(HouseArray[minRatioIndex].ratioMaleFemale()>HouseArray[i].ratioMaleFemale())
				minRatioIndex=i;
		
		HouseArray[maxRatioIndex].setMenNumber(HouseArray[maxRatioIndex].getMenNumber()-1);
		HouseArray[maxRatioIndex].setWomenNumber(HouseArray[maxRatioIndex].getWomenNumber()+1);
		HouseArray[minRatioIndex].setMenNumber(HouseArray[minRatioIndex].getMenNumber()+1);
		HouseArray[minRatioIndex].setWomenNumber(HouseArray[minRatioIndex].getWomenNumber()-1);
		
		writeToFile(maxRatioIndex, false); //false for max ratio, true for min ratio
		writeToFile(minRatioIndex, true);
		
	}
	public void writeToFile(int index, boolean b) //throws IOException()
	{
		File file=new File("balance.txt");
		FileOutputStream fop = null;
		try {
			fop = new FileOutputStream("balance.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		if(file.exists())
		{
			String str="";
			str=str+"House "+HouseArray[index].getHouseName()+" was balanced. \nIt lost 1 ";
			if(b==true)
			{
				str=str+"female";
			}
			else str=str+"male";
			str=str+" resident and gained 1 ";
			if(b==true)
				str=str+"male resident";
			else str=str+"female resident.\n";
			try {
				fop.write(str.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fop.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fop.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else
			System.err.println("The file does not exist");
		
		try { BufferedReader filein = new BufferedReader(new FileReader("balance.txt")); 
		String str="";
		while ((str = filein.readLine()) != null) 
		{ 	System.out.print(str+"\n"); } 
			filein.close(); 
		} 
		catch (IOException e) { System.err.print("IOException");} 
	}


}

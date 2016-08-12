
public class House {

	private String HouseName="";
	private int MenNumber=0;
	private int WomenNumber=0;
	
	public House()
	{
		setHouseName("No Name");
		setMenNumber(0);
		setWomenNumber(0);
		
	}
	
	public House(String housename, int men, int women)
	{
		setHouseName(housename);
		setMenNumber(men);
		setWomenNumber(women);
		
	}
	
	public void setHouseName(String housename)
	{
		HouseName=housename;
	}
	
	public void setMenNumber(int men)
	{
		MenNumber=men;
	}
	
	public void setWomenNumber(int women)
	{
		WomenNumber=women;
	}
	
	public String getHouseName()
	{
		return HouseName;
	}
	
	public int getMenNumber()
	{
		return MenNumber;
	}
	
	public int getWomenNumber()
	{
		return WomenNumber;
	}
	
	public Object clone()
	{
		return new House(HouseName, MenNumber, WomenNumber);
	}
	
	public double ratioMaleFemale()
	{
		if(WomenNumber!=0)
			return (double)MenNumber/WomenNumber;
		else return Double.MAX_VALUE;
	}
	
	public String toSTring()
	{
		String display="\n";
			display=display+"\nHouse Name:"+this.getHouseName()+
			"\nNumber of Men:"+this.getMenNumber()+
			"\nNumber of Women:"+this.getWomenNumber()+
			"\nMale/Female Ratio:"+ratioMaleFemale()+"\n";
		
		return display;
	}

}

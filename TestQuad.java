public class TestQuad 
{			
	public static void main(String[] args)
	{
		House h1 = new House("A", 5, 12);
 		House h2 = new House("B", 15, 4);
		House h3 = new House();
		h3.setHouseName("C"); h3.setMenNumber(10); h3.setWomenNumber(10);
		System.out.println("\nRatio: "+h1.ratioMaleFemale());
		Quad q1 = new Quad();
		q1.AddHouse(h1); 
		q1.AddHouse(h2); 
		q1.AddHouse(h3);
		System.out.println(q1);
		h1.setHouseName("D"); 
		h1.setMenNumber(18); 
		h1.setWomenNumber(16);
		q1.AddHouse(h1);
		System.out.println(q1);
		q1.balance();
		System.out.println(q1);
	}
}
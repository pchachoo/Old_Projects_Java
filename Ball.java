public class Ball {
	
	double bounce_percentage;
	final double default_bounce_percentage=.5;	
	public Ball()
	{
		bounce_percentage=default_bounce_percentage;
	}
	public Ball(double bper)
	{
		setBouncePercentage(bper);
	}

	public void setBouncePercentage(double bper)
	{
		if((bper>0.0)&&(bper<100.0))
		bounce_percentage=bper/100;
		else bounce_percentage=default_bounce_percentage;
	}
	
	public double getBouncePercentage()
	{
		return bounce_percentage;
	}
	
	public String bounceTable(double initialHeight, int bounceCount)
	{
		String disp="";
		disp=disp+"Initial Height: "+initialHeight+"\n";
		disp=disp+"\tBounce Number\t\tHeight\n";
		double height=initialHeight;
		for(int i=1; i<=bounceCount; i++)
		{
			height=height*bounce_percentage;
			disp=disp+display(i, height);
			if((height<=(initialHeight*.1))&&(height>(initialHeight*.1*bounce_percentage)))
			{
				disp=disp+"The ball has reached a height one tenth or lesser of its initial height\n";
			}
		}
		return disp;
	}
	
	public String display(int i, double h)
	{
		return "\t\t"+i+"\t\t"+h+"\n";
	}
	
	public String toString()
	{
		return "\nBounce Percentage: "+bounce_percentage;
	}
	
}


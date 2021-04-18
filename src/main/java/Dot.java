public class Dot 
{
	// yes, public  :(
	//
	public double x,y;
	public double speed = 300;
	public double alfa = 0;
	private int state = 1;

	public Dot() 
	{x=100;  y=80;
	}

	public void move(double diffSeconds)
	{ 
		x += Math.cos(alfa)*speed*diffSeconds;
		y += Math.sin(alfa)*speed*diffSeconds;

		if (state ==1) {
			alfa = 0;
			if (x >= 900) state = 2;
		}

		if (state == 2 ) {
			alfa = Math.toRadians(90);
			if (y >= 620) state = 3; 
		} 

		if( state == 3) {
			alfa = Math.toRadians(180);
			if (x<=80) state = 4;
		}

		if( state == 4) {
			alfa = Math.toRadians(270);
			if (y<=80) state = 1;
		}
	}
}
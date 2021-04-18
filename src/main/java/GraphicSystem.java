
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class GraphicSystem extends JPanel
{
  private GraphicsConfiguration graphicsConf = 
    GraphicsEnvironment.getLocalGraphicsEnvironment().
    getDefaultScreenDevice().getDefaultConfiguration();
  private BufferedImage imageBuffer;
  private Graphics      graphics;
	
  private static final Color COLOR_DOT  = new Color(96,96,255);
  private static final int   RADIUS_DOT = 20;
	
  public GraphicSystem()
  { 
	this.setSize(1000,800);  
	imageBuffer = graphicsConf.createCompatibleImage(
			        this.getWidth(), this.getHeight());	 
	graphics = imageBuffer.getGraphics();
  }
  
  public void clear()
  { graphics.setColor(Color.LIGHT_GRAY);
    graphics.fillRect(0, 0, 1000, 800);
  }
  
  public void draw(Dot dot)
  {
	int x = (int)dot.x-RADIUS_DOT;
	int y = (int)dot.y-RADIUS_DOT;
	int r = RADIUS_DOT*2;
	
	graphics.setColor(COLOR_DOT);
	graphics.fillOval(x, y, r, r);
	graphics.setColor(Color.BLACK);
	graphics.drawOval(x,y,r,r);
  }
  
  public void redraw()
  { this.getGraphics().drawImage(imageBuffer, 0, 0, this);
  }
  
}

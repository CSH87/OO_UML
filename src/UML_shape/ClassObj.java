package UML_shape;
import java.awt.Graphics;


public class ClassObj extends Object{
   
    public ClassObj(int x,int y){
        this.width = 100;
        this.height = 125;
        this.x1 = x;
        this.x2 = x + width;
        this.y1 = y;
        this.y2 = y + height;
        this.objName = "Class";
        setPorts();
    }
    public void draw(Graphics g){
        g.drawRect(x1,y1,width,height);
        g.drawLine(x1, y1+height/3, x2, y1+height/3);
        g.drawLine(x1, y2-height/3, x2, y2-height/3);
        int stringWidth = g.getFontMetrics(font).stringWidth(objName);
		double empty = (Math.abs(x1-x2) - stringWidth)/2;
		g.setFont(font);	
        g.drawString(objName, x1+ (int)empty, y1+height/6);
    }
}

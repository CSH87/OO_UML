package UML_shape;
import java.awt.Graphics;

import javax.management.ObjectName;

public class ClassObj extends MyShape{
   
    public ClassObj(int x,int y){
        this.width = 100;
        this.height = 125;
        this.x1 = x;
        this.x2 = x + this.width;
        this.y1 = y;
        this.y2 = y + this.height;
        this.objName = "Class";
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

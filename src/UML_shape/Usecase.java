package UML_shape;

import java.awt.Graphics;

public class Usecase extends Object{
    public Usecase(int x1, int y1) {
		this.width = 120;
		this.height = 90;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x1 + width;
		this.y2 = y1 + height;
    	this.objName = "Usecase";
		this.typeName = "Object";
		setPorts();
	}
	public void draw(Graphics g) {
		g.drawOval(x1, y1, width, height);

		// find the width for the specified string.
		int stringWidth = g.getFontMetrics(font).stringWidth(objName);
		double empty = (Math.abs(x1-x2) - stringWidth)/2;
		g.setFont(font);
		g.drawString(objName, x1 + (int)empty, y1 + 50);
	}
}

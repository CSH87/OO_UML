package UML_shape;

import java.awt.Graphics;

public class AssociateLine extends Line{
    private int arrowW=10, arrowH=10;
    public AssociateLine(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void draw(Graphics g){
        g.drawLine(x1, y1, x2, y2);
        int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;
        g.drawLine(x2, y2, (int)xm, (int)ym);
        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;
        g.drawLine(x2, y2, (int)xn, (int)yn);
    }
}

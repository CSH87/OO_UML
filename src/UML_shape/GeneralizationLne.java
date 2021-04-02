package UML_shape;

import java.awt.Graphics;

public class GeneralizationLne extends Line{
  private int arrowW=10, arrowH=10;
  public GeneralizationLne(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }
  public void draw(Graphics g){

    int dx = x2 - x1, dy = y2 - y1;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
    double sin = dy/D, cos = dx/D;
    double xEnd,yEnd;
    x = xm*cos - ym*sin + x1;
    ym = xm*sin + ym*cos + y1;
    xm = x;

    x = xn*cos - yn*sin + x1;
    yn = xn*sin + yn*cos + y1;
    xn = x;
    int[] xpoints = {x2, (int) xm, (int) xn};
    int[] ypoints = {y2, (int) ym, (int) yn};
    xEnd = (xm+xn)/2;
    yEnd = (ym+yn)/2;
    g.drawLine(x1, y1,(int) xEnd,(int) yEnd);
    g.drawPolygon(xpoints, ypoints, 3);

  }
}

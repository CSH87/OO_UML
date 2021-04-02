package UML_shape;

import java.awt.Graphics;

public class CompositionLine extends Line{
  private int diamondW=10, diamondH=10;
  public CompositionLine(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }
  public void draw(Graphics g){
    int dx = x2 - x1, dy = y2 - y1;
    double D = Math.sqrt(dx*dx + dy*dy);
    double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
    double xd,yd;
    double sin = dy/D, cos = dx/D;
    x = xm*cos - ym*sin + x1;
    ym = xm*sin + ym*cos + y1;
    xm = x;

    x = xn*cos - yn*sin + x1;
    yn = xn*sin + yn*cos + y1;
    xn = x;

    xd = (xm+xn)/2;
    xd = xd + xd - x2;
    yd = (ym+yn)/2;
    yd = yd + yd - y2;
    int[] xpoints = { x2, (int) xm,(int) xd, (int) xn};
    int[] ypoints = { y2, (int) ym,(int) yd, (int) yn};
    g.drawLine(x1, y1,(int) xd,(int) yd);
    g.drawPolygon(xpoints, ypoints, 4);

  }
}

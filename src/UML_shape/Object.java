package UML_shape;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public abstract class Object extends MyShape{
	public Port[] ports = new Port[4];
    private int offset = 5;

    public abstract void draw(Graphics g);

    public void changeName(String name){
		this.objName = name;
	}
    @Override
    public String inside(Point p) {
		Point center = new Point();
		center.x = (x1 + x2) / 2;
		center.y = (y1 + y2) / 2;
		Point[] points = { new Point(x1, y1), new Point(x2, y1), new Point(x2, y2), new Point(x1, y2) };
		
		for (int i = 0; i < points.length; i++) {
			Polygon t = new Polygon();
			int secondIndex = ((i + 1) % 4);
			t.addPoint(points[i].x, points[i].y);
			t.addPoint(points[secondIndex].x, points[secondIndex].y);
			t.addPoint(center.x, center.y);

			if (t.contains(p)) {
				return Integer.toString(i);
			}
		}
		return null;
	}
    public void show(Graphics g) {
		for(int i = 0; i < ports.length; i++) {
			g.fillRect(ports[i].x, ports[i].y, ports[i].width, ports[i].height);
		}
	}
	public Port getPort(int portIndex) {
		return ports[portIndex];
	}
    public void setPorts(){
        int[] x = {x1+x2/2, x2+offset, x1+x2/2, x1-offset};
        int[] y = {y1-offset, y1+y2/2, y2+offset, y1+y2/2};
        for(int i = 0; i < ports.length; i++) {
			Port port = new Port();
			port.setPort(x[i], y[i], offset);
			ports[i] = port;
		}
    }
}
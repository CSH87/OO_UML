package UML_shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.Color;

public abstract class Line extends MyShape {
	public abstract void draw(Graphics g);
	private String START = "start", END = "end"; 
	public Port[] ports = new Port[2];
	private String selectedFlag = null;
	
	public void setPorts(Port p1, Port p2) {
		this.ports[0] = p1;
		this.ports[1] = p2;
	}

	public void resetStartEnd(Point p) {
		if (selectedFlag.equals(START)) {
			this.x1 = p.x;
			this.y1 = p.y;
		} else if (selectedFlag.equals(END)) {
			this.x2 = p.x;
			this.y2 = p.y;
		}
	}
	@Override
	public Port getPort(int index){
		return ports[index];
	}
	@Override
	public String getFlag(){
		return selectedFlag;
	}
	@Override
	public void show(Graphics g) {
		g.setColor(new Color(50, 171, 175));
		this.draw(g);
		g.setColor(Color.black);
	}

	@Override
	public void resetLocation() {
		this.x1 = (int) ports[0].getCenterX();
		this.y1 = (int) ports[0].getCenterY();
		this.x2 = (int) ports[1].getCenterX();
		this.y2 = (int) ports[1].getCenterY();
	}

	@Override
	public String inside(Point p) {
		int tolerance = 10;
		double distance = distanceCheck(p);
		if (distance < tolerance) {
			double distToStart = Math.sqrt(Math.pow((p.x - x1), 2) + Math.pow((p.y - y1), 2));
			double distToEnd = Math.sqrt(Math.pow((p.x - x2), 2) + Math.pow((p.y - y2), 2));
			if (distToStart < distToEnd) {
				selectedFlag = START;
			} else {
				selectedFlag = END;
			}
			return "insideLine";
		} else
			return null;
	}

	public void resetPort(Port port, Line line) {
		port.addLine(line);
		if (selectedFlag.equals(START)) {
			this.ports[0].removeLine(line);
			this.ports[0] = port;
		} else if (selectedFlag.equals(END)) {
			this.ports[1].removeLine(line);
			this.ports[1] = port;
		}
	}

	private double distanceCheck(Point p) {
		double distanceBtwStartPoint = Math.sqrt(Math.pow((double) x1 - (double) p.getX(), 2) + Math.pow((double) y1 - (double) p.getY(), 2));
		double distanceBtwEndPoint = Math.sqrt(Math.pow((double) x2 - (double) p.getX(), 2) + Math.pow((double) y2 - (double) p.getY(), 2));
		double lineDistance = Math.sqrt(Math.pow((double) x1 - (double) x2, 2) + Math.pow((double) y1 - (double) y2, 2));
		if (distanceBtwEndPoint > lineDistance || distanceBtwStartPoint > lineDistance) {
			return Math.min(distanceBtwEndPoint, distanceBtwStartPoint);
		} else {
			Line2D line = new Line2D.Double(x1, y1, x2, y2);
			double distance = line.ptLineDist(p.getX(), p.getY());
			return distance;
		}

	}

}

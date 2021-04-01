package UML_shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.Color;

public abstract class Line extends MyShape{
	public abstract void draw(Graphics g);
    public Port[] ports = new Port[2];
    private String selectedFlag = null;

    public void setPorts(Port p1, Port p2){
        this.ports[0] = p1;
        this.ports[1] = p2;
    }
	public void resetStartEnd(Point p) {
		if(selectedFlag.equals("start")){
			this.x1 = p.x;
			this.y1 = p.y;
		}
		else if(selectedFlag.equals("end")) {
			this.x2 = p.x;
			this.y2 = p.y;
		}
	}

	@Override
    public void show(Graphics g) {
		g.setColor(new Color(50, 171, 175));
		this.draw(g);
		g.setColor(Color.black);
	}
	@Override
    public void resetLocation(){
		this.x1 = (int) ports[0].getCenterX();
		this.y1 = (int) ports[0].getCenterY();
		this.x2 = (int) ports[1].getCenterX();
		this.y2 = (int) ports[1].getCenterY();
	}	
	@Override
	public String inside(Point p) {
		int tolerance = 10;
        Line2D line = new Line2D.Double(x1, y1, x2, y2);
		double distance=line.ptLineDist(p.getX(), p.getY());

		if(distance < tolerance) {
			double distToStart = Math.sqrt(Math.pow((p.x - x1),2) + Math.pow((p.y - y1), 2));
			double distToEnd = Math.sqrt(Math.pow((p.x - x2),2) + Math.pow((p.y - y2), 2));
			if(distToStart < distToEnd) {
				selectedFlag = "start";
			}
			else{
				selectedFlag = "end";
			}
			return "insideLine";
		}
		else
			return null;
	}
	public void resetPort(Port port, Line line) {
		port.addLine(line);
		if(selectedFlag.equals("start")){
			this.ports[0].removeLine(line);
			this.ports[0] = port;
		}
		else if(selectedFlag.equals("end")){
			this.ports[1].removeLine(line);
			this.ports[1] = port;
		}	
	}

    
}

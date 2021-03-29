package UML_shape;

import java.awt.Graphics;

public abstract class Line extends MyShape{
	public abstract void draw(Graphics g);
    public Port[] ports = new Port[2];
    public void setPorts(Port p1, Port p2){
        this.ports[0] = p1;
        this.ports[1] = p2;
    }
    public void resetLocation(){
		this.x1 = (int) ports[0].getCenterX();
		this.y1 = (int) ports[0].getCenterY();
		this.x2 = (int) ports[1].getCenterX();
		this.y2 = (int) ports[1].getCenterY();
	}

}

package UML_shape;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public abstract class MyShape {
    public int x1,x2,y1,y2,width,height;
    public String objName="Object Name";
	public Font font = new Font(Font.DIALOG, Font.BOLD, 14);
    public boolean group_selected = false;
    public int getX1(){
        return x1;
    }
    public int getX2(){
        return x2;
    }
    public int getY1(){
        return y1;
    }
    public int getY2(){
        return y2;
    }
    public String inside(Point p){
		return null;
	}
    public Port getPort(int portIndex){
		return null;
	}
    public abstract void draw(Graphics g);
    public void changeName(String name){}
    public void show(Graphics g){}
    public void resetSelectedShape(){}
    public void resetLocation(){}
	public void resetLocation(int moveX, int moveY){}
    public int getShapeID(Point p){
        return -1;
    }
    public MyShape getSelectedShape(){
        return null;
    }
    public String getSelectName() {
        return null;
    }
}

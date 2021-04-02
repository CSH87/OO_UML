package UML_shape;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Point;

public class Group extends MyShape{
    private List<MyShape> groupShapes = new ArrayList<MyShape>();
    private Rectangle bounds = new Rectangle();
    private MyShape selectedShape = null;
    private int shapeID = -1;
    public void draw(Graphics g){
        for(int i = 0 ; i < groupShapes.size(); i++){
            MyShape shape = groupShapes.get(i);
            shape.draw(g); 
        }
    }
    @Override
    public void show(Graphics g) {
		int alpha = 85; 
		int offset = 10;
		g.setColor(new Color(110, 219, 181, alpha));
		g.fillRect(bounds.x - offset, bounds.y - offset, bounds.width + offset * 2, bounds.height + offset * 2);
		g.setColor(Color.black);
        for(int i = 0 ; i < groupShapes.size() ; i++){
            MyShape shape = groupShapes.get(i);
            shape.show(g);
        }
        g.setColor(Color.white); 
	}
    @Override
    public String inside(Point p){
        for(int i = 0 ; i < groupShapes.size() ; i++){
            MyShape shape = groupShapes.get(i);
            String judgeInside = shape.inside(p);
            if(judgeInside != null){
                selectedShape = shape;
                return "insideGroup";
            }
        }
        return null;
    }
    public void setBounds(){
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        for(int i = 0 ; i < groupShapes.size() ; i++){
            MyShape shape = groupShapes.get(i);
            this.shapeID = i;
            //choose the left_up point and right_down point
            if(shape.getX1() < x1){
                x1 = shape.getX1();
            }
            if(shape.getX2() > x2){
                x2 = shape.getX2();
            }
            if(shape.getY1() < y1){
                y1 = shape.getY1();
            }
            if(shape.getY2() > y2){
                y2 = shape.getY2();
            }
        }
        bounds.setBounds(x1,y1,Math.abs(x1-x2),Math.abs(y1-y2));
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    @Override
    public void resetLocation(int moveX, int moveY) {
		for (int i = 0; i < groupShapes.size(); i++) {
			MyShape shape = groupShapes.get(i);
			shape.resetLocation(moveX, moveY);
		}
		resetBounds(moveX, moveY);
	}
    protected void resetBounds(int moveX, int moveY) {
		bounds.setLocation(bounds.x + moveX, bounds.y + moveY);
		x1 = bounds.x;
		y1 = bounds.y;
		x2 = bounds.x + bounds.width;
		y2 = bounds.y + bounds.height;
	}
    @Override
	public void resetSelectedShape() {
		selectedShape = null;
	}
	@Override
	public MyShape getSelectedShape() {
		return selectedShape;
	}
    @Override
    public int getShapeID(){
        System.out.println("Group getShapeID");
        return shapeID;
    }

	public void addShapes(MyShape shape) {
		groupShapes.add(shape);
	}

	public List<MyShape> getShapes() {
		return groupShapes;
	}
}

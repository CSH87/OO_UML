package UML_Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Rectangle;

import org.graalvm.compiler.core.common.RetryableBailoutException;

import UML_shape.MyShape;

public class SelectMode extends Mode{
    private List<MyShape> shapes;
    private Point startP = null;
    public void mousePressed(MouseEvent e){
        System.out.println("Select mode");
        canvas.SelectedArea =new Rectangle();
        startP = e.getPoint();
        shapes = canvas.getShapeList();
        System.out.println(shapes.size());
        for(int i = 0;i<shapes.size();i++){
            MyShape shape = shapes.get(i);
            if (shape.inside(e.getPoint()) != null){
                System.out.println("Inside");
                canvas.selectedObj = shape;
                break;
            }
        }
        canvas.repaint();
    }
    public void mouseDragged(MouseEvent e){
        int moveX = e.getX() - startP.x;
        int moveY = e.getY() - startP.y;
        if(canvas.selectedObj != null){

        }
        else{
            System.out.println("drag");
			if (e.getX() > startP.x && e.getY() > startP.y){
				canvas.SelectedArea.setBounds(startP.x, startP.y, Math.abs(moveX), Math.abs(moveY));
            }
            else if(e.getX() < startP.x && e.getY() > startP.y){
				canvas.SelectedArea.setBounds(e.getX(), startP.y, Math.abs(moveX), Math.abs(moveY));
            }
            else if(e.getX() > startP.x && e.getY() < startP.y){
                canvas.SelectedArea.setBounds(startP.x, e.getY(), Math.abs(moveX), Math.abs(moveY));
            }
            else{
                canvas.SelectedArea.setBounds(e.getX(), e.getY(), Math.abs(moveX), Math.abs(moveY));
            }
        }
        canvas.repaint();
    }
}

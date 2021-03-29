package UML_Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import UML_shape.MyShape;

public class SelectMode extends Mode{
    private List<MyShape> shapes;
    public void mousePressed(MouseEvent e){
        shapes = canvas.getShapeList();
        System.out.println("mouse press");
        for(int i = 0;i<shapes.size();i++){
            MyShape shape = shapes.get(i);
            if (shape.inside(e.getPoint()) != null){
                canvas.selectedObj = shape;
                break;
            }
        }
        canvas.repaint();
    }
}

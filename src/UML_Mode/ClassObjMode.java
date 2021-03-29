package UML_Mode;
import UML_shape.MyShape;
import java.awt.event.MouseEvent;


public class ClassObjMode extends Mode{
    private String objtype = null;
    private ShapeFactory factory = new ShapeFactory();
    public ClassObjMode(String object){
        this.objtype = object;
    }
    @Override
    public void mouseClicked(MouseEvent e){        
        MyShape shape = factory.createObj(objtype, e.getPoint());
        System.out.println("press");
        canvas.addShape(shape);
		canvas.repaint();
    }
}
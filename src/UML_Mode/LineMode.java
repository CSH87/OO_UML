package UML_Mode;
import UML_shape.MyShape;
import java.awt.Point;
import UML_shape.Line;
import java.awt.event.MouseEvent;
import java.awt.Point;
public class LineMode extends Mode{
	private String lineType = null;
	private ShapeFactory factory = new ShapeFactory();
	private Point startP = null;
    public LineMode(String lineType){
        this.lineType = lineType;
    }
    @Override
    public void mousePressed(MouseEvent e){        
        startP = e.getPoint();
    }
    public void mouseDragged(MouseEvent e){
        if (startP != null) {
			MyShape line = factory.createLine(lineType, startP, e.getPoint());
            canvas.tempLine = line;
			canvas.repaint();
		}
    }
    public void mouseReleased(MouseEvent e){
        Point endP = null;
        if(startP != null){
            MyShape line = factory.createLine(lineType, startP, e.getPoint());
            canvas.addShape(line);
            
            canvas.tempLine = null;
            canvas.repaint();
            startP = null;
        }
    }

}

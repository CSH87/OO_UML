package UML_Mode;
import UML_shape.MyShape;
import UML_shape.Line;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

public class LineMode extends Mode{
	private String lineType = null;
	private ShapeFactory factory = new ShapeFactory();
	private Point startP = null;
    private List<MyShape> shapes;
    private MyShape shapeStart = null ,shapeEnd = null;
    private int startPortIndex =-1, endPortIndex = -1;
    private int tmpForShapeIDStart =-1, tmpForShapeIDEnd = -1;
    public LineMode(String lineType){
        this.lineType = lineType;
    }
    @Override
    public void mousePressed(MouseEvent e){        
        shapes = canvas.getShapeList();
        startP = pointOnObj(e.getPoint(), "start");
    }
    @Override
    public void mouseDragged(MouseEvent e){
		if(startP != null){
            MyShape line = factory.createLine(lineType, startP, e.getPoint());
            canvas.tempLine = line;
            canvas.repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e){
        Point endP = null;
        if(startP != null){
            endP = pointOnObj(e.getPoint(), "end");
            if(endP != null){
                if(tmpForShapeIDEnd != tmpForShapeIDStart){
                    Line line = factory.createLine(lineType, startP, endP);
                    canvas.addShape(line);
                    line.setPorts(shapeStart.getPort(startPortIndex),shapeEnd.getPort(endPortIndex));
                    shapeStart.getPort(startPortIndex).addLine(line);
                    shapeEnd.getPort(endPortIndex).addLine(line);
                    tmpForShapeIDStart = -1;
                    tmpForShapeIDEnd = -1;
                }
            }                

        }            
        canvas.tempLine = null;
        canvas.repaint();
        startP = null;
    }

    private Point pointOnObj(Point p, String s){
        for(int i = 0 ; i < shapes.size() ; i++){
            MyShape shape = shapes.get(i);
            String insideShape = shape.inside(p);
            int portIndex;
            if(insideShape != null && !insideShape.equals("insideLine")){                
                portIndex = Integer.parseInt(insideShape); 
				Point portLocation = new Point();
                if(s.equals("start")){                    
                    shapeStart = shape;
                    startPortIndex = portIndex;
                    tmpForShapeIDStart=i;
                }
                else if(s.equals("end")){
                    shapeEnd = shape;
                    endPortIndex = portIndex;
                    tmpForShapeIDEnd = i;
                }
                portLocation.setLocation(shape.getPort(portIndex).getCenterX(), shape.getPort(portIndex).getCenterY());
				return portLocation;
                }
            }

        return null;
    }

}

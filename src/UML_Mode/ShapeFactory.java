package UML_Mode;
import java.awt.Point;
import UML_shape.*;
public class ShapeFactory {
    public MyShape createObj(String type, Point p){
        if(type.equals("class")){
            return new ClassObj(p.x, p.y);
        }
        return null;
    }
    public MyShape createLine(String type, Point startPoint,Point endPoint){
        if(type.equals("associate")){
            return new AssociateLine(startPoint.x,startPoint.y,endPoint.x,endPoint.y);
        }
        return null;
    }
}


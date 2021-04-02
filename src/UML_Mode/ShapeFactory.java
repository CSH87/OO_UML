package UML_Mode;
import java.awt.Point;
import UML_shape.*;
import UML_shape.Object;
public class ShapeFactory {
    public Object createObj(String type, Point p){
        if(type.equals("class")){
            return new ClassObj(p.x, p.y);
        }
        else if (type.equals("use case")){
            return new Usecase(p.x, p.y);
        }
        return null;
    }
    public Line createLine(String type, Point startPoint,Point endPoint){
        if(type.equals("associate")){
            return new AssociateLine(startPoint.x,startPoint.y,endPoint.x,endPoint.y);
        }
        else if(type.equals("generalization")){
            return new GeneralizationLne(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
        else if(type.equals("composition")){
            return new CompositionLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
        return null;
    }
}


package UML_Mode;
import UML_shape.Line;
import UML_shape.MyShape;


import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Rectangle;




public class SelectMode extends Mode{
    private List<MyShape> shapes;
    private Point startP = null;
    private String tmpInside = null;
    private Line selectedLine = null;
    private String INSIDE_LINE = "insideLine";
    @Override
    public void mousePressed(MouseEvent e){
        //initialization
        canvas.selectedArea =new Rectangle();
        canvas.selectedObj=null;
        tmpInside = null;
        canvas.selectRelease = false;
        canvas.selectGroup = null;
        startP = e.getPoint();
        shapes = canvas.getShapeList();

        for(int i = 0;i<shapes.size();i++){
            MyShape shape = shapes.get(i);
            tmpInside = shape.inside(e.getPoint());
            if (tmpInside != null && !tmpInside.equals("insideGroup")){
                canvas.selectedObj = shape;
                break;
            }
            else if(tmpInside != null && tmpInside.equals("insideGroup")){
                canvas.selectedObj = shape;
                shape = shape.getSelectedShape();
                canvas.selectGroup = shape;
                break;
            }
        }
        canvas.repaint();
    }
    @Override
    public void mouseDragged(MouseEvent e){
        int moveX = e.getX() - startP.x;
        int moveY = e.getY() - startP.y;
        if(canvas.selectedObj != null){
            if (tmpInside.equals(INSIDE_LINE)) {
				selectedLine = (Line) canvas.selectedObj;
				selectedLine.resetStartEnd(e.getPoint());
				canvas.tempLine = selectedLine;
			}
			else {
				canvas.selectedObj.resetLocation(moveX, moveY);
			}
			startP.x = e.getX();
			startP.y = e.getY();
        }
        else{

			if (e.getX() > startP.x && e.getY() > startP.y){
				canvas.selectedArea.setBounds(startP.x, startP.y, Math.abs(moveX), Math.abs(moveY));
            }
            else if(e.getX() < startP.x && e.getY() > startP.y){
				canvas.selectedArea.setBounds(e.getX(), startP.y, Math.abs(moveX), Math.abs(moveY));
            }
            else if(e.getX() > startP.x && e.getY() < startP.y){
                canvas.selectedArea.setBounds(startP.x, e.getY(), Math.abs(moveX), Math.abs(moveY));
            }
            else{
                canvas.selectedArea.setBounds(e.getX(), e.getY(), Math.abs(moveX), Math.abs(moveY));
            }
        }
        canvas.repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e){
        if (canvas.selectedObj != null) {
			// move Line object
			if (tmpInside.equals(INSIDE_LINE)) {
				selectedLine = (Line) canvas.selectedObj;
				reconnectLine(e.getPoint());
				canvas.tempLine = null;
			}
		}
        else{
            canvas.selectRelease = true;
        }
        canvas.repaint();
    }
    private void reconnectLine(Point p){
        int flag =0;
        for(int i = 0 ; i < shapes.size() ; i++){
            MyShape shape = shapes.get(i);
            String judgeInside = shape.inside(p);
            if(judgeInside != null && !judgeInside.equals(INSIDE_LINE)){
                int portIndex = Integer.parseInt(judgeInside);
                selectedLine.resetPort(shape.getPort(portIndex), selectedLine);
                selectedLine.resetLocation();
                flag = 1;
            }
        }
        if(flag == 0){
            selectedLine.resetLocation();
        }
    }
}

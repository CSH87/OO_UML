package UML_shape;
import java.util.List;
import java.util.ArrayList;
import java.awt.Rectangle;

public class Port extends Rectangle{
  private static final long serialVersionUID = 1L;
  private List<Line> lines = new ArrayList<Line>();
  private MyShape parent;
  public void setPort(int center_X, int center_Y, int offset, MyShape parent){
      int x = center_X - offset;
      int y = center_Y - offset;
      int w = offset * 2;
      int h = offset * 2;
      this.parent = parent;
      setBounds(x, y, w, h);
  }
  public void addLine(Line line) {
	  lines.add(line);
	}
  public MyShape getParent(){
    return parent;
  }
  public void removeLine(Line line) {
    lines.remove(line);
  }
  public void resetLines() {
    for(int i = 0; i < lines.size(); i++){
      Line line = lines.get(i);
      line.resetLocation();
    }
	}
}

package UML_UI;
import UML_shape.MyShape;
import UML_Mode.Mode;
import java.util.EventListener;




import java.util.List;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Canvas extends JPanel{
    private static Canvas instance = null;
	private EventListener listener = null;
	public Mode currentMode = null;
	public MyShape selectedObj = null;
	private List<MyShape> shapes = new ArrayList<MyShape>();
	public Rectangle SelectedArea = new Rectangle();
	public MyShape tempLine = null;
	private Canvas() {
		// Exists only to defeat instantiation.
		
	}
    public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}
	public void setCurrentMode(){		
		removeMouseListener((MouseListener) listener);
		removeMouseMotionListener((MouseMotionListener) listener);
		listener = currentMode;
		addMouseListener((MouseListener) listener);
		addMouseMotionListener((MouseMotionListener) listener);
	}
	public void addShape(MyShape shape) {
		shapes.add(shape);
	}
	public List<MyShape> getShapeList() {
		return this.shapes;
	}
	/*public void reset() {
		if(selectedObj != null){
			selectedObj.resetSelectedShape();   // for selected shape inside the group
			selectedObj = null;
		}
		SelectedArea.setBounds(0, 0, 0, 0);
	}*/
	public void paint(Graphics g) {
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, dim.width, dim.height);
		g.setColor(Color.black);
		//instance.setBackground(Color.black);
		for (int i = shapes.size() - 1; i >= 0; i--) {
			MyShape shape = shapes.get(i);
			shape.draw(g);
		}
		//MyShape shape = shapes.get(shapes.size()-1);
		//shape.draw(g);
		/* paint dragged line */
		if (tempLine != null) {
			tempLine.draw(g);
		}
		if (selectedObj != null) {
			selectedObj.show(g);
		}
		if (!SelectedArea.isEmpty()) {
			int alpha = 100;
			g.setColor(new Color(20, 150, 200, alpha));
			g.fillRect(SelectedArea.x, SelectedArea.y, SelectedArea.width, SelectedArea.height);
			g.setColor(new Color(20, 150, 200));
			g.drawRect(SelectedArea.x, SelectedArea.y, SelectedArea.width, SelectedArea.height);

		}
	}
}

package UML_Mode;
import UML_UI.Canvas;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public abstract class KeyboardMode implements KeyListener{
    protected Canvas canvas = Canvas.getInstance(); 

    public void keyPressed(KeyEvent e){}

    public void keyReleased(KeyEvent e){}

    public void keyTyped(KeyEvent e){}
}

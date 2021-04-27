package UML_Mode;
import java.awt.event.KeyEvent;


public class DeleteMode extends KeyboardMode{

    @Override
    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();
        switch (keyCode){
            case KeyEvent.VK_DELETE:
                if(canvas.selectedObj!=null){     
                    canvas.removeShape(canvas.selectedObj);
                    canvas.selectedObj = null;
                    canvas.repaint();
                }
                break;
            default:
                System.out.println(keyChar);
        }
    }
}

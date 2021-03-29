package UML_UI;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
public class MyMenu extends JMenuBar{
    private Canvas canvas;
    public MyMenu(){
        JMenu menu;
        JMenuItem menuItem;
        canvas = Canvas.getInstance();
        //File menu
        menu = new JMenu("File");
        add(menu);

        //Edit menu
        menu = new JMenu("Edit");
        add(menu);

        
        menuItem = new JMenuItem("Group");
        menu.add(menuItem);

        menuItem = new JMenuItem("Ungroup");
        menu.add(menuItem);

        menuItem = new JMenuItem("Change object name");
        menu.add(menuItem);
    } 
    class UngroupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Canvas.removeGroup();
        }
    }
    class GroupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Canvas.Group();
        }
    }    class ChangeNameListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ChangeNameListener();
        }
    }
}

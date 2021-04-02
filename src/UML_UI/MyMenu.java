package UML_UI;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MyMenu extends JMenuBar{
    private static final long serialVersionUID = 1L;

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
        menuItem.addActionListener(new GroupListener());

        menuItem = new JMenuItem("Ungroup");
        menu.add(menuItem);
        menuItem.addActionListener(new UngroupListener());

        menuItem = new JMenuItem("Change object name");
        menu.add(menuItem);
        menuItem.addActionListener(new ChangeNameListener());
    }
    class UngroupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            canvas.removeGroup();
        }
    }
    class GroupListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            canvas.groupShape();
        }
    }
    class ChangeNameListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            canvas.changeNameForm();
        }
    }
}

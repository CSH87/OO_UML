package UML_UI;
import UML_Mode.*;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
public class MyToolBar extends JToolBar{
    private static final long serialVersionUID = 1L;

    private int toolNum = 6;
    private Canvas canvas;
    private JButton holdBtn = null;
    public MyToolBar(){
        canvas = Canvas.getInstance();
        setLayout(new GridLayout(toolNum, 1));
        this.setBackground(Color.white);
        

        ImageIcon selectIcon = new ImageIcon("img/select.png");
        ToolBtn selectBtn = new ToolBtn("select", selectIcon, new SelectMode());
        add(selectBtn);

        ImageIcon associateIcon = new ImageIcon("img/associate.png");
        ToolBtn associateBtn = new ToolBtn("association line", associateIcon, new LineMode("associate"));
        add(associateBtn);

        ImageIcon generationIcon = new ImageIcon("img/general.png");
        ToolBtn generationBtn = new ToolBtn("generalization line", generationIcon, new LineMode("generalization"));
        add(generationBtn);

        ImageIcon compositionIcon = new ImageIcon("img/composite.png");
        ToolBtn compositionBtn = new ToolBtn("composition line", compositionIcon, new LineMode("composition"));
        add(compositionBtn);

        ImageIcon classIcon = new ImageIcon("img/class.png");
        ToolBtn classBtn = new ToolBtn("class", classIcon, new ClassObjMode("class"));
        add(classBtn);

        ImageIcon useCaseIcon = new ImageIcon("img/usecase.png");
        ToolBtn useCaseBtn = new ToolBtn("use case", useCaseIcon, new ClassObjMode("use case"));
        add(useCaseBtn);
    }

    private class ToolBtn extends JButton{
        private static final long serialVersionUID = 1L;
        private Mode toolMode;
        private String toolName;
        public ToolBtn(String toolName, ImageIcon icon, Mode toolMode){
            this.toolMode = toolMode;
            this.toolName = toolName;
            setSize(50,200);
            setBackground(Color.white);
            setToolTipText(toolName);
            setIcon(icon);
            addActionListener(new toolListener());
        }
        class toolListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(holdBtn != null){
                    holdBtn.setBackground(Color.white);
                }
                if(toolName.equals("select")){
                    canvas.setKeyMode();
                }
                holdBtn = (JButton) e.getSource();
				holdBtn.setBackground(new Color(60,170,175));
                canvas.currentMode = toolMode;
				canvas.setCurrentMode();
				canvas.reset();
				canvas.repaint();
            }
        }

    }
}

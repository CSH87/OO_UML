package UML_UI;
import javax.swing.JFrame;
import java.awt.BorderLayout;
public class UI extends JFrame{
    private static final long serialVersionUID = 1L;

    private MyToolBar toolbar;
    private Canvas canvas;
    private MyMenu menubar;
    public UI(){
        canvas = Canvas.getInstance();  
        toolbar = new MyToolBar();
        menubar = new MyMenu();
        getContentPane().setLayout(new BorderLayout());
		getContentPane().add( BorderLayout.NORTH, menubar);
		getContentPane().add( BorderLayout.WEST, toolbar);
		getContentPane().add(canvas, BorderLayout.CENTER);
    }

    public static void main(String[] args) throws Exception {
        UI app = new UI();
        app.setTitle("UML Editor");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1600,1000);
        app.setLocationRelativeTo(null);
        app.setVisible(true);

    }
}

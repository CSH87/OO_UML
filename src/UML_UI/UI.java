package UML_UI;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
public class UI extends JFrame{
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
        System.out.println("For test git");
        app.setTitle("UML Editor");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1600,1000);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
        System.out.println("Hello, World!");
    }
}

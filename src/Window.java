import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public Window(){
        this.setSize(WIDTH,HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        Scene scene = new Scene(WIDTH/3, HEIGHT/3,WIDTH/3,HEIGHT/3);
        scene.setBackground(Color.cyan);
        add(scene);
        setVisible(true);
    }
}

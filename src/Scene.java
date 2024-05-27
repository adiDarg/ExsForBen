import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Scene extends JPanel {
    int x;
    int y;
    int width;
    int height;
    private ArrayList<Car> cars;
    public Scene(int x, int y, int width, int height){
        setBounds(x,y,width,height);
        cars = new ArrayList<Car>();
        cars.add(new Car(Color.yellow,10,10));
        cars.add(new Car(Color.red, 10,100));
        this.setFocusable(true);
        this.requestFocus();
        addKeyListener(new MovementListener(cars.get(0),this));
    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        for (Car car: cars){
            car.paint(graphics);
        }
    }
}

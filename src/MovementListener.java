import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener {
    private Car car;
    private Scene scene;
    public MovementListener(Car car, Scene scene){
        this.car = car;
        this.scene = scene;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP -> car.move(0,-10);
            case KeyEvent.VK_DOWN -> car.move(0,10);
            case KeyEvent.VK_LEFT -> car.move(-10,0);
            case KeyEvent.VK_RIGHT -> car.move(10,0);
        }
        scene.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

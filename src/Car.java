import java.awt.*;

public class Car {
    private final Color color;
    private final float scale = 1F;
    private int x;
    private int y;
    public Car(Color color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }
    public void paint(Graphics graphics){
        graphics.setColor(color);
        graphics.fillRect(x,y, (int) (120*scale), (int) (50*scale));
        graphics.setColor(Color.BLACK);
        graphics.fillRect(x+60,y+7, (int) (40*scale), (int) (15*scale));
        graphics.fillOval(x+10,y+42, (int) (20*scale), (int) (20*scale));
        graphics.fillOval(x+90,y+42,(int)(20*scale),(int)(20*scale));
    }
    public void move(int deltaX, int deltaY){
        x += deltaX;
        y += deltaY;
    }
}

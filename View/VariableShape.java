import java.awt.*;



public class VariableShape extends Shape {


    public VariableShape(int x, int y){
        super(x, y);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 50);
        g.setColor(Color.black);
        g.drawRect(x, y, 100, 50);
        g.drawLine(x, y+10, x+100,y+10);
        g.drawLine(x+10, y, x+10,y+50);
    }
}

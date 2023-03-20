package Model;

import java.awt.*;

public class Arrow {
    int x1;
    int x2;
    int y1;
    int y2;

    public Arrow(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public void draw(Graphics g){
        g.drawLine(x1, y1, x2, y2);
    }


}

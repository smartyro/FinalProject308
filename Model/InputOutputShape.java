package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class InputOutputShape extends Shape{
    private static final int numPoints = 4;
    private static int length = 100;
    private static int height = 50;
    private int x1, x2, x3, x4;
    private int y1, y2, y3, y4;
 

    public InputOutputShape(int x, int y, String label){
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g) {
        x1 = getX();
        x2 = (getX() + length);
        x4 = x1 + getDistance(x1, height, length);
        x3 = x2 - getDistance(x2, height, length);

        y1 = y2 = getY();
        y3 = y4 = (getY()+height);

        int[] xArray = {x1, x4, x2, x3};
        int[] yArray = {y1, y2, y3, y4};

        Polygon p = new Polygon(xArray, yArray, numPoints);

        g.setColor(Color.WHITE);
        g.fillPolygon(p);
        g.setColor(Color.black);
        g.drawPolygon(p);
    }

    @Override
    public boolean contains(int x, int y) {
        int triDistance = (Math.abs(length - x1));
        // check if inside the square
        if ((x >= this.x1) && (x <= this.x4) && (y >= this.y1) && (y <= this.y4)){
            return true;
        }
        // check if inside the left triangle
        else if ((x >= this.x3) && (x<= this.x1) && (x >= (getDistance(x, triDistance, length)) && (y >= this.y1) && (y <= this.y4))){
            return true;
        }
        // check if inside the right triangle
        else if ((x <= this.x2) && (x<= this.x4) && (x >= (getDistance(x, triDistance, length)) + this.x4) && (y >= this.y1) && (y <= this.y4)){
            return true;
        }
        return false;
    }

    @Override
    public void drawLabel(Graphics g){
        g.drawString(this.getLabel(), this.getX() + 50, this.getY() + 25);
    }

    public int getDistance(int x, int height, int length){
        int xdist;
        double a2, b2;

        a2 = (x1 + height);
        b2 = (length - x1);

        a2 = Math.pow(a2, 2.0);
        b2 = Math.pow(b2, 2.0);

        xdist = (int)(a2 + b2);
        xdist = (int)Math.sqrt(xdist);

        return xdist;
    }
}

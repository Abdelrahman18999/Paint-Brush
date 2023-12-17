import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;

public class Line extends Applet{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public void init(){
        
        MyMouseListener Mylistner = new MyMouseListener();
        DragMouse Endlistner = new DragMouse();
        ReleaseMouse Releaselistner = new ReleaseMouse();
        this.addMouseListener(Mylistner);
        this.addMouseMotionListener(Endlistner);
        this.addMouseListener(Releaselistner);
    }

    public void paint(Graphics g){
        g.drawLine(x1, y1, x2, y2);
    }

    class MyMouseListener extends MouseAdapter {
    public void mousePressed(MouseEvent e){
        x1 = e.getX();
        y1 = e.getY();
        repaint();
    }
}

class DragMouse extends MouseMotionAdapter{
    public void mouseDragged(MouseEvent e){
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }
}

class ReleaseMouse extends MouseAdapter{
    public void mouseReleased(MouseEvent e){
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }
}

}

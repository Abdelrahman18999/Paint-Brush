import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;

public class Oval extends Applet{
    private int x;
    private int y;
    private int width;
    private int height;
    public void init(){
        
        MyMouseListener Mylistner = new MyMouseListener();
        DragMouse Endlistner = new DragMouse();
        ReleaseMouse Releaselistner = new ReleaseMouse();
        this.addMouseListener(Mylistner);
        this.addMouseMotionListener(Endlistner);
        this.addMouseListener(Releaselistner);
    }

    public void paint(Graphics g){
        g.drawOval(x, y, width, height);
    }

    class MyMouseListener extends MouseAdapter {
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        repaint();
    }
}

class DragMouse extends MouseMotionAdapter{
    public void mouseDragged(MouseEvent e){
        width = e.getX();
        height = e.getY();
        repaint();
    }
}

class ReleaseMouse extends MouseAdapter{
    public void mouseReleased(MouseEvent e){
        width = e.getX();
        height = e.getY();
        repaint();
    }
}
}

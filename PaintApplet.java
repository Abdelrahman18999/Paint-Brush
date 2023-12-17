import java.applet.Applet;
//import java.awt.Graphics;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;


public class PaintApplet extends Applet{

    public int counter = 0;
    private Shapes currentShape;
    private boolean fillNextShape = false;
    private Color colorFilled = Color.BLACK;
    
    ShapesMode currMode = new ShapesMode();

    // RECTANGLE LISTNER
    class RecListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            // if rectangle button pressed --> set current mode = RECTANGLE
            currMode.setMode(currMode.RECTANGLE); 
        }
    }

    // LINE LISTNER
    class LineListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                // if line button pressed --> set current mode = LINE
                currMode.setMode(currMode.LINE); 
        }
    }


     // OVAL LISTNER
    class OvalListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                // if oval button pressed --> set current mode = Oval
                currMode.setMode(currMode.OVAL); 
        }
    }

    // FREE LINE LISTNER
    class FREEListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                currMode.setMode(currMode.FREE_LINE); 
        }
    }


    // RGB LISTNERS
    class RedListner implements ActionListener {
            public void actionPerformed(ActionEvent e){
                colorFilled = Color.RED;
        }
    }
    class GreenListner implements ActionListener {
            public void actionPerformed(ActionEvent e){
                colorFilled = Color.GREEN;
        }
    }
    class BlueListner implements ActionListener {
            public void actionPerformed(ActionEvent e){
                colorFilled = Color.BLUE;
        }
    }

      // listner for fill button
    class FillListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int currState = e.getStateChange();
            if (currState == 1){
                if (currentShape != null) {
                    fillNextShape = true;
                }
            }
            else {
                if (currentShape != null) {
                    fillNextShape = false;
                }
                
            }
        }
    }


    // ERASER LISTNER
    class EarListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            currMode.setMode(currMode.Eraser); 
        }
    }

    // Clear All
    class ClearListener implements ActionListener {
            public void actionPerformed(ActionEvent e){
                shapesList.clear(); 
                repaint();
        }
    }

    // Array list
    ArrayList<Shapes> shapesList = new ArrayList<>();

    public void init(){

        // ******* RECTANGLR ************

        Button rectangle_btn = new Button("Rectangle");
        // Rctangle Button listner
        RecListener recListner = new RecListener();
        // registeration the source with the listner
        rectangle_btn.addActionListener(recListner);
        add(rectangle_btn);


        // ******* LINE ************

        Button line_btn = new Button("Line");
        LineListener lineListner = new LineListener();
        line_btn.addActionListener(lineListner);
        add(line_btn);


        // ******* OVAL ************

        Button oval_btn = new Button("Oval");
        OvalListener ovalListner = new OvalListener();
        oval_btn.addActionListener(ovalListner);
        add(oval_btn);


        // FREE LINE
        Button free_btn = new Button("Free Line");
        FREEListener freeListner = new FREEListener();
        free_btn.addActionListener(freeListner);
        add(free_btn);


        // ******* FILL ************

        Checkbox fill_check = new Checkbox("Fill");
        FillListener fillListner = new FillListener();
        fill_check.addItemListener(fillListner);
        add(fill_check);


        // ************ RGB **************

        // RED
        Button red_btn = new Button("RED");
        RedListner redListner = new RedListner();
        red_btn.addActionListener(redListner);
        add(red_btn);

        // GREEN
        Button green_btn = new Button("GREEN");
        GreenListner greenListner = new GreenListner();
        green_btn.addActionListener(greenListner);
        add(green_btn);

        // BLUE
        Button blue_btn = new Button("BLUE");
        BlueListner blueListner = new BlueListner();
        blue_btn.addActionListener(blueListner);
        add(blue_btn);

        // Eraser
        Button ear_btn = new Button("Eraser");
        EarListener earListner = new EarListener();
        ear_btn.addActionListener(earListner);
        add(ear_btn);

        // Clear
        Button clear_btn = new Button("Clear All");
        ClearListener clearListner = new ClearListener();
        clear_btn.addActionListener(clearListner);
        add(clear_btn);



        //Mouse Listneres
        PressMouse Mylistner = new PressMouse();
        DragMouse Endlistner = new DragMouse();
        ReleaseMouse Releaselistner = new ReleaseMouse();
        this.addMouseListener(Mylistner);
        this.addMouseMotionListener(Endlistner);
        this.addMouseListener(Releaselistner);
    }


    public void paint(Graphics g){
        for (Shapes shape : shapesList){
            shape.draw(g);
        }

    }

    class PressMouse extends MouseAdapter {
        public void mousePressed(MouseEvent e){

            switch (currMode.currentMode) {
                case 1:
                    currentShape = new Rectangle(0, 0, 0, 0);
                    shapesList.add(currentShape);
                    break;

                case 2:
                    currentShape = new Oval(0, 0, 0, 0);
                    shapesList.add(currentShape);
                    break;

                case 3:
                    currentShape = new Line(0, 0, 0, 0);
                    shapesList.add(currentShape); 
                    break;

                case 4:
                    currentShape = new Eraser(0, 0, 0, 0);
                    //shapesList.add(currentShape); 
                    break;

                case 5:
                    currentShape = new FreeLine(0, 0, 0, 0);
                    //shapesList.add(currentShape); 
                    break;

                default:
                    break;
            }
            if(currMode.currentMode != 4 && currMode.currentMode != 5){
            if (currentShape != null) {
                currentShape.setdim1(e.getX());
                currentShape.setdim2(e.getY());
                currentShape.setSold(fillNextShape);
                currentShape.setColor(colorFilled);
            }
        }
        else{
            
        }
    }
}

    class DragMouse extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e){
            if (currMode.currentMode != 4 && currMode.currentMode != 5){
            shapesList.get(counter).setdim3(e.getX());
            shapesList.get(counter).setdim4(e.getY());
            
            }
            else{
                if (currMode.currentMode == 4){
                currentShape = new Eraser(0, 0, 0, 0);
                shapesList.add(currentShape);
                
                currentShape.setdim1(e.getX());
                currentShape.setdim2(e.getY());
                shapesList.get(counter).setdim3(currentShape.getdim1());
                shapesList.get(counter).setdim4(currentShape.getdim2());
                }
                else{
                    if (currMode.currentMode == 5){
                    currentShape = new FreeLine(0, 0, 0, 0);
                    shapesList.add(currentShape);
                
                    currentShape.setdim1(e.getX());
                    currentShape.setdim2(e.getY());
                    shapesList.get(counter).setdim3(currentShape.getdim1());
                    shapesList.get(counter).setdim4(currentShape.getdim2());
                    currentShape.setColor(colorFilled);
                    }
                }
            }
            repaint();
         }
    }

    class ReleaseMouse extends MouseAdapter{
        public void mouseReleased(MouseEvent e){
            shapesList.get(counter).setdim3(e.getX());
            shapesList.get(counter).setdim4(e.getY());
            repaint();
            counter ++;
            
            }
        }
}


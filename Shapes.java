import java.awt.Graphics;
import java.awt.Color;

public abstract class Shapes{
    Graphics g;
    public  int dim1, dim2, dim3, dim4;

   // The Fill Mode
    public boolean SOLD = false;
    public Color selectedColor = Color.BLACK;


    // setters 
    public void setdim1(int d1){
        dim1 = d1;
    }
    public void setdim2(int d2){
        dim2 = d2;
    }
    public void setdim3(int d3){
        dim3 = d3;
    }
    public void setdim4(int d4){
        dim4 = d4;
    }
    public void setSold(boolean sold){
        SOLD = sold;
    }
    public void setColor(Color color){
        selectedColor = color;
    }
    
    // getters
    public int getdim1(){
        return dim1;
    }
    public int getdim2(){
        return dim2;
    }
    public int getdim3(){
        return dim3;
    }
    public int getdim4(){
        return dim4;
    }
    public boolean getSold(){
        return SOLD;
    }
    public Color getColor(){
        return selectedColor;
    }


    // why abstarct method can't be static ?
    public abstract void draw(Graphics g);
   // public abstract void fill(Graphics g);

    // Parametrized Constructor
    public Shapes(int dim1, int dim2, int dim3, int dim4){
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
        this.dim4 = dim4;
        //this.SOLD = SOLD;
    }
}


// Childs Creations

class Rectangle extends Shapes {

    // Implement the draw method
    @Override
    public void draw(Graphics g) {
        if (SOLD == false){
            g.setColor(selectedColor);
            
            if (dim3 > dim1 && dim2 > dim4){
            // take the absolute of y2 because it is negative value
            dim4 = Math.abs(dim4);
            g.drawRect(dim1, dim4, dim3-dim1, dim2-dim4);
        }
        else {
            if (dim3 > dim1 && dim4 > dim2) {
                g.drawRect(dim1, dim2, dim3-dim1, dim4-dim2);
            }
            else{
                if (dim1 > dim3 && dim4 > dim2) {
                    dim3 = Math.abs(dim3);
                    g.drawRect(dim3, dim2, dim1-dim3, dim4-dim2);
                }
                else {
                    if (dim1 > dim3 && dim2 > dim4) {
                        dim3 = Math.abs(dim3);
                        dim4 = Math.abs(dim4);
                        g.drawRect(dim3, dim4, dim1-dim3, dim2-dim4);
                    }
                }
            }
        }
        }
        else{ 
            g.setColor(selectedColor);
            
            if (dim3 > dim1 && dim2 > dim4){
            // take the absolute of y2 because it is negative value
            dim4 = Math.abs(dim4);
            g.fillRect(dim1, dim4, dim3-dim1, dim2-dim4);
        }
        else {
            if (dim3 > dim1 && dim4 > dim2) {
                g.fillRect(dim1, dim2, dim3-dim1, dim4-dim2);
            }
            else{
                if (dim1 > dim3 && dim4 > dim2) {
                    dim3 = Math.abs(dim3);
                    g.fillRect(dim3, dim2, dim1-dim3, dim4-dim2);
                }
                else {
                    if (dim1 > dim3 && dim2 > dim4) {
                        dim3 = Math.abs(dim3);
                        dim4 = Math.abs(dim4);
                        g.fillRect(dim3, dim4, dim1-dim3, dim2-dim4);
                    }
                }
            }
        }
        }
    }

     // Constructor for Rectangle
    public Rectangle(int dim1, int dim2, int dim3, int dim4) {
        super( dim1,  dim2,  dim3,  dim4);
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
        this.dim4 = dim4;
        //this.SOLD = SOLD;
    }
}



class Oval extends Shapes {

    // Implement the draw method
    @Override
    public void draw(Graphics g) {
        if (SOLD == false){
            g.setColor(selectedColor);
            
            if (dim3 > dim1 && dim2 > dim4){
            // take the absolute of y2 because it is negative value
            dim4 = Math.abs(dim4);
            g.drawOval(dim1, dim4, dim3-dim1, dim2-dim4);
        }
        else {
            if (dim3 > dim1 && dim4 > dim2) {
                g.drawOval(dim1, dim2, dim3-dim1, dim4-dim2);
            }
            else{
                if (dim1 > dim3 && dim4 > dim2) {
                    dim3 = Math.abs(dim3);
                    g.drawOval(dim3, dim2, dim1-dim3, dim4-dim2);
                }
                else {
                    if (dim1 > dim3 && dim2 > dim4) {
                        dim3 = Math.abs(dim3);
                        dim4 = Math.abs(dim4);
                        g.drawOval(dim3, dim4, dim1-dim3, dim2-dim4);
                    }
                }
            }
        }
        }
        else{
            g.setColor(selectedColor);
            
            if (dim3 > dim1 && dim2 > dim4){
            // take the absolute of y2 because it is negative value
            dim4 = Math.abs(dim4);
            g.fillOval(dim1, dim4, dim3-dim1, dim2-dim4);
        }
        else {
            if (dim3 > dim1 && dim4 > dim2) {
                g.fillOval(dim1, dim2, dim3-dim1, dim4-dim2);
            }
            else{
                if (dim1 > dim3 && dim4 > dim2) {
                    dim3 = Math.abs(dim3);
                    g.fillOval(dim3, dim2, dim1-dim3, dim4-dim2);
                }
                else {
                    if (dim1 > dim3 && dim2 > dim4) {
                        dim3 = Math.abs(dim3);
                        dim4 = Math.abs(dim4);
                        g.fillOval(dim3, dim4, dim1-dim3, dim2-dim4);
                    }
                }
            }
        }
        }
    }


     // Constructor for Oval
    public Oval(int dim1, int dim2, int dim3, int dim4) {
        super( dim1,  dim2,  dim3,  dim4);
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
        this.dim4 = dim4;
        //this.SOLD = SOLD;
    }
}


class Line extends Shapes {

    // Implement the draw method
    @Override
    public void draw(Graphics g) {
        g.setColor(selectedColor);
        g.drawLine(dim1, dim2, dim3, dim4);
    }



     // Constructor for Line
    public Line(int dim1, int dim2, int dim3, int dim4) {
        super( dim1,  dim2,  dim3,  dim4);
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.dim3 = dim3;
        this.dim4 = dim4;
        //this.SOLD = SOLD;
    }
}


class Eraser extends Shapes {
    public Eraser(int dim1, int dim2, int dim3, int dim4) {
        super(dim1, dim2, dim3, dim4);
    }

    @Override
    public void draw(Graphics g) {
        // Set the color to white for erasing
        g.setColor(Color.WHITE);
        g.fillRect(dim1, dim2, 20, 20);
    }
}

class FreeLine extends Shapes {
    public FreeLine(int dim1, int dim2, int dim3, int dim4) {
        super(dim1, dim2, dim3, dim4);
    }

    @Override
    public void draw(Graphics g) {
        // Set the color to white for erasing
        g.setColor(selectedColor);
        g.fillRect(dim1, dim2, 5, 5);
    }
}
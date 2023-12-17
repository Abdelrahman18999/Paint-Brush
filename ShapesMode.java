public class ShapesMode {
    // The Shapes Modes
    public static final int RECTANGLE = 1;
    public static final int OVAL = 2;
    public static final int LINE = 3;
    public static final int Eraser = 4;
    public static final int FREE_LINE = 5;

    public int currentMode = 0; // Intitalize current mode with ZERO.

    // Shape Mode
    public void setMode(int mode){
        currentMode = mode;
    }

    public int getMode(){
        return currentMode;
    }
    
}

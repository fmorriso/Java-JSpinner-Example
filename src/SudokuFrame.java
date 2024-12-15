import javax.swing.*;
import java.awt.*;

public class SudokuFrame extends JFrame {
    private Dimension scaledScreenSize;
    public SudokuFrame(Dimension screenSize, String title) {
        super(title);
        this.scaledScreenSize = screenSize;

        this.setPreferredSize(screenSize);
        this.setMinimumSize(screenSize);
        this.setSize(screenSize);
        this.setMaximumSize(screenSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new java.awt.GridLayout(1,0));
    }
    private SudokuFrame() {/* prevent uninitalized instances */}
    public Dimension getScaledScreenSize() {return scaledScreenSize;}
}

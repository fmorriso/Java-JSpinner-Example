import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        String title = String.format("Java Spinner Example using Java version %s", getJavaVersion());
        System.out.println(title);

        // Define a set of non-consecutive numbers
        Integer[] numbers = {0, 1};

        Dimension screenSize = SwingScreenUtilities.getScaledSize(0.5, 100, true);
        SudokuFrame frame = new SudokuFrame(screenSize, title);

        // Create a simple JFrame to display the spinner
        SudokuGridPanel gridPanel = new SudokuGridPanel();
        frame.add(gridPanel);

        // puts the JFrame in the middle of the physical screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /** get the java version that is running the current program
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion()
    {
        Runtime.Version rtv = Runtime.version();
        return String.format("%s.%s.%s.%s", rtv.feature(), rtv.interim(), rtv.update(), rtv.patch());
    }
}

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SudokuGridPanel extends JPanel {
    private static final Integer[] allowableSudokuNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final Font scaledFont;

    SudokuSpinner[][] sudokuNumber;
    SudokuGridPanel(int rows, int cols) {
        Font font = this.getFont();
        int fontSize = (int) (font.getSize() * (3 + SwingScreenUtilities.pct));
        scaledFont = new Font(font.getFamily(), font.getStyle(), fontSize);
        GridLayout gridLayout = new GridLayout(rows, cols);
        this.setLayout(gridLayout);
        sudokuNumber = new SudokuSpinner[rows][cols];
        int groudId = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                SudokuSpinner spinner = createSpinner();
                spinner.setGroupId(groudId++);
                sudokuNumber[row][col] = spinner;
                this.add(sudokuNumber[row][col]);
            }
        }

    }
    SudokuGridPanel(int squareSize) {
        this(squareSize, squareSize);
    }
    SudokuGridPanel() {
        this(3, 3);
    }

    private SudokuSpinner createSpinner(){
        SpinnerListModel model = new SpinnerListModel(allowableSudokuNumbers);
        SudokuSpinner spinner = new SudokuSpinner(model);
        // Center the value in the JSpinner editor
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
            textField.setHorizontalAlignment(SwingConstants.CENTER);
        }
        spinner.setFont(scaledFont);
        spinner.addChangeListener(e -> {
            int value = (int) spinner.getValue();
            updateSpinnerSelections(spinner, value);
        });

        return spinner;
    }

    public void updateSpinnerSelections(JSpinner spinner, int value) {
        //TODO: remove the value from the other sibling spinners
    }
}

import javax.swing.*;
import java.awt.*;

public class SudokuGridPanel extends JPanel {
    private static final Integer[] allowableSudokuNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    JSpinner[][] sudokuNumber;
    SudokuGridPanel(int rows, int cols) {
        Font font = this.getFont();
        int fontSize = (int) (font.getSize() * (4 + SwingScreenUtilities.pct));
        Font scaledFont = new Font(font.getFamily(), font.getStyle(), fontSize);
        GridLayout gridLayout = new GridLayout(rows, cols);
        this.setLayout(gridLayout);
        sudokuNumber = new JSpinner[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Integer[] sudokuNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                SpinnerListModel model = new SpinnerListModel(sudokuNumbers);
                JSpinner spinner = new JSpinner(model);
                // Center the value in the JSpinner editor
                JComponent editor = spinner.getEditor();
                if (editor instanceof JSpinner.DefaultEditor) {
                    JFormattedTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
                    textField.setHorizontalAlignment(SwingConstants.CENTER);
                }
                spinner.setFont(scaledFont);
                sudokuNumber[row][col] = spinner;
                this.add(sudokuNumber[row][col]);
            }
        }

    }
    SudokuGridPanel(int squareSize) {
        this(squareSize, squareSize);
    }
    SudokuGridPanel() {
        this(3,3);
    }
}

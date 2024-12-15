import javax.swing.*;
import java.awt.*;

public class SudokuGridPanel extends JPanel {
    private static final Integer[] allowableSudokuNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    JSpinner[][] sudokuNumber;
    SudokuGridPanel(int rows, int cols) {
        GridLayout gridLayout = new GridLayout(rows, cols);
        this.setLayout(gridLayout);
        sudokuNumber = new JSpinner[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Integer[] sudokuNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                SpinnerListModel model = new SpinnerListModel(sudokuNumbers);
                JSpinner spinner = new JSpinner(model);
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

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SudokuSpinner extends JSpinner {
    // the set of allowable Sudoku numbers
    private static final Integer[] allowableSudokuNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private Integer[] sudokuNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private SpinnerListModel model;
    private SudokuFrame parentFrame;
    private static Dimension  scaledScreenSize;

    public SudokuSpinner(SpinnerListModel ignoreThisModel) {
        // ignore the one passed in because we have a special model in mind.
        model = new SpinnerListModel(allowableSudokuNumbers);
        this.setModel(model);

        scaledScreenSize = parentFrame.getScaledScreenSize();
        double pct = 0.10;
        int width = (int) (scaledScreenSize.width * pct);
        int height = (int) (scaledScreenSize.height * pct);
        Dimension size = new Dimension(width, height);

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }

    public SpinnerListModel getModel() {return this.model;}

    public void removeNumber(int n) {
        // sanity check: verify that "n" is even present in the current array of numbers
        if(Arrays.binarySearch(sudokuNumbers, n) >= 0) {
            Integer[] newSudokuNumbers = new Integer[sudokuNumbers.length - 1];
            int idx = 0;
            for(Integer sudokuNumber : sudokuNumbers) {
                if(sudokuNumber != n) {
                    newSudokuNumbers[idx++] = sudokuNumber;
                }
            }
            sudokuNumbers = newSudokuNumbers;
            model = new SpinnerListModel(sudokuNumbers);
        }
    }

    public void reset() {
        sudokuNumbers = allowableSudokuNumbers;
    }
}

import javax.swing.*;
import java.util.List;

public class SudokuSpinner extends JSpinner {

    private int groupId;
    private JPanel parentPanel;

    public SudokuSpinner(SpinnerListModel model, int groupId, JPanel parent) {
        super(model);
        this.groupId = groupId;
        this.parentPanel = parent;
    }

    public int getGroupId() {return groupId;}

    public void updateEligibleNumbers(int valueToRemove) {
        SpinnerListModel model = (SpinnerListModel) this.getModel();
        model.getList().remove(valueToRemove);
    }

}

import javax.swing.*;

public class SudokuSpinner extends JSpinner {

    private int groupId;

    public SudokuSpinner(SpinnerListModel model) {
        super(model);
    }

    public int getGroupId() {return groupId;}
    public void setGroupId(int groupId) {this.groupId = groupId;}

}

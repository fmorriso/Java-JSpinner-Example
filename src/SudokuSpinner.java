import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * @param valueToRemove - the value to remove from the list of eligible values
     */
    public void removeEligibleNumber(int valueToRemove) {
        SpinnerListModel model = (SpinnerListModel) this.getModel();
        List<?> currentList = model.getList();
        if(currentList.contains(valueToRemove)) {
            List<Integer> updatedList = new ArrayList<>();
            for(Object o: currentList){
                Integer i = (Integer) o;
                if(i == valueToRemove) continue;
                updatedList.add(i);
            }
            SpinnerListModel newModel = new SpinnerListModel(updatedList);
            this.setModel(newModel);
        }
    }

    public void addEligibleNumber(int valueToAdd) {
        SpinnerListModel model = (SpinnerListModel) this.getModel();
        // Retrieve the current list of values
        List<?> originalList = ((SpinnerListModel) model).getList();

        // Create a modifiable copy of the list
        List<Object> updatedList = new ArrayList<>(originalList);

        // Add the new value
        updatedList.add(valueToAdd);

        // Sort the list
        Collections.sort(updatedList, null); // Default natural ordering

        // Set the updated list as a new SpinnerListModel
        this.setModel(new SpinnerListModel(updatedList));
    }

    /**
     * Sorts the values in the SpinnerListModel of a JSpinner.
     * If the model is not a SpinnerListModel, this method does nothing.
     */
    private void sortModel() {
        SpinnerModel model = this.getModel();

        if (model instanceof SpinnerListModel) {
            // Retrieve the list of values
            List<?> originalList = ((SpinnerListModel) model).getList();

            // Create a copy of the list to sort (original list might be immutable)
            List<Object> sortedList = new ArrayList<>(originalList);

            // Sort the list
            Collections.sort(sortedList, null); // Default natural ordering

            // Set a new SpinnerListModel with the sorted list
            this.setModel(new SpinnerListModel(sortedList));
        }
    }

}

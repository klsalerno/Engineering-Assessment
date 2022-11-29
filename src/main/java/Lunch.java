/**
 * Class for a breakfast meal. The class inherits fields and methods from Meal.
 */
public class Lunch extends Meal {

    /** Lunch meal type */
    private final String meal = "Sandwich";

    /** Lunch side type */
    private String side = "Chips";

    /** Lunch drink type */
    private String drink = "Soda";

    /** Array of item IDs that cannot be ordered more than once */
    private final int[] noDuplicateIDs = {1,3};

    /** Array of names of item types that cannot be ordered more than once, corresponds with array of item IDs */
    private final String[] noDuplicateNames = {meal, drink};

    /** item ID that can be ordered multiple times */
    private final int allowDuplicates = 2;

    /**
     * Basic constructor
     * @param IDs String with item IDs separated by commas
     */
    public Lunch(String IDs) {
        super(IDs);
    }

    /**
     * Method that returns a formatted string of names of items from an order
     *
     * @return String with information about the order
     */
    public String orderOutput() {
        String output;
        if (containsDuplicate(itemIDs, noDuplicateIDs)) {
            output = duplicateItem(itemIDs, noDuplicateIDs, noDuplicateNames);
        } else {
            int sideCount = getItemCount(itemIDs, allowDuplicates);
            if (! super.itemIDs.contains("3"))
                drink = "Water";
            if (sideCount > 1)
                side += String.format("(%d)", sideCount);
            output = String.format("%s, %s, %s", meal, side, drink);
        }
        return output;
    }

}

/**
 * Class for a breakfast meal. The class inherits fields and methods from Meal.
 */
public class Breakfast extends Meal {

    /** Breakfast meal type */
    private final String meal = "Eggs";

    /** Breakfast side type */
    private final String side = "Toast";

    /** Breakfast drink type */
    private String drink = "Coffee";

    /** Array of item IDs that cannot be ordered more than once */
    private final int[] noDuplicateIDs = {1, 2};

    /** Array of names of item types that cannot be ordered more than once, corresponds with array of item IDs */
    private final String[] noDuplicateNames = {meal, side};

    /** item ID that can be ordered multiple times */
    private final int allowDuplicates = 3;

    /**
     * Basic constructor
     * @param IDs String with item IDs separated by commas
     */
    public Breakfast(String IDs) {
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
            int drinkCount = getItemCount(itemIDs, allowDuplicates);
            if (! super.itemIDs.contains("3"))
                drink = "Water";
            if (drinkCount > 1)
                drink += String.format("(%d)", drinkCount);
            output = String.format("%s, %s, %s", meal, side, drink);
        }
        return output;
    }

}

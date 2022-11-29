/**
 * Class for a breakfast meal. The class inherits fields and methods from Meal.
 */
public class Dinner extends Meal {

    /** Dinner meal type */
    private final String meal = "Steak";

    /** Dinner side type */
    private final String side = "Potatoes";

    /** Dinner drink type */
    private String drink = "Wine";

    /** Dinner drink that is always included */
    private final String includedDrink = "Water";

    /** Dinner dessert type */
    private final String dessert = "Cake";

    /** Array of item IDs that every dinner order must contain */
    private final String[] mustContain = {"4"};

    /** Array of item types that every dinner order must contain */
    private final String[] mustContainTypes = {"Dessert"};

    /** Array of item IDs that cannot be ordered more than once */
    private final int[] noDuplicateIDs = {1, 2, 3, 4};

    /** Array of names of item types that cannot be ordered more than once, corresponds with array of item IDs */
    private final String[] noDuplicateNames = {meal, side, drink, dessert};

    /**
     * Basic constructor
     * @param IDs String with item IDs separated by commas
     */
    public Dinner(String IDs) {
        super(IDs);
    }

    /**
     * Method that returns a formatted string of names of items from an order
     *
     * @return String with information about the order
     */
    public String orderOutput() {
        String output;
        if (isMissingItem(itemIDs, mustContain)) {
            output = missingItem(itemIDs, mustContain, mustContainTypes);
        } else {
            if (containsDuplicate(itemIDs, noDuplicateIDs)) {
                output = duplicateItem(itemIDs, noDuplicateIDs, noDuplicateNames);
            } else {
                if (!super.itemIDs.contains("3"))
                    drink = "Water";
                output = String.format("%s, %s, %s, %s, %s", meal, side, drink, includedDrink, dessert);
            }
        }
        return output;
    }

}

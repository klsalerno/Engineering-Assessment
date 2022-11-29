/**
 * A superclass for meal types. Meal types are breakfast, lunch, and dinner.
 * The common characteristics for these three types of meals: all meals have items and types of items they must contain
 * Different characteristics, including specific names of item types (for example, eggs are a type of main item)
 * are delegated to three classes that extend this class.
 */
public class Meal {

    /** The list of menu item IDs, e.g., "1,2,3" */
    String itemIDs;

    /** Array of item IDs that every meal order must contain */
    private static final String[] mustContain = {"1","2"};

    /** Array of item types that every meal order must contain, corresponds with array of item IDs */
    private static final String[] mustContainTypes = {"Main", "Side"};

    /**
     * Basic constructor
     * @param IDs String with item IDs separated by commas
     */
    public Meal(String IDs) {
        itemIDs = IDs;
    }

    /** Getter methods for the arrays of item IDs and their corresponding types */
    public static String[] getMustContain() {
        return mustContain;
    }

    public static String[] getMustContainTypes() {
        return mustContainTypes;
    }

    /**
     * Method to determine if an order is missing a required item
     *
     * @param itemIDs String of item IDs separated by commas
     * @param orderMustContain String[] of item IDs the order must contain
     * @return true if an order is missing a required item, false otherwise
     */
    public static boolean isMissingItem(String itemIDs, String[] orderMustContain) {
        for (String item : orderMustContain)
            if (! itemIDs.contains(item))
                return true;
        return false;
    }

    /**
     * Method that constructs an error message when a required item is missing
     *
     * @param itemIDs String of item IDs separated by commas
     * @param orderMustContain String[] of item IDs the order must contain
     * @param itemType String[] of types of items (e.g. Side, Drink) the order must contain
     * @return String "Unable to process: itemType is missing"
     */
    public static String missingItem(String itemIDs, String[] orderMustContain, String[] itemType) {
        StringBuilder errorMessage = new StringBuilder("Unable to process: ");
        String[] itemTypeCopy = itemType.clone();   // To not modify original array
        int numMissing = 0;
        for (int index = 0; index < orderMustContain.length; index++) {
            if (! itemIDs.contains(String.valueOf(orderMustContain[index]))) {
                numMissing++;
                if (numMissing > 1)
                    itemTypeCopy[index] = String.format(", %s", itemTypeCopy[index].toLowerCase());
                errorMessage.append(String.format("%s is missing", itemTypeCopy[index]));
            }
        }
        return errorMessage.toString();
    }

    /**
     * Method to determine if an order contains multiple of an item that is not allowed
     *
     * @param itemIDs String of item IDs separated by commas
     * @param orderOneOf int[] of item IDs that are only allowed to be ordered once
     * @return true if an order contains a duplicate, false otherwise
     */
    public static boolean containsDuplicate(String itemIDs, int[] orderOneOf) {
        for (int item : orderOneOf)
            if (getItemCount(itemIDs, item) > 1)
                return true;
        return false;
    }

    /**
     * Method that constructs an error message when an unauthorized item is ordered multiple times
     *
     * @param itemIDs String of item IDs separated by commas
     * @param orderOneOf int[] of item IDs that are only allowed to be ordered once
     * @param itemNames String[] of names of items (e.g. Eggs, Chips) that cannot be ordered multiple times
     * @return String "Unable to process: itemName cannot be ordered more than once"
     */
    public static String duplicateItem(String itemIDs, int[] orderOneOf, String[] itemNames) {
        StringBuilder errorMessage = new StringBuilder("Unable to process: ");
        int numDuplicates = 0;
        for (int index = 0; index < orderOneOf.length; index++) {
            int itemCount = getItemCount(itemIDs, orderOneOf[index]);
            if (itemCount > 1) {
                numDuplicates++;
                if (numDuplicates > 1)
                    itemNames[index] = String.format(", %s", itemNames[index].toLowerCase());
                errorMessage.append(String.format("%s cannot be ordered more than once", itemNames[index]));
            }
        }
        if (numDuplicates == 0)
            return "";
        return errorMessage.toString();
    }

    /**
     * Method that tells how many times an itemID is found in an order
     *
     * @param itemIDs String of item IDs separated by commas
     * @param itemValue int of the ID being checked
     * @return int of how many times the ID is found in the order
     */
    public static int getItemCount(String itemIDs, int itemValue) {
        return itemIDs.split(String.valueOf(itemValue), -1).length - 1;
    }

    /** Basic structure of the item output of an order */
    public String orderOutput() {
        return "Meal, Side, Drink";
    }
}

/**
 * A class to implement meal orders
 */
public class MenuOrdering {
    /** Driver code */
    public static void main(String[] args) {
        System.out.println(order("Breakfast", "1,2,3"));
        System.out.println(order("Breakfast", "2,3,1"));
        System.out.println(order("Breakfast", "1,2,3,3,3"));
        System.out.println(order("Breakfast", "1"));

        System.out.println(order("Lunch", "1,2,3"));
        System.out.println(order("Lunch", "1,2"));
        System.out.println(order("Lunch", "1,1,2,3"));
        System.out.println(order("Lunch", "1,2,2"));
        System.out.println(order("Lunch", ""));

        System.out.println(order("Dinner", "1,2,3,4"));
        System.out.println(order("Dinner", "1,2,3"));
    }

    /**
     * Method to order a meal and the menu items for the meal
     *
     * @param mealType String type of meal (Breakfast, Lunch, Dinner)
     * @param itemIDs String list of menu item IDs separated by commas
     * @return String list of name of menu items in order
     *         String message that the order is unable to be processed
     */
    static String order(String mealType, String itemIDs) {
        String output;
        new Meal(itemIDs);
        Meal meal = switch (mealType) {
            case "Breakfast" -> new Breakfast(itemIDs);
            case "Lunch" -> new Lunch(itemIDs);
            case "Dinner" -> new Dinner(itemIDs);
            default -> new Meal(itemIDs);
        };
        if (Meal.isMissingItem(itemIDs, Meal.getMustContain())) {
            output = Meal.missingItem(itemIDs, Meal.getMustContain(), Meal.getMustContainTypes());
        } else {
            output = meal.orderOutput();
        }
        return output;
    }

}

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class MenuOrderingTest {

    private MenuOrdering fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new MenuOrdering();
    }

    @After
    public void tearDown() throws Exception {
        fixture = null;
    }

    @Test
    public void initialization() {
        assertNotNull(fixture);
    }

    @Test
    public void breakfastOrderedItems() {
        assertNotNull(fixture);
        assertEquals("Eggs, Toast, Coffee", MenuOrdering.order("Breakfast", "1,2,3"));
    }

    @Test
    public void breakfastUnorderedItems() {
        assertNotNull(fixture);
        assertEquals("Eggs, Toast, Coffee", MenuOrdering.order("Breakfast", "2,3,1"));
    }

    @Test
    public void breakfastMultipleDrink() {
        assertNotNull(fixture);
        assertEquals("Eggs, Toast, Coffee(3)", MenuOrdering.order("Breakfast", "1,2,3,3,3"));
    }

    @Test
    public void breakfastMissingItem() {
        assertNotNull(fixture);
        assertEquals("Unable to process: Side is missing", MenuOrdering.order("Breakfast", "1"));
    }

    @Test
    public void lunchOrderedItems() {
        assertNotNull(fixture);
        assertEquals("Sandwich, Chips, Soda", MenuOrdering.order("Lunch", "1,2,3"));
    }

    @Test
    public void lunchDefaultDrink() {
        assertNotNull(fixture);
        assertEquals("Sandwich, Chips, Water", MenuOrdering.order("Lunch", "1,2"));
    }

    @Test
    public void lunchDuplicateItem() {
        assertNotNull(fixture);
        assertEquals("Unable to process: Sandwich cannot be ordered more than once", MenuOrdering.order("Lunch", "1,1,2,3"));
    }

    @Test
    public void lunchMultipleSide() {
        assertNotNull(fixture);
        assertEquals("Sandwich, Chips(2), Water", MenuOrdering.order("Lunch", "1,2,2"));
    }

    @Test
    public void lunchMissingItem() {
        assertNotNull(fixture);
        assertEquals("Unable to process: Main is missing, side is missing", MenuOrdering.order("Lunch", ""));
    }

    @Test
    public void dinnerOrderedItems() {
        assertNotNull(fixture);
        assertEquals("Steak, Potatoes, Wine, Water, Cake", MenuOrdering.order("Dinner", "1,2,3,4"));
    }

    @Test
    public void dinnerMissingItem() {
        assertNotNull(fixture);
        assertEquals("Unable to process: Dessert is missing", MenuOrdering.order("Dinner", "1,2,3"));
    }

}

/**
 * The main class: used to test the user input and features of a food tracker
 * 
 * @author NJudd
 */
public class Main {
    public static void main(String[] args) {
        // User input
        // FoodTracker UserFoodTracker = new FoodTracker();
        // UserFoodTracker.runFoodTracker();

        // No User input
        testFoodTracker();
    }

    /**
     * Tests the features of the FoodTracker class
     */
    public static void testFoodTracker() {
        FoodTracker test = new FoodTracker();

        addItems(test);

        test.printTracker();

        test.logMealHealth(0);
        test.logMealHealth(1);
        test.logMealHealth(2);
        test.logMealHealth(3);

        test.checkDailyHealth();
    }

    /**
     * Adds test meals and drinks to a food tracker
     * 
     * @param test food tracker
     */
    public static void addItems(FoodTracker test) {
        Meal breakfast = new Breakfast("Cereal with fruit", "8:30am", 325, 3);
        test.addMeal(breakfast);

        Meal lunch = new Lunch("Chicken sandwich and side yogurt", "12:45pm", 510, 3);
        test.addMeal(lunch);

        Meal dinner = new Dinner("Pasta and meatballs with side salad", "6:00pm", 670, 3);
        test.addMeal(dinner);

        Meal snack = new Snack("Chips", "8:30pm", 390, 1);
        test.addMeal(snack);

        Drink water = new Drink("Water", 1000);
        test.addDrink(water);

        Drink juice = new Drink("Apple juice", 250);
        test.addDrink(juice);

        Drink coke = new Drink("Coke zero", 350);
        test.addDrink(coke);
    }
}

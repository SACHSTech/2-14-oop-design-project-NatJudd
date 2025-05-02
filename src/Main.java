/**
 * The main class: used to test the user input and features of a food tracker
 * 
 * @author NJudd
 */
public class Main {
    public static void main(String[] args) {
        // User input
        // UserFoodTracker UserFoodTracker = new UserFoodTracker();
        // UserFoodTracker.runFoodTracker();

        // No User input
        FoodTracker test = new FoodTracker();

        Meal breakfast = new Breakfast("Cereal with fruit", "8:30am", 325, 3);
        Meal lunch = new Lunch("Chicken sandwich and side yogurt", "12:45pm", 510, 3);
        Meal dinner = new Dinner("Pasta and meatballs with side salad", "6:00pm", 670, 3);
        Meal snack = new Snack("Chips", "8:30pm", 390, 1);
        Drink water = new Drink("Water", 1000);
        Drink juice = new Drink("Apple juice", 250);
        Drink coke = new Drink("Coke zero", 350);

        test.addMeal(breakfast);
        test.addMeal(lunch);
        test.addMeal(dinner);
        test.addMeal(snack);
        test.addDrink(water);
        test.addDrink(juice);
        test.addDrink(coke);

        test.printTracker();

        breakfast.logMealHealth();
        lunch.logMealHealth();
        dinner.logMealHealth();
        snack.logMealHealth();

        test.checkDailyHealth();
    }
}

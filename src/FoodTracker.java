import java.util.ArrayList;
import java.util.List;

/**
 * The tracker class: represents all the meals and drinks a person has in a day
 * 
 * @author NJudd
 */
public class FoodTracker {
    private List<Meal> meals = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();

    /**
     * Prints all the meals and drinks the user added
     */
    public void printTracker() {
        System.out.println("Meals: ");

        for (int i = 0; i < meals.size(); i++) {
            System.out.println(i + 1 + ". " + meals.get(i));
        }

        System.out.println();
        System.out.println("Drinks: ");

        for (int i = 0; i < drinks.size(); i++) {
            System.out.println(drinks.get(i));
        }

        System.out.println();
    }

    /**
     * Checks if what the user ate is healthy or not
     * 
     * @return if the day is healthy or not
     */
    public void checkDailyHealth() {
        int healthy = 0;
        int unhealthy = 0;

        for (Meal meal : meals) {
            if (meal.isHealthy()) {
                healthy += 1;
            } else {
                unhealthy += 1;
            }
        }

        for (Drink drink : drinks) {
            if (drink.isWater()) {
                healthy += 1;
            } else {
                unhealthy += 1;
            }
        }

        if (healthy > unhealthy) {
            System.out.println("\nYour day was healthy");
        } else {
            System.out.println("\nYour day was unhealthy");
        }
    }

    /**
     * Adds a meal object to the tracker
     * 
     * @param e meal
     */
    public void addMeal(Meal e) {
        meals.add(e);
    }

    /**
     * Adds a drink object to the tracker
     * 
     * @param e drink
     */
    public void addDrink(Drink e) {
        drinks.add(e);
    }

    /**
     * Returns a list of meal objects
     * 
     * @return meal list
     */
    public List<Meal> getMeals() {
        return meals;
    }

    /**
     * Returns a list of drink objects
     * 
     * @return drink list
     */
    public List<Drink> getDrinks() {
        return drinks;
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * The tracker class: represents all the meals and drinks a person has in a day
 * 
 * @author NJudd
 */
public class Tracker {
    private List<Meal> meals = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();

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
     * Turns String and int inputs into a meal object
     * 
     * @param type       meal type
     * @param name       meal name
     * @param time       meal time
     * @param calories   meal calories
     * @param foodGroups meal foodgroups
     * @return meal object
     */
    public Meal makeMeal(String type, String name, String time, int calories, int foodGroups) {
        Meal meal = null;
        if (type.equals("breakfast")) {
            meal = new Breakfast(name, time, calories, foodGroups);
        } else if (type.equals("lunch")) {
            meal = new Lunch(name, time, calories, foodGroups);
        } else if (type.equals("dinner")) {
            meal = new Dinner(name, time, calories, foodGroups);
        } else if (type.equals("snack")) {
            meal = new Snack(name, time, calories, foodGroups);
        }

        return meal;
    }

    /**
     * Turns String and int inputs into a drink object
     * 
     * @param name   drink name
     * @param volume drink volume
     * @return drink object
     */
    public Drink makeDrink(String name, int volume) {
        return new Drink(name, volume);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }
}

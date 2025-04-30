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

    /**
     * Prints all the meals and drinks the user added
     */
    public void printTracker() {
        System.out.println("Meals: ");

        for (int i = 0; i < getMeals().size(); i++) {
            System.out.println(i + 1 + ". " + getMeals().get(i));
        }

        System.out.println();
        System.out.println("Drinks: ");

        for (int i = 0; i < getDrinks().size(); i++) {
            System.out.println(getDrinks().get(i));
        }

        System.out.println();
    }

    /**
     * Checks if what the user ate is healthy or not
     * 
     * @return if the day is healthy or not
     */
    public boolean isDayHealthy() {
        int healthy = 0;
        int unhealthy = 0;

        for (int i = 0; i < getMeals().size(); i++) {
            if (getMeals().get(i).isHealthy()) {
                healthy += 1;
            } else {
                unhealthy += 1;
            }
        }

        for (int i = 0; i < getDrinks().size(); i++) {
            if (getDrinks().get(i).isWater()) {
                healthy += 1;
            } else {
                unhealthy += 1;
            }
        }

        if (healthy >= unhealthy) {
            System.out.println("You ate healthy today!");
            return true;
        } else {
            System.out.println("You might want to start thinking about eating healthier :(");
            return false;
        }
    }

    /**
     * Checks if the meal a user chooses is healthy
     * 
     * @return if the meal is healthy or not
     */
    public boolean printMealHealth(int index) {
        if (getMeal(index).isHealthy()) {
            System.out.println(getMeal(index) + " is healthy");
            return true;
        } else {
            System.out.println(getMeal(index) + " is unhealthy");
            return false;
        }
    }

    /**
     * Returns the meal at the specified index
     * 
     * @param index index of meal
     * @return meal
     */
    public Meal getMeal(int index) {
        return meals.get(index);
    }

    /**
     * Returns a list of meals
     * 
     * @return meal list
     */
    public List<Meal> getMeals() {
        return meals;
    }

    /**
     * Returns a list of drink
     * 
     * @return drink list
     */
    public List<Drink> getDrinks() {
        return drinks;
    }
}

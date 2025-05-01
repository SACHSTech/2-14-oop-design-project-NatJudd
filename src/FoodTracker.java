import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The tracker class: represents all the meals and drinks a person has in a day
 * 
 * @author NJudd
 */
public class FoodTracker {
    private List<Meal> meals = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private Scanner s = new Scanner(System.in);

    /**
     * Prompts the user to either add a meal, drink, or exit
     */
    public void runFoodTracker() {
        promptForNewItems();
        printTracker();
        promptForHealthCheck();
    }

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
    public boolean checkDailyHealth() {
        int healthy = 0;
        int unhealthy = 0;

        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).isHealthy()) {
                healthy += 1;
            } else {
                unhealthy += 1;
            }
        }

        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).isWater()) {
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
    public Meal createMeal(String type, String name, String time, int calories, int foodGroups) {
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
    public Drink createDrink(String name, int volume) {
        return new Drink(name, volume);
    }

    /**
     * Prompts the user to add new meals or drink until the user inputs 'no'
     */
    public void promptForNewItems() {
        while (true) {
            System.out.print("Add meal or drink (meal/drink/no): ");
            String x = s.nextLine().toLowerCase();

            if (x.equals("meal")) {
                addNewMeal();
                x = "";
            } else if (x.equals("drink")) {
                addNewDrink();
                x = "";
            } else if (x.equals("no")) {
                System.out.println();
                break;
            } else {
                System.out.println("Input invalid try again");
            }
        }
    }

    /**
     * Asks the user if they want to check if a meal or their day was healthy
     */
    public void promptForHealthCheck() {
        while (true) {
            System.out.print("Check health of day or meal (day/meal/no): ");
            String x = s.nextLine().toLowerCase();

            if (x.equals("day")) {
                checkDailyHealth();
                x = "";
            } else if (x.equals("meal")) {
                isMealHealthy();
                x = "";
            } else if (x.equals("no")) {
                System.out.println();
                System.out.println("Program ended");
                break;
            } else {
                System.out.println("Input invalid try again");
            }
        }
    }

    /**
     * Prompts the user for elements of their meal then adds the meal
     */
    public void addNewMeal() {
        String type = promptForMealType();
        System.out.print("Enter meal name: ");
        String name = s.nextLine();
        System.out.print("Enter meal time: ");
        String time = s.nextLine();
        int calories = promptForValidNumber("Enter meal calories: ", 10000);
        int foodGroups = promptForValidNumber("Enter meal foodgroups: ", 4);

        addMeal(createMeal(type, name, time, calories, foodGroups));
        System.out.println("Meal added");
    }

    /**
     * Prompts the user for elements of their drink then adds the drink
     */
    public void addNewDrink() {
        System.out.print("Enter drink name: ");
        String name = s.nextLine();
        System.out.print("Enter drink size (milliliters): ");
        int volume = Integer.parseInt(s.nextLine());

        addDrink(createDrink(name, volume));
        System.out.println("Drink added");
    }

    /**
     * Checks if the meal a user chooses is healthy
     * 
     * @return if the meal is healthy or not
     */
    public void isMealHealthy() {
        int meal = promptForValidNumber("Enter meal number: ", meals.size()) - 1;
        System.out.println();
        boolean health = logMealHealth(meal);
        if (!health) {
            explainUnhealthyMeal(meal);
        }
    }

    /**
     * Checks if the meal a user chooses is healthy
     * 
     * @return if the meal is healthy or not
     */
    public boolean logMealHealth(int index) {
        if (getMeal(index).isHealthy()) {
            System.out.println(getMeal(index) + " is healthy");
            return true;
        } else {
            System.out.println(getMeal(index) + " is unhealthy");
            return false;
        }
    }

    /**
     * Returns the reason a meal is unhealthy
     * 
     * @param meal the index of the meal being checked
     * @return the reason a meal is unhealthy
     */
    public void explainUnhealthyMeal(int meal) {
        System.out.println();
        while (true) {
            System.out.print("Reason meal is unhealthy? (yes/no): ");
            String answer = s.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                System.out.println(meals.get(meal).healthReason());
                break;
            } else if (answer.equals("no")) {
                break;
            } else {
                System.out.println("Input invalid try again");
            }
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
     * Gets integer value from user until value is above zero
     * 
     * @param prompt prompt for user
     * @return user input
     */
    public int promptForValidNumber(String prompt, int max) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            value = Integer.parseInt(s.nextLine());

            if (value < 1 || value > max) {
                System.out.println("Input invalid try again");
            } else {
                break;
            }
        }
        return value;
    }

    /**
     * Returns meal type from user and checks if valid
     * 
     * @return meal type
     */
    public String promptForMealType() {
        String type = "";

        while (true) {
            System.out.print("Enter meal type (breakfast/lunch/dinner/snack): ");
            type = s.nextLine().toLowerCase();

            if (!(type.equals("breakfast") || type.equals("lunch") || type.equals("dinner") || type.equals("snack"))) {
                type = "";
                System.out.println("Input invalid try again");
            } else {
                break;
            }
        }

        return type;
    }
}

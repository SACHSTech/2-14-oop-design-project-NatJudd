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
            System.out.println("Your day was healthy");
            return true;
        } else {
            System.out.println("Your day was unhealthy");
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
     * Turns user inputs into a meal object
     * 
     * @param type       meal type
     * @param name       meal name
     * @param time       meal time
     * @param calories   meal calories
     * @param foodgroups meal foodgroups
     * @return meal object
     */
    public Meal createMeal(MealType type, String name, String time, int calories, int foodgroups) {
        switch (type) {
            case BREAKFAST:
                return new Breakfast(name, time, calories, foodgroups);
            case LUNCH:
                return new Lunch(name, time, calories, foodgroups);
            case DINNER:
                return new Dinner(name, time, calories, foodgroups);
            case SNACK:
                return new Snack(name, time, calories, foodgroups);
            default:
                throw new IllegalArgumentException("Input invalid try again");
        }
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
            System.out.print("Check health of day or meal (day/meal/exit): ");
            String x = s.nextLine().toLowerCase();

            if (x.equals("day")) {
                checkDailyHealth();
                x = "";
            } else if (x.equals("meal")) {
                isMealHealthy();
                x = "";
            } else if (x.equals("exit")) {
                System.out.println();
                System.out.println("Program exited");
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
        MealType type = promptForMealType();
        System.out.print("Enter meal name: ");
        String name = s.nextLine();
        System.out.print("Enter meal time: ");
        String time = s.nextLine();
        int calories = promptForValidNumber("Enter meal calories: ", 10000);
        int foodgroups = promptForValidNumber("Enter meal foodgroups: ", 4);

        addMeal(createMeal(type, name, time, calories, foodgroups));
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
            System.out.println();
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
            System.out.print("Get reason meal is unhealthy (yes/no): ");
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
     * Prompts for int value until above 0 and other conditions are met
     * 
     * @param prompt prompt for user
     * @param max    max value
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
    public MealType promptForMealType() {
        while (true) {
            System.out.print("Enter meal type (breakfast/lunch/dinner/snack): ");
            String input = s.nextLine().trim().toLowerCase();

            // Manual check instead of try-catch
            if (input.equals(MealType.BREAKFAST.getName())) {
                return MealType.BREAKFAST;
            } else if (input.equals(MealType.LUNCH.getName())) {
                return MealType.LUNCH;
            } else if (input.equals(MealType.DINNER.getName())) {
                return MealType.DINNER;
            } else if (input.equals(MealType.SNACK.getName())) {
                return MealType.SNACK;
            } else {
                System.out.println("Input invalid try again");
            }
        }
    }
}

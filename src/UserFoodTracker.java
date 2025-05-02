import java.util.Scanner;

public class UserFoodTracker extends FoodTracker {
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
            System.out.print("\nCheck health of day or meal (day/meal/exit): ");
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
        int meal = promptForValidNumber("Enter meal number: ", getMeals().size()) - 1;
        System.out.println();
        boolean health = getMeals().get(meal).isHealthy();
        if (!health) {
            explainUnhealthyMeal(meal);
            System.out.println();
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
                System.out.println(getMeals().get(meal).healthReason());
                break;
            } else if (answer.equals("no")) {
                break;
            } else {
                System.out.println("Input invalid try again");
            }
        }
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

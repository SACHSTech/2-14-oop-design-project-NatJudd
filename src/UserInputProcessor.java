import java.util.Scanner;

/**
 * UserInputProcessor class: has methods to prompt and recieve user input.
 * 
 * @author NJudd
 */
public class UserInputProcessor {
    private Tracker track = new Tracker();
    private Scanner s = new Scanner(System.in);

    /**
     * Prompts the user to either add a meal, drink, or exit
     */
    public void promptUser() {
        newItemPrompt();
        track.printTracker();
        isHealthyPrompt();
    }

    /**
     * Prompts the user to add new meals or drink until the user inputs 'no'
     */
    public void newItemPrompt() {
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
    public void isHealthyPrompt() {
        while (true) {
            System.out.print("Check health of day or meal (day/meal/no): ");
            String x = s.nextLine().toLowerCase();

            if (x.equals("day")) {
                track.isDayHealthy();
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
        String type = getMealType();
        System.out.print("Enter meal name: ");
        String name = s.nextLine();
        System.out.print("Enter meal time: ");
        String time = s.nextLine();
        int calories = inputAboveZero("Enter meal calories: ", 10000);
        int foodGroups = inputAboveZero("Enter meal foodgroups: ", 4);

        track.addMeal(track.makeMeal(type, name, time, calories, foodGroups));
        System.out.println("Meal added");
    }

    /**
     * Gets integer value from user until value is above zero
     * 
     * @param prompt prompt for user
     * @return user input
     */
    public int inputAboveZero(String prompt, int max) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            value = Integer.parseInt(s.nextLine());

            if (value < 1 && value > max) {
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
    public String getMealType() {
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

    /**
     * Prompts the user for elements of their drink then adds the drink
     */
    public void addNewDrink() {
        System.out.print("Enter drink name: ");
        String name = s.nextLine();
        System.out.print("Enter drink size (milliliters): ");
        int volume = Integer.parseInt(s.nextLine());

        track.addDrink(track.makeDrink(name, volume));
        System.out.println("Drink added");
    }

    /**
     * Checks if the meal a user chooses is healthy
     * 
     * @return if the meal is healthy or not
     */
    public void isMealHealthy() {
        int meal = inputAboveZero("Enter meal number: ", track.getMeals().size() - 1) - 1;
        System.out.println();
        boolean health = track.printMealHealth(meal);
        if (!health) {
            getHealthReason(meal);
        }
    }

    /**
     * Returns the reason a meal is unhealthy
     * 
     * @param meal the index of the meal being checked
     * @return the reason a meal is unhealthy
     */
    public void getHealthReason(int meal) {
        System.out.println();
        while (true) {
            System.out.print("Reason meal is unhealthy? (yes/no): ");
            String answer = s.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                System.out.println(track.getMeals().get(meal).healthReason());
                break;
            } else if (answer.equals("no")) {
                break;
            } else {
                System.out.println("Input invalid try again");
            }
        }
    }
}

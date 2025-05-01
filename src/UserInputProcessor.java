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
            System.out.print("Would you like to add a meal or drink? (meal/drink/no): ");
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
            System.out.print("Would you like to check if your day or meal was healthy? (day/meal/no): ");
            String x = s.nextLine().toLowerCase();

            if (x.equals("day")) {
                track.isDayHealthy();
                x = "";
            } else if (x.equals("meal")) {
                isMealHealthy();
                x = "";
            } else if (x.equals("no")) {
                System.out.println();
                System.out.println("Good lucn on the rest of your diet!");
                break;
            }
        }
    }

    /**
     * Prompts the user for elements of their meal then adds the meal
     */
    public void addNewMeal() {
        String type = "";

        while (true) {
            System.out.print("What type of meal are you having? (breakfast/lunch/dinner/snack): ");
            type = s.nextLine().toLowerCase();

            if (!(type.equals("breakfast") || type.equals("lunch") || type.equals("dinner") || type.equals("snack"))) {
                type = "";
                System.out.println("Input invalid try again");
            } else {
                break;
            }
        }

        System.out.print("Enter the name of your meal: ");
        String name = s.nextLine();
        System.out.print("Enter the time that you ate your meal at: ");
        String time = s.nextLine();
        System.out.print("Enter the amount of calories in your meal: ");
        int calories = Integer.parseInt(s.nextLine());
        System.out.print("Enter the amount of foodgroups in your meal: ");
        int foodGroups = Integer.parseInt(s.nextLine());

        track.addMeal(track.makeMeal(type, name, time, calories, foodGroups));
        System.out.println("Your meal has been added!");
    }

    /**
     * Prompts the user for elements of their drink then adds the drink
     */
    public void addNewDrink() {
        System.out.print("Enter the name of your drink: ");
        String name = s.nextLine();
        System.out.print("Enter the size of your drink (milliliters): ");
        int volume = Integer.parseInt(s.nextLine());

        track.addDrink(track.makeDrink(name, volume));
        System.out.println("Your drink has been added!");
    }

    /**
     * Checks if the meal a user chooses is healthy
     * 
     * @return if the meal is healthy or not
     */
    public void isMealHealthy() {
        System.out.print("Enter the number of the meal you would like to check: ");
        int meal = Integer.parseInt(s.nextLine()) - 1;
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
        System.out.print("Would you like to know why your meal is unhealthy? (yes/no) ");
        String answer = s.nextLine().toLowerCase();

        if (answer.equals("yes")) {
            System.out.println(track.getMeals().get(meal).healthReason());
        }
    }
}

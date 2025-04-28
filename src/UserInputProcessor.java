import java.util.Scanner;

/**
 * UserInputProcessor class: has methods to prompt and recieve user input.
 * 
 * @author NJudd
 */
public class UserInputProcessor {
    private Tracker track = new Tracker();

    /**
     * Prompts the user to either add a meal, drink, or exit
     * 
     * @param s scanner
     */
    public void promptUser(Scanner s) {
        while (true) {
            System.out.print("Would you like to add a meal or drink? ('meal' or 'drink' or 'no'): ");
            String x = s.nextLine().toLowerCase();

            if (x.equals("meal")) {
                addNewMeal(s);
                x = "";
            } else if (x.equals("drink")) {
                addNewDrink(s);
                x = "";
            } else if (x.equals("no")) {
                System.out.println();
                break;
            }
        }
        printTracker();

        while (true) {
            System.out.print("Would you like to check if your day or meal was healthy? ('day' or 'meal' or 'no'): ");
            String x = s.nextLine().toLowerCase();

            if (x.equals("day")) {
                isDayHealthy();
                x = "";
            } else if (x.equals("meal")) {
                isMealHealthy(s);
                x = "";
            } else if (x.equals("no")) {
                System.out.println();
                break;
            }
        }
    }

    /**
     * Prompts the user for elements of their meal then adds the meal
     * 
     * @param s scanner
     */
    public void addNewMeal(Scanner s) {
        System.out.print("What type of meal are you having? ('breakfast' or 'lunch' or 'dinner' or 'snack'): ");
        String type = s.nextLine().toLowerCase();
        System.out.print("Enter the name of your meal: ");
        String name = s.nextLine();
        System.out.print("Enter the time that you ate your meal at: ");
        String time = s.nextLine();
        System.out.print("Enter the amount of calories in your meal: ");
        int calories = Integer.parseInt(s.nextLine());
        System.out.print("Enter the amount of foodgroups in your meal: ");
        int foodGroups = Integer.parseInt(s.nextLine());

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
        track.addMeal(meal);
        System.out.println("Your meal has been added!");
    }

    /**
     * Prompts the user for elements of their drink then adds the drink
     * 
     * @param s scanner
     */
    public void addNewDrink(Scanner s) {
        System.out.print("Enter the name of your drink: ");
        String name = s.nextLine();
        System.out.print("Enter the size of your drink (milliliters): ");
        int volume = Integer.parseInt(s.nextLine());

        Drink drink = new Drink(name, volume);
        track.addDrink(drink);
        System.out.println("Your drink has been added!");
    }

    /**
     * Prints all the meals and drinks the user added
     */
    public void printTracker() {
        System.out.println("Meals: ");

        for (int i = 0; i < track.getMeals().size(); i++) {
            System.out.println(i + 1 + ". " + track.getMeals().get(i));
        }

        System.out.println();
        System.out.println("Drinks: ");

        for (int i = 0; i < track.getDrinks().size(); i++) {
            System.out.println(track.getDrinks().get(i));
        }
    }

    public boolean isDayHealthy() {
        return true;
    }

    /**
     * Checks if the meal a user chooses is healthy
     * 
     * @param s scanner
     */
    public void isMealHealthy(Scanner s) {
        System.out.print("Enter the number of the meal you would like to check: ");
        int meal = Integer.parseInt(s.nextLine()) - 1;

        if (track.getMeals().get(meal).isHealthy()) {
            System.out.println(track.getMeals().get(meal) + " is healthy");
        } else {
            System.out.println(track.getMeals().get(meal) + " is unhealthy");
        }

    }
}

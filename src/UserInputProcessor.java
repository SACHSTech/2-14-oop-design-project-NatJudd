import java.util.Scanner;

public class UserInputProcessor {
    private Tracker track = new Tracker();

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
                break;
            }
        }
    }

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

    public void addNewDrink(Scanner s) {

    }
}

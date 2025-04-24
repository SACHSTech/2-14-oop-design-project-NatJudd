import java.util.Scanner;

public class UserInputProcessor {
    private Tracker track = new Tracker();

    public void promptUser(Scanner s) {
        System.out.println("Would you like to add a meal or drink? ('meal' or 'drink' or 'no')");
        String x = s.nextLine().toLowerCase();

        if (x.equals("meal")) {

        } else if (x.equals("drink")) {

        } else if (x.equals("no")) {

        } else {
            System.out.println("Please enter a valid option ('meal' or 'drink' or 'no')");
        }
    }

    public void addNewMeal() {

    }
}

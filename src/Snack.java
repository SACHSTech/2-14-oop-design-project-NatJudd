/**
 * The snack class
 * 
 * @author NJudd
 */
public class Snack extends Meal {
    private final int healthCalsMax = 200;
    private final int healthFoodGroups = 2;

    public Snack(String name, String time, int calories, int foodGroups) {
        super(name, time, calories, foodGroups);
    }

    @Override
    public boolean isHealthy() {
        if (getCalories() <= healthCalsMax && getFoodGroups() >= healthFoodGroups) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getMeal() {
        return "[" + getTime() + "] Snack: " + getName() + "(" + getCalories() + ")";
    }
}

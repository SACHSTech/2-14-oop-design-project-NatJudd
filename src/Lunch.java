/**
 * The lunch class: a type of meal
 * 
 * @author NJudd
 */
public class Lunch extends Meal {
    private final int healthCalsMax = 700;
    private final int healthCalsMin = 500;
    private final int healthFoodGroups = 3;

    public Lunch(String name, String time, int calories, int foodGroups) {
        super(name, time, calories, foodGroups);
    }

    @Override
    public boolean isHealthy() {
        if (getCalories() <= healthCalsMax && getFoodGroups() >= healthFoodGroups && getCalories() >= healthCalsMin) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getMeal() {
        return "[" + getTime() + "] Lunch: " + getName() + "(" + getCalories() + ")";
    }

}

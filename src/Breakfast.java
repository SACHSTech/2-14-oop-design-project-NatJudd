/**
 * The breakfast class: a type of meal
 * 
 * @author NJudd
 */
public class Breakfast extends Meal {
    private final int healthCalsMax = 500;
    private final int healthCalsMin = 300;
    private final int healthFoodGroups = 3;

    public Breakfast(String name, String time, int calories, int foodGroups) {
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
        return "[" + getTime() + "] Breakfast: " + getName() + "(" + getCalories() + ")";
    }
}

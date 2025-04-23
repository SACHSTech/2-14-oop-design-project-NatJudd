/**
 * The breakfast class
 * 
 * @author NJudd
 */
public class Breakfast extends Meal {
    private final int healthyCals = 500;
    private final int healthyFoodGroups = 3;

    public Breakfast(String name, String time, int calories, int foodGroups) {
        super(name, time, calories, foodGroups);
    }

    @Override
    public boolean isHealthy() {
        if (getCalories() <= healthyCals && getFoodGroups() >= healthyFoodGroups) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSummary() {
        return "[" + getTime() + "] Breakfast: " + getName() + "(" + getCalories() + ")";
    }
}

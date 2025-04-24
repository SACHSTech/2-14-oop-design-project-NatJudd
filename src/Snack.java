/**
 * The snack class: a type of meal
 * 
 * @author NJudd
 */
public class Snack extends Meal {
    private final int healthCalsMax = 200;
    private final int healthFoodGroups = 2;
    private int amount;

    public Snack(String name, String time, int calories, int foodGroups) {
        super(name, time, calories, foodGroups);
        amount += 1;
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

    /**
     * Returns the amount of snack objects a person ate
     * 
     * @return amount of snacks
     */
    public int getSnackAmount() {
        return amount;
    }
}

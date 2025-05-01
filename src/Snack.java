/**
 * The snack class: a type of meal
 * 
 * @author NJudd
 */
public class Snack extends Meal {
    private final int healthCalsMax = 200;
    private final int healthFoodGroups = 2;

    /**
     * Constructor
     * 
     * @param name       meal name
     * @param time       meal time
     * @param calories   amount of calories
     * @param foodGroups amount of foodgroups
     */
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
    public String healthReason() {
        String reason = "";
        if (getCalories() > healthCalsMax) {
            reason += "\nYour meal is " + (getCalories() - healthCalsMax) + " calories over the maximum";
        } 
        if (getFoodGroups() < healthFoodGroups) {
            reason += "\nYour meal has " + (healthFoodGroups - getFoodGroups()) + " too little foodgroups";
        }

        return reason;
    }

    @Override
    public String toString() {
        return "Snack: " + getName() + " (" + getCalories() + ") [" + getTime() + "]";
    }
}

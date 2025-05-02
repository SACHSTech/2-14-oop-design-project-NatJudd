/**
 * The snack class: a type of meal
 * 
 * @author NJudd
 */
public class Snack extends Meal {
    private final int healthCalsMax = 200;
    private final int healthFoodgroups = 2;

    /**
     * Constructor
     * 
     * @param name       meal name
     * @param time       meal time
     * @param calories   amount of calories
     * @param foodgroups amount of foodgroups
     */
    public Snack(String name, String time, int calories, int foodgroups) {
        super(name, time, calories, foodgroups);
    }

    @Override
    public boolean isHealthy() {
        if (getCalories() <= healthCalsMax && getFoodgroups() >= healthFoodgroups) {
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
        if (getFoodgroups() < healthFoodgroups) {
            reason += "\nYour meal has " + (healthFoodgroups - getFoodgroups()) + " too little foodgroups";
        }

        return reason;
    }

    @Override
    public String toString() {
        return "Snack: " + getName() + " (" + getCalories() + ") [" + getTime() + "]";
    }
}

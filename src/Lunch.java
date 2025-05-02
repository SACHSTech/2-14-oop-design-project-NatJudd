/**
 * The lunch class: a type of meal
 * 
 * @author NJudd
 */
public class Lunch extends Meal {
    private final int healthCalsMax = 700;
    private final int healthCalsMin = 500;
    private final int healthFoodgroups = 3;

    /**
     * Constructor
     * 
     * @param name       meal name
     * @param time       meal time
     * @param calories   amount of calories
     * @param foodgroups amount of foodgroups
     */
    public Lunch(String name, String time, int calories, int foodgroups) {
        super(name, time, calories, foodgroups);
    }

    @Override
    public boolean isHealthy() {
        if (getCalories() <= healthCalsMax && getFoodgroups() >= healthFoodgroups && getCalories() >= healthCalsMin) {
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
        if (getCalories() < healthCalsMin) {
            reason += "\nYour meal is " + (healthCalsMin - getCalories()) + " calories under the minimum";
        }
        if (getFoodgroups() < healthFoodgroups) {
            reason += "\nYour meal has " + (healthFoodgroups - getFoodgroups()) + " too little foodgroups";
        }

        return reason;
    }

    @Override
    public String toString() {
        return "Lunch: " + getName() + " (" + getCalories() + ") [" + getTime() + "]";
    }

}

/**
 * The breakfast class: a type of meal
 * 
 * @author NJudd
 */
public class Breakfast extends Meal {
    private final int healthCalsMax = 500;
    private final int healthCalsMin = 300;
    private final int healthfoodgroups = 3;

    /**
     * Constructor
     * 
     * @param name       meal name
     * @param time       meal time
     * @param calories   amount of calories
     * @param foodgroups amount of foodgroups
     */
    public Breakfast(String name, String time, int calories, int foodgroups) {
        super(name, time, calories, foodgroups);
    }

    @Override
    public boolean isHealthy() {
        if (getCalories() <= healthCalsMax && getFoodgroups() >= healthfoodgroups && getCalories() >= healthCalsMin) {
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
        if (getFoodgroups() < healthfoodgroups) {
            reason += "\nYour meal has " + (healthfoodgroups - getFoodgroups()) + " too little foodgroups";
        }

        return reason;
    }

    @Override
    public String toString() {
        return "Breakfast: " + getName() + " (" + getCalories() + ") [" + getTime() + "]";
    }
}

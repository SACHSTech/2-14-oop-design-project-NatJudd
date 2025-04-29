/**
 * The dinner class: a type of meal
 * 
 * @author NJudd
 */
public class Dinner extends Meal {
    private final int healthCalsMax = 700;
    private final int healthCalsMin = 500;
    private final int healthFoodGroups = 4;

    /**
     * Constructor
     * 
     * @param name       meal name
     * @param time       meal time
     * @param calories   amount of calories
     * @param foodGroups amount of foodgroups
     */
    public Dinner(String name, String time, int calories, int foodGroups) {
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
    public String healthReason() {
        String reason = "";
        if (getCalories() > healthCalsMax) {
            reason += "\nYour meal is " + (getCalories() - healthCalsMax) + " calories over the maximum";
        } 
        if (getCalories() < healthCalsMin) {
            reason += "\nYour meal is " + (healthCalsMin - getCalories()) + " calories under the minimum";
        } 
        if (getFoodGroups() < healthFoodGroups) {
            reason += "\nYour meal has " + (healthFoodGroups - getFoodGroups()) + " too little foodgroups";
        }

        return reason;
    }

    @Override
    public String toString() {
        return "[" + getTime() + "] Dinner: " + getName() + "(" + getCalories() + ")";
    }
}

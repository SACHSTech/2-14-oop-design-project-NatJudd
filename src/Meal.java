/**
 * The meal class: represents the details/macros that a person eats in a meal
 * 
 * @author NJudd
 */
public abstract class Meal {
    private String name;
    private String time;
    private int calories;
    private int foodGroups;

    /**
     * Constructor
     * 
     * @param name       meal name
     * @param time       meal time
     * @param calories   amount of calories
     * @param foodGroups amount of foodgroups
     */
    public Meal(String name, String time, int calories, int foodGroups) {
        this.name = name;
        this.time = time;
        this.calories = calories;
        this.foodGroups = foodGroups;
    }

    /**
     * Returns if a meal is healthy or unhealthy
     * 
     * @return true if healthy and false if unhealthy
     */
    public abstract boolean isHealthy();

    /**
     * Returns a summary of a meal/meal details
     * 
     * @return meal summary
     */
    public abstract String getMeal();

    /**
     * Returns the name of a meal
     * 
     * @return meal name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the time a meal was ate
     * 
     * @return meal time
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns the amount of calories in a meal
     * 
     * @return amount of calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Returns the amount of foodgroups in a meal
     * 
     * @return amount of foodgroups
     */
    public int getFoodGroups() {
        return foodGroups;
    }
}

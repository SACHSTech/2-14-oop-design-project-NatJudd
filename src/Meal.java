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

    public Meal(String name, String time, int calories, int foodGroups) {
        this.name = name;
        this.time = time;
        this.calories = calories;
        this.foodGroups = foodGroups;
    }

    public abstract boolean isHealthy();

    public abstract String getMeal();

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getCalories() {
        return calories;
    }

    public int getFoodGroups() {
        return foodGroups;
    }
}

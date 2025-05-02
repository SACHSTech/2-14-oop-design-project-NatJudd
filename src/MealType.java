/**
 * Represents the different types of meals
 * 
 * @author NJudd
 */
public enum MealType {
    BREAKFAST("breakfast"),
    LUNCH("lunch"),
    DINNER("dinner"),
    SNACK("snack");

    private final String name;

    /**
     * Constructor
     * 
     * @param name meal type display name
     */
    MealType(String name) {
        this.name = name;
    }

    /**
     * Returns the meal type display name
     * 
     * @return display name
     */
    public String getName() {
        return name;
    }
}

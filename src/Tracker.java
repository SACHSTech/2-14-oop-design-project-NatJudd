import java.util.ArrayList;
import java.util.List;

/**
 * The tracker class: represents all the meals and drinks a person has in a day
 * 
 * @author NJudd
 */
public class Tracker {
    private List<Meal> meals = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();

    public void addMeal(Meal e) {
        meals.add(e);
    }

    public void addDrink(Drink e) {
        drinks.add(e);
    }
}

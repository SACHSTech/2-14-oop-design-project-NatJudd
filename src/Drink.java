/**
 * The drink clas: represents the drinks that a person consumes
 * 
 * @author NJudd
 */
public class Drink {
    private String name;
    private int volume;

    /**
     * Constructor
     * 
     * @param name   drink name
     * @param volume drink volume (milliliters)
     */
    public Drink(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    /**
     * Returns the name of the drink
     * 
     * @return drink name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the volume of the drink (milliliters)
     * 
     * @return drink volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Returns if the drink is water or not
     * 
     * @return true if water else false
     */
    public boolean isWater() {
        return name.toLowerCase() == "water";
    }

    public String toString() {
        return "Drink: " + getName() + "(" + getVolume() + " ml)";
    }
}

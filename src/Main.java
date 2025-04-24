import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        UserInputProcessor u = new UserInputProcessor();
        u.promptUser(s);
    }
}

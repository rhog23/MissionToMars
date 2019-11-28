import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        ArrayList<Item> u1Items = simulation.loadItems("phase-1.txt");
        ArrayList<Item> u2Items = simulation.loadItems("phase-2.txt");
        ArrayList<U1> u1s = simulation.loadU1(u1Items);
        ArrayList<U2> u2s = simulation.loadU2(u2Items);

        System.out.println(u1s.size());
        System.out.println(u2s.size());
    }
}

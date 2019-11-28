import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulation {

    private ArrayList<U1> loadedU1;
    private ArrayList<U2> loadedU2;

    Simulation() {
        loadedU1 = new ArrayList<>();
        loadedU2 = new ArrayList<>();
    }

    public ArrayList<Item> loadItems(String phaseTxtFile) {

        ArrayList<Item> items = new ArrayList<>();

        File file = new File(phaseTxtFile);
        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String name = line.split("=")[0].trim();
                int weight = Integer.parseInt(line.split("=")[1].trim());
                Item item = new Item(name, weight);
                items.add(item);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return items;
    }

    ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> u1Rockets = new ArrayList<>();
        // The total cargo(s) that will be loaded to a U1 rocket
        int totalCargoCounter = items.size();
        // A counter to keep track of how many cargo(s) has been loaded to a U1 rocket
        int cargoCounter = 0;

        // Loops while there are still cargo(s) left
        while (totalCargoCounter > 0) {
            // Create a new U1 rocket
            U1 u1 = new U1();

            // Iterator to retrieve item inside items ArrayList
            Iterator<Item> iter = items.iterator();

            // Loops while there is an item in the items ArrayList
            while (iter.hasNext()) {
                Item item = iter.next();
                // Checks whether the rocket is not yet full
                if (u1.canCarry(item)) {
                    // Updates the rocket's cargo weight
                    u1.carry(item);
                    // removes the item that has been loaded
                    iter.remove();
                    // Adding the cargo counter by 1, which means that a cargo has been loaded to the rocket
                    cargoCounter++;
                } else {
                    // Stops the loop when the rocket already full
                    break;
                }
            }

            // Add the current fully loaded U1 rocket to the u1Rocket ArrayList
            u1Rockets.add(u1);

            // Reduce the amount of total cargo by the amount of cargo (cargo counter) that has been loaded into the previous U1 rocket
            totalCargoCounter -= cargoCounter;

            /*
            * resets the cargo counter to zero,
            * because in the next new U1 rocket,
            * the amount of cargo loaded to the rocket becomes 0
            * */

            cargoCounter = 0;
        }
        // Returns the u1s ArrayList
        return u1Rockets;
    }

    ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> u2Rockets = new ArrayList<>();
        // The total cargo(s) that will be loaded to a U1 rocket
        int totalCargoCounter = items.size();
        // A counter to keep track of how many cargo(s) has been loaded to a U2 rocket
        int cargoCounter = 0;

        // Loops while there are still cargo(s) left
        while (totalCargoCounter > 0) {
            // Create a new U2 rocket
            U2 u2 = new U2();

            // Iterator to retrieve item inside items ArrayList
            Iterator<Item> iter = items.iterator();

            // Loops while there is an item in the items ArrayList
            while (iter.hasNext()) {
                Item item = iter.next();
                // Checks whether the rocket is not yet full
                if (u2.canCarry(item)) {
                    // Updates the rocket's cargo weight
                    u2.carry(item);
                    // removes the item that has been loaded
                    iter.remove();
                    // Adding the cargo counter by 1, which means that a cargo has been loaded to the rocket
                    cargoCounter++;
                } else {
                    // Stops the loop when the rocket already full
                    break;
                }
            }

            u2Rockets.add(u2);

            totalCargoCounter -= cargoCounter;

            cargoCounter = 0;
        }
        // Returns the u2s ArrayList
        return u2Rockets;
    }




}

/*
 * SpaceShip interface that contains methods to build a spaceship
 * */
public interface SpaceShip {

    /*
     * returns true or false, indicating if the launch was successful or rocket has crashed
     */
    boolean launch();

    /*
     * returns true or false based on the success of the landing
     */
    boolean land();

    /*
     * params: Item
     * returns true if rocket can carry such item, or false if it will exceed the weight limit
     */
    boolean canCarry(Item item);

    /*
     * params: Item
     * updates the weight of the rocket*/
    void carry(Item item);
}

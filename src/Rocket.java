public class Rocket implements SpaceShip {

    private int rocketCost;
    private int rocketWeight;
    private int rocketMaxWeight;
    private int cargoWeight = 0;

    Rocket (int rocketCost, int rocketWeight, int rocketMaxWeight) {
        this.rocketCost = rocketCost;
        this.rocketWeight = rocketWeight;
        this.rocketMaxWeight = rocketMaxWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public void carry(Item item) {
        cargoWeight += item.getWeight();
    }

    @Override
    public boolean canCarry(Item item) {
        return (rocketWeight + cargoWeight + item.getWeight()) <= rocketMaxWeight;
    }

    public double calculation() {
        return cargoWeight / rocketMaxWeight;
    }

    public int getRocketCost() {
        return rocketCost;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public int getRocketMaxWeight() {
        return rocketMaxWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    protected double getRandomChance() {
        return Math.random() * 100;
    }
}

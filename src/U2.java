public class U2 extends Rocket {
    U2() {
        super(120, 18000, 29000);
    }

    @Override
    public boolean land() {
        double chance = 8.0 * calculation();

        return getRandomChance() >= chance;
    }

    @Override
    public boolean launch() {
        double chance = 4.0 * calculation();
        return getRandomChance() >= chance;
    }
}

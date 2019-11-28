public class U1 extends Rocket {

    /*
    * Rocket cost = $100 Million
    * Rocket weight = 10 Tonnes
    * Max weight (with cargo) = 18 Tonnes
    * Chance of launch explosion = 5% * (cargo carried / cargo limit)
    * Chance of landing crash = 1% * (cargo carried / cargo limit)
    */

    U1 () {
        super(100, 10000, 18000);
    }

    @Override
    public boolean land() {
        double chance = 1.0 * calculation();

        return getRandomChance() >= chance;
    }

    @Override
    public boolean launch() {
        double chance = 5.0 * calculation();
        return getRandomChance() >= chance;
    }
}

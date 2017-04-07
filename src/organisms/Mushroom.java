package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public abstract class Mushroom extends AliveOrganism {

    public Mushroom(int lifeExpectancy, String dateOfBirds, boolean isPoisonous) {
        super(lifeExpectancy, dateOfBirds);
        this.isPoisonous = isPoisonous;
    }

    private boolean isPoisonous;

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean poisonous) {
        isPoisonous = poisonous;
    }
}
package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public abstract class Mushroom extends AliveOrganism {

    public Mushroom(int lifeExpectancy, String dateOfBirds,int countOfFields, int isPoisonous) {
        super(lifeExpectancy, dateOfBirds,countOfFields);
        this.isPoisonous = isPoisonous;
    }

    private int isPoisonous;

    public int isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(int poisonous) {
        this.isPoisonous = poisonous;
    }
}

package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public abstract class Mushroom extends AliveOrganism {
    private int isPoisonous;

    public Mushroom(int lifeExpectancy, String dateOfBirds,int countOfFields, int isPoisonous) {
        super(lifeExpectancy, dateOfBirds,countOfFields);
        this.setPoisonous(isPoisonous);
    }

     public int isPoisonous() {
        return isPoisonous;
    }

    private void setPoisonous(int poisonous) {
        this.isPoisonous = poisonous;
    }
}

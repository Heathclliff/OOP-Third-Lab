package organisms;

/**
 * Created by Валерий on 06.04.2017.
 */
public abstract class Animal extends AliveOrganism {

    public Animal(int lifeExpectancy, String dateOfBirds, boolean isMammal) {
        super(lifeExpectancy, dateOfBirds);
        isMammal = isMammal;
    }

    private  boolean isMammal;

    public boolean isMammal() {
        return isMammal;
    }

    public void setMammal(boolean mammal) {
        isMammal = mammal;
    }
}

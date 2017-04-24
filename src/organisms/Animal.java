package organisms;

/**
 * Created by Валерий on 06.04.2017.
 */
public abstract class Animal extends AliveOrganism {

    public Animal(int lifeExpectancy, String dateOfBirds,int countOfFields, boolean isMammal) {
        super(lifeExpectancy, dateOfBirds,countOfFields);
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

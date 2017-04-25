package organisms;

/**
 * Created by Валерий on 06.04.2017.
 */
public abstract class Animal extends AliveOrganism {

    public Animal(int lifeExpectancy, String dateOfBirds,int countOfFields, int isMammal) {
        super(lifeExpectancy, dateOfBirds,countOfFields);
        this.setMammal(isMammal);
    }

    private  int isMammal;

    public int isMammal() {
        return isMammal;
    }

    public void setMammal(int mammal) {
        this.isMammal = mammal;
    }
}

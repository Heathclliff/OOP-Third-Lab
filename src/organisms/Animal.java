package organisms;

/**
 * Created by Валерий on 06.04.2017.
 */
public abstract class Animal extends AliveOrganism {

    public Animal(int lifeExpectancy, String dateOfBirds, int isMammal) {
        super(lifeExpectancy, dateOfBirds);
        this.setMammal(isMammal);
    }

    private  int countOfFields=4;

    private  int isMammal;

    public int isMammal() {
        return isMammal;
    }

    private void setMammal(int mammal) {
        this.isMammal = mammal;
    }
}

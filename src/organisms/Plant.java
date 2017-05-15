package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public abstract class Plant extends  AliveOrganism {
    public Plant(int lifeExpectancy, String dateOfBirds, int isParasite) {
        super(lifeExpectancy, dateOfBirds);
        this.setParasite(isParasite);
    }

    private  int countOfFields=3;

    private int isParasite;

    public int isParasite() {
        return isParasite;
    }

    private void setParasite(int parasite) {
        this.isParasite = parasite;
    }
}

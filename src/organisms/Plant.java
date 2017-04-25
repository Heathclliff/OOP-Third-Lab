package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public abstract class Plant extends  AliveOrganism {
    public Plant(int lifeExpectancy, String dateOfBirds,int countOfFields, int isParasite) {
        super(lifeExpectancy, dateOfBirds,countOfFields);
        isParasite = isParasite;
    }

    private int isParasite;

    public int isParasite() {
        return isParasite;
    }

    public void setParasite(int parasite) {
        isParasite = parasite;
    }
}

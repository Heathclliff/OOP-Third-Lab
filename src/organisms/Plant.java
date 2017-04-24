package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public abstract class Plant extends  AliveOrganism {
    public Plant(int lifeExpectancy, String dateOfBirds,int countOfFields, boolean isParasite) {
        super(lifeExpectancy, dateOfBirds,countOfFields);
        isParasite = isParasite;
    }

    private boolean isParasite;

    public boolean isParasite() {
        return isParasite;
    }

    public void setParasite(boolean parasite) {
        isParasite = parasite;
    }
}

package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public abstract class Plant extends  AliveOrganism {
    public Plant(int lifeExpectancy, String dateOfBirds, boolean isParasite) {
        super(lifeExpectancy, dateOfBirds);
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

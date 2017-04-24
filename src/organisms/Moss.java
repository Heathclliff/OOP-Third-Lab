package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Moss extends Plant {
    public Moss(int lifeExpectancy, String dateOfBirds,int countOfFields, boolean isParasite, String master) {
        super(lifeExpectancy, dateOfBirds,countOfFields, isParasite);
        this.master = master;
    }

    private String master;

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}

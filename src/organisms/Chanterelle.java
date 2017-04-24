package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Chanterelle extends Mushroom {
    public Chanterelle(int lifeExpectancy, String dateOfBirds,int countOfFields, boolean isPoisonous, int shadeOfYellow) {
        super(lifeExpectancy, dateOfBirds,countOfFields, isPoisonous);
        this.shadeOfYellow = shadeOfYellow;
    }

    private int shadeOfYellow;

    public int getShadeOfYellow() {
        return shadeOfYellow;
    }

    public void setShadeOfYellow(int shadeOfYellow) {
        this.shadeOfYellow = shadeOfYellow;
    }
}

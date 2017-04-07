package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Rose extends Plant {

    public Rose(int lifeExpectancy, String dateOfBirds, boolean isParasite, int numberOfSpikes) {
        super(lifeExpectancy, dateOfBirds, isParasite);
        this.numberOfSpikes = numberOfSpikes;
    }

    private int numberOfSpikes;

    public int getNumberOfSpikes() {
        return numberOfSpikes;
    }

    public void setNumberOfSpikes(int numberOfSpikes) {
        this.numberOfSpikes = numberOfSpikes;
    }

}

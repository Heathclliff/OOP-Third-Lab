package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Rose extends Plant {

    public Rose(int lifeExpectancy, String dateOfBirds,int countOfFileds, boolean isParasite, int numberOfSpikes) {
        super(lifeExpectancy, dateOfBirds,countOfFileds, isParasite);
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

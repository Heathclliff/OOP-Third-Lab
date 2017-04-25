package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Rose extends Plant {

    public Rose(int lifeExpectancy, String dateOfBirds,int countOfFileds, int isParasite, int numberOfSpikes) {
        super(lifeExpectancy, dateOfBirds,countOfFileds, isParasite);
        this.setNumberOfSpikes(numberOfSpikes);
    }

    private int numberOfSpikes;

    public int getNumberOfSpikes() {
        return numberOfSpikes;
    }

    public void setNumberOfSpikes(int numberOfSpikes) {
        this.numberOfSpikes = numberOfSpikes;
    }

    @Override
    public String[] getTextFields(){
        String[] textfields={"продолжительность жизни","дата рождения","паразит?","количество шипов"};
        return textfields;
    }

}

package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Rose extends Plant {

    public Rose(int lifeExpectancy, String dateOfBirds, int isParasite, int numberOfSpikes) {
        super(lifeExpectancy, dateOfBirds, isParasite);
        this.setNumberOfSpikes(numberOfSpikes);
    }

    private  int countOfFields=4;

    private int numberOfSpikes;

    public int getNumberOfSpikes() {
        return numberOfSpikes;
    }

    private void setNumberOfSpikes(int numberOfSpikes) {
        this.numberOfSpikes = numberOfSpikes;
    }

    @Override
    public String[] getTextFields(){
        String[] textfields={"продолжительность жизни","дата рождения","паразит?","количество шипов"};
        return textfields;
    }

}

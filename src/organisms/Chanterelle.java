package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Chanterelle extends Mushroom {
    public Chanterelle(int lifeExpectancy, String dateOfBirds, int isPoisonous, int shadeOfYellow) {
        super(lifeExpectancy, dateOfBirds, isPoisonous);
        this.setShadeOfYellow(shadeOfYellow);
    }
    private  int countOfFields=4;
    private int shadeOfYellow;

    public int getShadeOfYellow() {
        return shadeOfYellow;
    }

    private void setShadeOfYellow(int shadeOfYellow) {
        this.shadeOfYellow = shadeOfYellow;
    }

    @Override
    public String[] getTextFields(){
        String[] textfields={"продолжительность жизни","дата рождения","отравлен?","оттенок желтого"};
        return textfields;
    }
}

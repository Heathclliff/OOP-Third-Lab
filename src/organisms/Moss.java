package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Moss extends Plant {
    public Moss(int lifeExpectancy, String dateOfBirds, int isParasite, String master) {
        super(lifeExpectancy, dateOfBirds, isParasite);
        this.setMaster(master);
    }

    private  int countOfFields=4;

    private String master;

    public String getMaster() {
        return master;
    }

    private void setMaster(String master) {
        this.master = master;
    }

    @Override
    public String[] getTextFields(){
        String[] textfields={"продолжительность жизни","дата рождения","паразит?","хозяин"};
        return textfields;
    }
}

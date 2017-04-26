package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Moss extends Plant {
    public Moss(int lifeExpectancy, String dateOfBirds,int countOfFields, int isParasite, String master) {
        super(lifeExpectancy, dateOfBirds,countOfFields, isParasite);
        this.setMaster(master);
    }

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

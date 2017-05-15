package organisms;

/**
 * Created by Валерий on 06.04.2017.
 */
public abstract class AliveOrganism {

    private int lifeExpectancy;
    private String dateOfBirds;
    private  int countOfFields=3;

    public int getCountOfFields() {
        return countOfFields;
    }

    private void setCountOfFields(int countOfFields) {
        this.countOfFields = countOfFields;
    }

    public AliveOrganism(int lifeExpectancy, String dateOfBirds) {
        this.setLifeExpectancy(lifeExpectancy);
        this.setDateOfBirds(dateOfBirds);
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getDateOfBirds() {
        return dateOfBirds;
    }

    public void setDateOfBirds(String dateOfBirds) {
        this.dateOfBirds = dateOfBirds;
    }

    public void grow(){
        System.out.println("I'm growing");
    }

    public abstract String[] getTextFields();

}

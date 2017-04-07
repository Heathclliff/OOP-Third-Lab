package organisms;

/**
 * Created by Валерий on 06.04.2017.
 */
public abstract class AliveOrganism {

    private int lifeExpectancy;
    private String dateOfBirds;

    public AliveOrganism(int lifeExpectancy, String dateOfBirds) {
        lifeExpectancy = lifeExpectancy;
        dateOfBirds = dateOfBirds;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        lifeExpectancy = lifeExpectancy;
    }

    public String getDateOfBirds() {
        return dateOfBirds;
    }

    public void setDateOfBirds(String dateOfBirds) {
        dateOfBirds = dateOfBirds;
    }

    public void grow(){
        System.out.println("I'm growing");
    }

}

package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Amanita extends Mushroom {
    public Amanita(int lifeExpectancy, String dateOfBirds,int countOfFields,int isPoisonous, int lengthOfSkirt) {
        super(lifeExpectancy, dateOfBirds,countOfFields, isPoisonous);
        this.lengthOfSkirt = lengthOfSkirt;
    }

    private int lengthOfSkirt;

    public int getLengthOfSkirt() {
        return lengthOfSkirt;
    }

    public void setLengthOfSkirt(int lengthOfSkirt) {
        this.lengthOfSkirt = lengthOfSkirt;
    }

    public void poison(){
        System.out.println("You are poisoned!");
    }

    @Override
    public String[] getTextFields(){
        String[] textfields={"продолжительность жизни","дата рождения","отравлен?","длина юбки"};
        return textfields;
    }
}

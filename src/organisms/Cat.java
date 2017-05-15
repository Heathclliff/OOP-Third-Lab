package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Cat extends Animal {
    public Cat(int lifeExpectancy, String dateOfBirds, int isMammal) {
        super(lifeExpectancy, dateOfBirds, isMammal);
    }

    private  int countOfFields=3;

    public void mew(){
        System.out.println("Mew-Mew!");
    }

    @Override
    public String[] getTextFields(){
        String[] textfields={"продолжительность жизни","дата рождения","млекопитающее?"};
        return textfields;
    }
}

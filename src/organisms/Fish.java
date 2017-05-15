package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Fish extends Animal {
    public Fish(int lifeExpectancy, String dateOfBirds, int isMammal) {
        super(lifeExpectancy, dateOfBirds, isMammal);
    }

    private  int countOfFields=3;

    public void swimming(){
        System.out.println("Swim-swim");
    }

    @Override
    public String[] getTextFields(){
        String[] textfields={"продолжительность жизни","дата рождения","млекопитающее?"};
        return textfields;
    }
}

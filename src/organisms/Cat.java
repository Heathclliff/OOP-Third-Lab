package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Cat extends Animal {
    public Cat(int lifeExpectancy, String dateOfBirds, boolean isMammal) {
        super(lifeExpectancy, dateOfBirds, isMammal);
    }

    public void mew(){
        System.out.println("Mew-Mew!");
    }
}

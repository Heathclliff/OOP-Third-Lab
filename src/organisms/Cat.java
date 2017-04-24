package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Cat extends Animal {
    public Cat(int lifeExpectancy, String dateOfBirds,int countOfFields, boolean isMammal) {
        super(lifeExpectancy, dateOfBirds,countOfFields, isMammal);
    }

    public void mew(){
        System.out.println("Mew-Mew!");
    }
}

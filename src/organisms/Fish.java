package organisms;

/**
 * Created by Валерий on 07.04.2017.
 */
public class Fish extends Animal {
    public Fish(int lifeExpectancy, String dateOfBirds,int countOfFields, boolean isMammal) {
        super(lifeExpectancy, dateOfBirds,countOfFields, isMammal);
    }

    public void swimming(){
        System.out.println("Swim-swim");
    }
}

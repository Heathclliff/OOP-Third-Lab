package decorator;

import organisms.AliveOrganism;

/**
 * Created by Валерий on 01.06.2017.
 */
public class DecoratorOrganism {
    private AliveOrganism aliveOrganism;

    public DecoratorOrganism(AliveOrganism aliveOrganism){
        this.aliveOrganism=aliveOrganism;
    }

    public String getName(){
        return aliveOrganism.getClass().getSimpleName() + ' ' + aliveOrganism.getDateOfBirds();
    }

    public AliveOrganism getAliveOrganism() {
        return aliveOrganism;
    }
}

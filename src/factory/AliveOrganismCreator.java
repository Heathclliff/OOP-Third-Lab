package factory;

import organisms.AliveOrganism;

/**
 * Created by Валерий on 12.04.2017.
 */
public interface AliveOrganismCreator {
    AliveOrganism CreateOrganism(int[] numbers);
}

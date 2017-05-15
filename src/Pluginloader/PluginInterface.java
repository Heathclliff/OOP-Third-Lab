package Pluginloader;

import factory.AliveOrganismCreator;
import factory.AliveOrganismFields;

/**
 * Created by Валерий on 15.05.2017.
 */
public interface PluginInterface {
    String getName();
    AliveOrganismCreator getCreator();
    AliveOrganismFields getFields();
    String[] getTextFields();

}

package Pluginloader; /**
 * Created by Валерий on 13.05.2017.
 */

import factory.AliveOrganismCreator;
import factory.AliveOrganismFields;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ModuleEngine {
    public List<PluginInterface> work(ModuleLoader moduleLoader) {

        List<PluginInterface> result = new ArrayList();

        File dir = new File("plugins");
        String[] modules = dir.list();

        PluginInterface pluginInterface = new PluginInterface() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public AliveOrganismCreator getCreator() {
                return null;
            }

            @Override
            public AliveOrganismFields getFields() {
                return null;
            }

            @Override
            public String[] getTextFields() {
                return new String[0];
            }
        };

        for (String module: modules) {
            try {
                String moduleName = module.split(".class")[0];
                Class clazz = moduleLoader.loadClass(moduleName);


                Class[] arrayinterfaces = clazz.getInterfaces();

                boolean isMainClassPlugin = false;

                for (Class classInterface: arrayinterfaces) {
                    isMainClassPlugin = classInterface.isInstance(pluginInterface);
                    if(isMainClassPlugin){
                        break;
                    }
                }

                if (isMainClassPlugin){
                    result.add((PluginInterface) clazz.newInstance());
                    /*PluginInterface newPlugin = (PluginInterface) clazz.newInstance();
                    factory.addNewAnimal(newPlugin.getName(),newPlugin.getCreator(),newPlugin.getFields());*/
                }


            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

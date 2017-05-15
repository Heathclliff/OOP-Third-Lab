package Pluginloader; /**
 * Created by Валерий on 13.05.2017.
 */

import Serialize.SerializePlugin;
import factory.AliveOrganismCreator;
import factory.AliveOrganismFields;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ModuleEngine {

    private List<PluginInterface> pluginInterfaces = new ArrayList();

    private List<SerializePlugin> pluginSerializes = new ArrayList();

    public List<PluginInterface> getPluginInterfaces() {
        return pluginInterfaces;
    }

    public List<SerializePlugin> getPluginSerializes() {
        return pluginSerializes;
    }

    public void work(ModuleLoader moduleLoader) {

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
        SerializePlugin serializePlugin = new SerializePlugin() {
            @Override
            public InputStream getInputStream(InputStream stream) {
                return null;
            }

            @Override
            public OutputStream getOutputStream(OutputStream stream) {
                return null;
            }
        };

        for (String module: modules) {
            try {
                String moduleName = module.split(".class")[0];
                Class clazz = moduleLoader.loadClass(moduleName);

                Class[] arrayinterfaces = clazz.getInterfaces();

                boolean isMainClassPlugin = false;
                boolean isSerializer = false;

                for (Class classInterface: arrayinterfaces) {
                    isMainClassPlugin = classInterface.isInstance(pluginInterface);
                    isSerializer = classInterface.isInstance(serializePlugin);
                    if(isMainClassPlugin||isSerializer){
                        break;
                    }
                }

                if (isMainClassPlugin){
                    this.pluginInterfaces.add((PluginInterface) clazz.newInstance());
                }

                if(isSerializer){
                    this.pluginSerializes.add((SerializePlugin) clazz.newInstance());
                }



            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ClassCastException e) {
                e.printStackTrace();
            }
        }
    }
}

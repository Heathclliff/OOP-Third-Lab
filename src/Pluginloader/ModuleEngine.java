package Pluginloader; /**
 * Created by Валерий on 13.05.2017.
 */

import Serialize.SerializePlugin;

import java.io.File;
import java.io.FileFilter;
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

        File pluginDir = new File("plugins");

        File[] jars = pluginDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".jar");
            }
        });

        for (File file : jars) {
            try {
                PluginInfo newplagin = new PluginInfo(file,moduleLoader);
                if(newplagin.getTypeInterface().equals("Organism")){
                    this.pluginInterfaces.add((PluginInterface) newplagin.getPluginInstance());
                }
                else if(newplagin.getTypeInterface().equals("Serializator")){
                    this.pluginSerializes.add((SerializePlugin) newplagin.getPluginInstance());
                }
            } catch (Exception e) {}
        }
    }
}

package Pluginloader; /**
 * Created by Валерий on 13.05.2017.
 */

import organisms.AliveOrganism;

import java.io.File;

public class ModuleEngine {
    public void work() {
        ModuleLoader loader = new ModuleLoader("plugins", ClassLoader.getSystemClassLoader());

        File dir = new File("plugins");
        String[] modules = dir.list();

        for (String module: modules) {
            try {
                String moduleName = module.split(".class")[0];
                System.out.println(moduleName);
                Class clazz = loader.loadClass(moduleName);

                AliveOrganism execute = (AliveOrganism) clazz.newInstance();

                System.out.println(execute.getCountOfFields());

            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

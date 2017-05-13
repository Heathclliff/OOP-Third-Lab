import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * Created by Валерий on 26.04.2017.
 */
public class UploadPlugin extends ClassLoader {

    private java.util.List<String> plugins = new ArrayList<>();

    public void downloadPlugin() {
        File pluginDir = new File("plugins");

        File[] jars = pluginDir.listFiles(new FileFilter() {
            public boolean accept(File file) {return file.isFile() && file.getName().endsWith(".class");
            }
        });

        Class[] pluginClasses = new Class[jars.length];

        for (int i=0;i<jars.length;i++) {
            try {
                plugins.add(jars[i].getName());
                System.out.println(jars[i].getName());
                try {

                    URL jarURL = jars[i].toURI().toURL();
                    URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL});
                    pluginClasses[i] = classLoader.loadClass("plugins\\Wolf.class");
                } catch (MalformedURLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}


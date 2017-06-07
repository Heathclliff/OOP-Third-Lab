package Pluginloader; /**
 * Created by Валерий on 13.05.2017.
 */
import java.net.URL;
import java.net.URLClassLoader;

public class ModuleLoader extends URLClassLoader {
    public ModuleLoader(URL[] urls, ClassLoader parent) {
        super(urls,parent);
    }
    public ModuleLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public void addURL(URL url) {
        super.addURL(url);
    }
}


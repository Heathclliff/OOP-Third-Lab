package Pluginloader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginInfo {
    protected Object instance;
    protected String type;
    protected String name;

    public PluginInfo(File jarFile, ModuleLoader loader) throws Exception {
        try {
            JarFile jar = new JarFile(jarFile);

            Properties props = getPluginProps(jar);
            if (props == null)
                throw new IllegalArgumentException("No props file found");

            String pluginClassName = props.getProperty("main.class");
            if (pluginClassName == null || pluginClassName.length() == 0) {
                throw new Exception("Missing property main.class");
            }

            type = props.getProperty("type.interface");
            if (pluginClassName == null || pluginClassName.length() == 0) {
                throw new Exception("Missing property type.interface");
            }

            name = jarFile.getName();

            URL jarURL = jarFile.toURI().toURL();
            loader.addURL(jarURL);
            Class pluginClass = loader.loadClass(pluginClassName);
            instance = pluginClass.newInstance();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Object getPluginInstance() {
        return instance;
    }
    public String getTypeInterface(){ return type; }
    public String getNameFile(){ return name; }

    private Properties getPluginProps(JarFile jar) throws IOException,ClassCastException {
        Properties result = null;
        Enumeration entries = jar.entries();

        while (entries.hasMoreElements()) {
            JarEntry entry = (JarEntry)entries.nextElement();
            if (entry.getName().equals("plugin.properties")) {
                InputStream is = null;
                try {
                    is = jar.getInputStream(entry);
                    result = new Properties();
                    result.load(is);
                } finally {
                    if (is != null)
                        is.close();
                }
            }
        }
        return result;
    }
}
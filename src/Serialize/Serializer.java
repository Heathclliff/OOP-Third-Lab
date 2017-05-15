package Serialize;

import Pluginloader.ModuleLoader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import organisms.AliveOrganism;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Валерий on 26.04.2017.
 */
public class Serializer {

    private java.util.List<AliveOrganism> aliveOrganismsList = new ArrayList<>();
    private List<SerializePlugin> serializePlugins = new ArrayList<>();
    private  ModuleLoader moduleLoader;

    public List<AliveOrganism> getAliveOrganismsList() {
        return aliveOrganismsList;
    }

    private void setAliveOrganismsList(List<AliveOrganism> aliveOrganismsList) {
        this.aliveOrganismsList = aliveOrganismsList;
    }

    public Serializer(java.util.List<AliveOrganism> aliveOrganismsList,ModuleLoader moduleLoader,List<SerializePlugin> serializePlugins) {
        this.setAliveOrganismsList(aliveOrganismsList);
        this.moduleLoader=moduleLoader;
        this.serializePlugins=serializePlugins;

    }

    public void serialize() {
        String fileName;
        fileName = getFileName();
        XStream xStream = new XStream(new DomDriver());
        xStream.setClassLoader(moduleLoader);
        try {
            FileOutputStream fs = new FileOutputStream(fileName);
            OutputStream outputStream = fs;
            for (SerializePlugin serPlug:serializePlugins) {
                outputStream=serPlug.getOutputStream(outputStream);
            }
            xStream.toXML(this.getAliveOrganismsList(), outputStream);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    private String getFileName() {
        String fileName = "";
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Выберите файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            java.io.File file = new java.io.File(String.valueOf(fileopen.getSelectedFile()));
            fileName = file.getAbsolutePath();
        }
        return fileName;
    }

    public void deserialize() {
        String fileName;
        fileName = getFileName();
        XStream xStream = new XStream(new DomDriver());
        xStream.setClassLoader(moduleLoader);
        this.setAliveOrganismsList(new ArrayList<>());
        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStream inputStream = fis;
            for (SerializePlugin serPlug:serializePlugins) {
                inputStream=serPlug.getInputStream(inputStream);
            }
            this.setAliveOrganismsList((ArrayList) xStream.fromXML(inputStream, this.getAliveOrganismsList()));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}



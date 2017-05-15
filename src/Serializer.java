import Pluginloader.ModuleLoader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import organisms.AliveOrganism;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Валерий on 26.04.2017.
 */
public class Serializer {

    private java.util.List<AliveOrganism> aliveOrganismsList = new ArrayList<>();
    private  ModuleLoader moduleLoader;

    public List<AliveOrganism> getAliveOrganismsList() {
        return aliveOrganismsList;
    }

    private void setAliveOrganismsList(List<AliveOrganism> aliveOrganismsList) {
        this.aliveOrganismsList = aliveOrganismsList;
    }

    public Serializer(java.util.List<AliveOrganism> aliveOrganismsList,ModuleLoader moduleLoader) {
        this.setAliveOrganismsList(aliveOrganismsList);
        this.moduleLoader=moduleLoader;

    }

    public void serialize() {
        String fileName;
        fileName = getFileName();
        XStream xStream = new XStream(new DomDriver());
        xStream.setClassLoader(moduleLoader);
        try {
            FileOutputStream fs = new FileOutputStream(fileName);
            xStream.toXML(this.getAliveOrganismsList(), fs);
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
            this.setAliveOrganismsList((ArrayList) xStream.fromXML(fis, this.getAliveOrganismsList()));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}



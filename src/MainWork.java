import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import organisms.AliveOrganism;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Валерий on 07.04.2017.
 */
public class MainWork {

    public void serialize(AliveOrganism aliveOrganism){
        String fileName;
        fileName=getFileName();

        XStream xStream = new XStream();
        try {
            FileOutputStream fs = new FileOutputStream(fileName);
            xStream.toXML(aliveOrganism, fs);
        } catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(null,
                    "Incorrect File Name",
                    "Please enter correct file name",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getFileName(){
        String fileName = "";
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Выберите файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            java.io.File file = new java.io.File(String.valueOf(fileopen.getSelectedFile()));
            fileName=file.getName();
        }
        return fileName;
    }

    public AliveOrganism deserialize(){
        String fileName;
        fileName=getFileName();

        AliveOrganism aliveOrganism = null;
        XStream xStream = new XStream(new DomDriver());
        try {
            FileInputStream fis = new FileInputStream(fileName);
            xStream.fromXML(fis, aliveOrganism);
        } catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(null,
                    "Incorrect File Name",
                    "Please enter correct file name",
                    JOptionPane.ERROR_MESSAGE);
        }
        return aliveOrganism;
    }
}

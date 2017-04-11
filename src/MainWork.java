import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import organisms.AliveOrganism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Валерий on 07.04.2017.
 */
public class MainWork {

    private  static CreatePanel createPanel;

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

    public static void initializeInterface(){
        JFrame jFrame = new JFrame("Основное окно");
        jFrame.setSize(700,700);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setBackground(Color.red);
        jFrame.setVisible(true);

        Box box = Box.createHorizontalBox();
        JButton amanita = new JButton("Amanita");
        JButton cat = new JButton("Cat");
        JButton chanterelle = new JButton("Chanterelle");
        JButton fish = new JButton("Fish");
        JButton moss = new JButton("Moss");
        JButton rose = new JButton("Rose");
        box.add(amanita);
        box.add(cat);
        box.add(chanterelle);
        box.add(fish);
        box.add(moss);
        box.add(rose);

        jFrame.add(box,BorderLayout.NORTH);
        jFrame.revalidate();
        jFrame.repaint();

        workWithButtons(jFrame,amanita,4,"x","y","z","y");

    }



    public static void workWithButtons(JFrame jFrame, JButton jButton, int count, String... strings){
        jButton.addActionListener((ActionEvent e) -> {
            if (createPanel !=null){
                jFrame.remove(createPanel);
            }
            createPanel = new CreatePanel(e1 -> {
               if (checkAllFields(createPanel)){
                   int fields[] = new int[count];
                   for (int i = 0; i < count; i++) {
                       fields[i] = createPanel.getTextFieldValue(i);
                   }
               }
            },strings);
            jFrame.add(createPanel);
            repainting(jFrame);
        });


    }

    public static boolean checkAllFields(CreatePanel createPanel) {
        if (createPanel.checkFields()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Some of fields is empty",
                    "Empty fields",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void repainting(JFrame jFrame) {
        jFrame.revalidate();
        jFrame.repaint();
    }
}

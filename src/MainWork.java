import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import factory.AliveOrganismCreator;
import factory.Factory;
import organisms.AliveOrganism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Валерий on 07.04.2017.
 */
public class MainWork {

    private  static CreatePanel createPanel;
    private   static AliveOrganismCreator aliveOrganismCreator;
    private  static Factory factory;

    private static Vector<String> vector;
    private static JList<String> list;

    private static java.util.List<AliveOrganism> aliveOrganismsList = new ArrayList<>();

    public static void serialize(AliveOrganism aliveOrganism){
        String fileName;
        fileName=getFileName();
        System.out.println(fileName);

        XStream xStream = new XStream(new DomDriver());
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

    public static String getFileName(){
        String fileName = "";
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Выберите файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            java.io.File file = new java.io.File(String.valueOf(fileopen.getSelectedFile()));
            fileName=file.getName();
        }
        return fileName;
    }

    public static AliveOrganism deserialize(){
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
        jFrame.setSize(700,300);
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

        repainting(jFrame);

        vector = new Vector<String>();
        list = new JList<String>(vector);
        //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jFrame.add(list,BorderLayout.SOUTH);



        factory = new Factory();

        workWithButtons(jFrame,amanita,4,"продолжительность жизни","дата рождения","отравлен?","длина юбки");
        workWithButtons(jFrame,cat,3,"продолжительность жизни","дата рождения","млекопитающее?");
        workWithButtons(jFrame,chanterelle,4,"продолжительность жизни","дата рождения","отравлен?","оттенок желтого");
        workWithButtons(jFrame,fish,3,"продолжительность жизни","дата рождения","млекопитающее?");
        workWithButtons(jFrame,moss,4,"продолжительность жизни","дата рождения","паразит?","хозяин");
        workWithButtons(jFrame,rose,4,"продолжительность жизни","дата рождения","паразит?","количество шипов");

    }



    public static void workWithButtons(JFrame jFrame, JButton jButton, int count, String... strings){
        jButton.addActionListener((ActionEvent e) -> {
            if (createPanel !=null){
                jFrame.remove(createPanel);
            }

            aliveOrganismCreator = factory.getFactoryCreator(jButton.getText());
            createPanel = new CreatePanel(e1 -> {
               if (checkAllFields(createPanel)) {
                   int fields[] = new int[count];
                   for (int i = 0; i < count; i++) {
                       fields[i] = createPanel.getTextFieldValue(i);
                   }
                   aliveOrganismsList.add(aliveOrganismCreator.CreateOrganism(fields));
                   vector.add(aliveOrganismsList.get(aliveOrganismsList.size()-1).toString());
                   System.out.println(vector.get(vector.size()-1));
                   list=null;
                   list = new JList<String>(vector);
                   jFrame.add(list,BorderLayout.SOUTH);
                   repainting(jFrame);
                   serialize(aliveOrganismsList.get(aliveOrganismsList.size()-1));
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

    public static void updateList() {

    }
}

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import factory.AliveOrganismCreator;
import factory.Factory;
import organisms.AliveOrganism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    private  static  JFrame jFrame;

    private static java.util.List<AliveOrganism> aliveOrganismsList = new ArrayList<>();

    public static void serialize(){
        String fileName;
        fileName=getFileName();
        System.out.println(fileName);

        XStream xStream = new XStream(new DomDriver());
        try {
            FileOutputStream fs = new FileOutputStream(fileName);
            for (int i=0;i<aliveOrganismsList.size();i++) {
                xStream.toXML(aliveOrganismsList.get(i), fs);
            }
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
            fileName=file.getAbsolutePath();
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
            System.out.println(aliveOrganism.getClass());
        } catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(null,
                    "Incorrect File Name",
                    "Please enter correct file name",
                    JOptionPane.ERROR_MESSAGE);
        }
        return aliveOrganism;
    }

    public static void initializeInterface(){
        jFrame = new JFrame("Основное окно");
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
        JButton serial = new JButton("Serialize");
        JButton deserial = new JButton("Deserialize");
        box.add(amanita);
        box.add(cat);
        box.add(chanterelle);
        box.add(fish);
        box.add(moss);
        box.add(rose);
        box.add(serial);
        box.add(deserial);

        serial.addActionListener( (ActionEvent e) -> {
            serialize();
        });
        deserial.addActionListener( (ActionEvent e) -> {
            deserialize();
        });

        jFrame.add(box,BorderLayout.NORTH);

        repainting();

        vector = new Vector<String>();
        list = new JList<String>(vector);

        selectionlist();

        jFrame.add(list,BorderLayout.SOUTH);



        factory = new Factory();

        String[] fields={"0","0","0","0","0"};

        workWithButtons(amanita,4,fields,"продолжительность жизни","дата рождения","отравлен?","длина юбки");
        workWithButtons(cat,3,fields,"продолжительность жизни","дата рождения","млекопитающее?");
        workWithButtons(chanterelle,4,fields,"продолжительность жизни","дата рождения","отравлен?","оттенок желтого");
        workWithButtons(fish,3,fields,"продолжительность жизни","дата рождения","млекопитающее?");
        workWithButtons(moss,4,fields,"продолжительность жизни","дата рождения","паразит?","хозяин");
        workWithButtons(rose,4,fields,"продолжительность жизни","дата рождения","паразит?","количество шипов");

    }



    public static void workWithButtons(JButton jButton, int count,String[] field, String... strings){
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
                   selectionlist();
                   jFrame.add(list,BorderLayout.SOUTH);
                   repainting();
               }
            },field,strings);
            jFrame.add(createPanel);
            repainting();
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

    public static void repainting() {
        jFrame.revalidate();
        jFrame.repaint();
    }

    public static void selectionlist(){
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = list.locationToIndex(e.getPoint());
                JButton jButton = new JButton(getClassNameOfItem(index));
                String [] fields=getFieldsFromList(index);
                workWithButtons(jButton,aliveOrganismsList.get(index).getCountOfFields(),fields,aliveOrganismsList.get(index).getTextFields());
                jButton.doClick();
                deleteBtnListener(index);
                repainting();
            }
        });
    }

    private static String[] getFieldsFromList(int index) {
        String[] fields=factory.getFactoryFields(getClassNameOfItem(index),aliveOrganismsList.get(index));
        return fields;
    }

    public static void deleteBtnListener(int index){
        JButton deletebtn = new JButton("Delete");
        jFrame.add(deletebtn,BorderLayout.LINE_END);
        deletebtn.addActionListener((ActionEvent e) -> {
                vector.remove(index);
                aliveOrganismsList.remove(index);
            repainting();
            });
    }

    public static String getClassNameOfItem(int index){
        String className;
        className=aliveOrganismsList.get(index).getClass().toString();
        int posDot=className.indexOf(".");
        className=className.substring(posDot+1,className.length());
        return className;
    }
}

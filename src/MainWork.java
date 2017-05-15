import Pluginloader.ModuleEngine;
import Pluginloader.ModuleLoader;
import Pluginloader.PluginInterface;
import factory.AliveOrganismCreator;
import factory.Factory;
import organisms.AliveOrganism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Created by Валерий on 07.04.2017.
 */
public class MainWork {

    private   CreatePanel createPanel;
    private   AliveOrganismCreator aliveOrganismCreator;
    private   Factory factory;

    private  Vector<String> vector;
    private  JList<String> list;

    private    JFrame jFrame;
    private  java.util.List<AliveOrganism> aliveOrganismsList = new ArrayList<>();

    public  void serialize(ModuleLoader moduleLoader){
        Serializer serializer = new Serializer(aliveOrganismsList,moduleLoader);
        serializer.serialize();
        serializer=null;
    }

    public  void deserialize(ModuleLoader moduleLoader){
        Serializer serializer = new Serializer(aliveOrganismsList,moduleLoader);
        serializer.deserialize();
        aliveOrganismsList=serializer.getAliveOrganismsList();
        serializer=null;
        vector = new Vector<String>();
        list = new JList<String>(vector);
        for (int i=0;i<aliveOrganismsList.size();i++){
            vector.add(aliveOrganismsList.get(i).toString());
        }
        reloadList();
    }

    public  void initializeInterface(){
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

        factory = new Factory();
        java.util.List<PluginInterface> pluginInterfaceList = new ArrayList();
        ModuleLoader loader = new ModuleLoader("plugins", ClassLoader.getSystemClassLoader());
       ModuleEngine moduleEngine = new ModuleEngine();
       pluginInterfaceList=moduleEngine.work(loader);
        String[] fields={"0","0","0","0","0"};
       workWithInterfaseList(pluginInterfaceList,box,fields);


        serial.addActionListener( (ActionEvent e) -> {
            serialize(loader);
        });
        deserial.addActionListener( (ActionEvent e) -> {
            deserialize(loader);
        });



        jFrame.add(box,BorderLayout.NORTH);

        repainting();

        vector = new Vector<String>();
        list = new JList<String>(vector);

        selectionlist();

        jFrame.add(list,BorderLayout.SOUTH);





        workWithButtons(amanita,4,fields,"продолжительность жизни","дата рождения","отравлен?","длина юбки");
        workWithButtons(cat,3,fields,"продолжительность жизни","дата рождения","млекопитающее?");
        workWithButtons(chanterelle,4,fields,"продолжительность жизни","дата рождения","отравлен?","оттенок желтого");
        workWithButtons(fish,3,fields,"продолжительность жизни","дата рождения","млекопитающее?");
        workWithButtons(moss,4,fields,"продолжительность жизни","дата рождения","паразит?","хозяин");
        workWithButtons(rose,4,fields,"продолжительность жизни","дата рождения","паразит?","количество шипов");
    }

    public void workWithInterfaseList(java.util.List<PluginInterface> pluginInterfaceList,Box box,String[] fields){
        for (PluginInterface pluginInterface: pluginInterfaceList) {
            factory.addNewAnimal(pluginInterface.getName(),pluginInterface.getCreator(),pluginInterface.getFields());
            JButton plgbtn = new JButton(pluginInterface.getName());
            workWithButtons(plgbtn,pluginInterface.getTextFields().length,fields,pluginInterface.getTextFields());
            box.add(plgbtn);
        }
    }


    public  void workWithButtons(JButton jButton, int count,String[] field, String... strings){
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
                   reloadList();
               }
            },field,strings);
            jFrame.add(createPanel);
            repainting();
        });
    }

    private  void reloadList() {
        list=null;
        list = new JList<String>(vector);
        selectionlist();
        jFrame.add(list,BorderLayout.SOUTH);
        repainting();
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

    public  void repainting() {
        jFrame.revalidate();
        jFrame.repaint();
    }

    public  void selectionlist(){
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

    private  String[] getFieldsFromList(int index) {
        String[] fields=factory.getFactoryFields(getClassNameOfItem(index),aliveOrganismsList.get(index));
        return fields;
    }

    public  void deleteBtnListener(int index){
        JButton deletebtn = new JButton("Delete");
        jFrame.add(deletebtn,BorderLayout.LINE_END);
        deletebtn.addActionListener((ActionEvent e) -> {
                vector.remove(index);
                aliveOrganismsList.remove(index);
            repainting();
            });
    }

    public  String getClassNameOfItem(int index){
        String className;
        className=aliveOrganismsList.get(index).getClass().toString();
        int posDot=className.indexOf(" ");
        className=className.substring(posDot+1,className.length());
        return className;
    }
}

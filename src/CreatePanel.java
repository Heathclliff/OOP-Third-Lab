import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Валерий on 12.04.2017.
 */
public class CreatePanel extends JPanel {
    KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {

            if (!Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        }

        ;
    };
    private JButton jButton;
    private List<JTextField> jTextFieldList = new ArrayList<>();


    public CreatePanel(ActionListener actionListener,String[] fields, String[] labels) {

        this.jButton = new JButton("Создать");
        jButton.addActionListener(actionListener);

        for (int i = 0; i < labels.length; i++) {

            jTextFieldList.add(getTextField(fields[i],labels[i]));
        }

        this.add(jButton);
    }


    public Integer getTextFieldValue(int pos) {

        return Integer.valueOf(jTextFieldList.get(pos).getText().toString());
    }


    private JTextField getTextField(String text,String label) {

        JTextField jTextField = new JTextField(String.valueOf(text),16);
        jTextField.addKeyListener(keyAdapter);

        JLabel jLabel = new JLabel(label);

        this.add(jLabel);
        this.add(jTextField);

        return jTextField;
    }


    public boolean checkFields() {

        boolean value = true;

        for (int i = 0; i < jTextFieldList.size(); i++) {

            value = (value && !(jTextFieldList.get(i).getText().isEmpty()));
        }

        return value;
    }
}

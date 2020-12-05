/*
 * Created by JFormDesigner on Wed Dec 02 16:27:34 CST 2020
 */

package test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import net.miginfocom.swing.*;

/**
 * @author Rodrigo Cesar Solano Martinez
 */
public class MenuDeposito extends JPanel {
    public MenuDeposito() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rodrigo Cesar Solano Martinez
        label1 = new JLabel();
        button12 = new JButton();
        textField1 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button15 = new JButton();
        button6 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button14 = new JButton();
        button7 = new JButton();
        button10 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button11 = new JButton();
        panel1 = new JPanel();

        //======== this ========
        setBackground(new Color(2, 85, 163));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
        javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax
        .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
        .awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
        .Color.red), getBorder())); addPropertyChangeListener(new java.beans.
        PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".
        equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/resources/banco.png")));
        add(label1, "cell 2 1");

        //---- button12 ----
        button12.setText("text");
        add(button12, "cell 16 1");
        add(textField1, "cell 2 3 10 1");

        //---- button3 ----
        button3.setText("text");
        add(button3, "cell 14 3");

        //---- button4 ----
        button4.setText("text");
        add(button4, "cell 15 3");

        //---- button5 ----
        button5.setText("text");
        add(button5, "cell 16 3");

        //---- button15 ----
        button15.setText("text");
        add(button15, "cell 11 4");

        //---- button6 ----
        button6.setText("text");
        add(button6, "cell 14 4");

        //---- button8 ----
        button8.setText("text");
        add(button8, "cell 15 4");

        //---- button9 ----
        button9.setText("text");
        add(button9, "cell 16 4");

        //---- button14 ----
        button14.setContentAreaFilled(false);
        button14.setBorderPainted(false);
        button14.setBorder(null);
        button14.setIcon(new ImageIcon(getClass().getResource("/resources/153-four.png")));
        add(button14, "cell 14 5");

        //---- button7 ----
        button7.setText("text");
        add(button7, "cell 15 5");

        //---- button10 ----
        button10.setText("text");
        add(button10, "cell 16 5");

        //---- button1 ----
        button1.setIcon(new ImageIcon(getClass().getResource("/resources/151-one.png")));
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setBorder(null);
        button1.setSelectedIcon(new ImageIcon(getClass().getResource("/resources/cheque.png")));
        add(button1, "cell 14 6");

        //---- button2 ----
        button2.setIcon(new ImageIcon(getClass().getResource("/resources/146-two.png")));
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        add(button2, "cell 15 6");

        //---- button11 ----
        button11.setIcon(new ImageIcon(getClass().getResource("/resources/147-three.png")));
        button11.setBorderPainted(false);
        button11.setContentAreaFilled(false);
        add(button11, "cell 16 6");

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));
        }
        add(panel1, "cell 0 9 18 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new MenuDeposito());
        frame.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rodrigo Cesar Solano Martinez
    private JLabel label1;
    private JButton button12;
    private JTextField textField1;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button15;
    private JButton button6;
    private JButton button8;
    private JButton button9;
    private JButton button14;
    private JButton button7;
    private JButton button10;
    private JButton button1;
    private JButton button2;
    private JButton button11;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

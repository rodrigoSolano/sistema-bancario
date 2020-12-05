// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuDeposito extends JFrame implements ActionListener {

    private JPanel menuDeposito;
    private JButton siete;
    private JButton ocho;
    private JButton cero;
    private JButton nueve;
    private JButton buttonExit;
    private JButton regresar;
    private JButton home;
    private JTextField textField1;
    private JButton enter;
    private JButton uno;
    private JButton dos;
    private JButton tres;
    private JButton cuatro;
    private JButton cinco;
    private JButton seis;
    UIClient uiClient;

    public menuDeposito(UIClient uiClient){
        super("none");
        this.uiClient = uiClient;
        setVisible(false);
        this.setContentPane(menuDeposito);
    }

    public Container getPanel() {
        return this.getContentPane();
    }

    private void createUIComponents() {
        siete.setBorder(null);
        ocho.setBorder(null);
        nueve.setBorder(null);
        cuatro.setBorder(null);
        cinco.setBorder(null);
        seis.setBorder(null);
        uno.setBorder(null);
        dos.setBorder(null);
        tres.setBorder(null);
        regresar.setBorder(null);
        home.setBorder(null);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        home.setActionCommand("home");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        switch (command){
            case "home":
                //uiClient.ocultarMenu();
                break;
        }

    }
}

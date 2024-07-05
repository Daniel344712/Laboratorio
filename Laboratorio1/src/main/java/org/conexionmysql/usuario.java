package org.conexionmysql;

import controller.UsuarioController;
import view.ConsoleView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class usuario {
    private JPanel panel1;
    private JTextField textUsuario;
    private JButton registrarUsuarioButton;
    private JLabel UsuarioLabel;
    private JLabel CorreoLabel;
    private JLabel ContrasennaLabel;
    private JTextField textContrasenna;
    private JTextField textCorreo;
    private JTextField textCedula;
    private JTextField textApellido;
    private JLabel ApellidoLabel;
    private JLabel CedulaLabel;
    private JLabel telefonoLabel;
    private JTextField textTelefono;
    ConsoleView consoleView = new ConsoleView();
    UsuarioController usuarioController = new UsuarioController(consoleView);
    public usuario() {
        registrarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUsuario();
            }
        });
    }

    private void registerUsuario() {
        String usuario = textUsuario.getText();
        String contrasenna = textContrasenna.getText();
        String correo = textCorreo.getText();
        String cedula = textCedula.getText();
        String apellido = textApellido.getText();
        String telefonoStr = textTelefono.getText().trim();

        int telefono;
        telefono = Integer.parseInt(telefonoStr);

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de texto de usuario está vacío");
            return;
        }else if (contrasenna.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de texto de contraseña está vacío");
            return;
        } else if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de texto de correo está vacío");
            return;
        }else if(cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null,"El campo de la cedula está vacío");
        }else if(apellido.isEmpty()){
            JOptionPane.showMessageDialog(null,"El campo del apellido está vacío");

        } else if(telefonoStr.isEmpty()){
            JOptionPane.showMessageDialog(null,"El campo del telefono está vacío");
        }
        usuarioController.agregarUsuario(apellido,cedula,usuario,correo,telefono,contrasenna);
        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Usuario");
        frame.setContentPane(new usuario().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
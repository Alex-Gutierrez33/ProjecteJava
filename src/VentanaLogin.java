import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame {

    JLabel txtUsuari;
    JTextField usuari;

    JLabel txtContrasenya;
    JPasswordField contrasenya;

    JComboBox<String> rolComboBox;

    JButton enviar;

    public VentanaLogin() {
        setTitle("Login Biblioteca");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
        setLocationRelativeTo(null);
 

        txtUsuari = new JLabel("Usuari: ");
        add(txtUsuari);

        usuari = new JTextField();
        add(usuari);

        txtContrasenya = new JLabel("Contrasenya: ");
        add(txtContrasenya);

        contrasenya = new JPasswordField();
        add(contrasenya);

       
        String[] roles = { "bibliotecari", "lector" };
        rolComboBox = new JComboBox<>(roles);

        add(new JLabel("Selecciona el rol del usuari:"));
        add(rolComboBox);

        enviar = new JButton("Envia");
        add(enviar);

        setVisible(true);

        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String rolSelecionat = (String) rolComboBox.getSelectedItem();
                String nomUsuari = usuari.getText();
                String passwordUsuari = "";


                char[] contrasenyaUsuari = contrasenya.getPassword();

                for (int i = 0; i < contrasenyaUsuari.length; i++) {
                    passwordUsuari = passwordUsuari + contrasenyaUsuari[i];
                }

                //Crearia el objeto usuari (nomUsuari, passwordUsuari, rolSelecionat)

                if (rolSelecionat.equals("lector")) {
                    //Llamaria a metodo validarCredenciales

                    //Llama a interfaz del lector si validarCredenciales me devuelve true, sino saldrá una alterta de error
                    VentanaLectores ventanaLector = new VentanaLectores();
                }else{

                    //Llamaria a metodo validarCredenciales


                    //Llama a interfaz del biblioteciario si validarCredenciales me devuelve true, sino saldrá una alterta de error
                    VentanaBibliotecarios ventanaBibliotecarios = new VentanaBibliotecarios();
                }
                System.out.println("El rol seleccionat es: " + rolSelecionat);
                System.out.println("Usuari: " + nomUsuari);
                System.out.println("Password: " + passwordUsuari);
            }
        });
    }
}
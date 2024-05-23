import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin extends JFrame {

    public static String nomUsuari;
    public static String cognomUsuari;


    JLabel txtUsuari;
    JTextField usuari;

    JLabel txtCognom;
    JTextField cognoms;



    JButton enviar;

    public VentanaLogin() {
        setTitle("Login Biblioteca");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);
 

        txtUsuari = new JLabel("Nom: ");
        add(txtUsuari);

        usuari = new JTextField();
        add(usuari);

        txtCognom = new JLabel("Cognom: ");
        add(txtCognom);

        cognoms = new JTextField();
        add(cognoms);


        enviar = new JButton("Envia");
        add(enviar);

        setVisible(true);

        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nomUsuari = usuari.getText();
                cognomUsuari = cognoms.getText();

                Usuaris usu = new Usuaris(nomUsuari, cognomUsuari);
                String[] resultado = usu.validarCredencials(nomUsuari, cognomUsuari);


               if (resultado[0].equals("valid") && resultado[1].equals("bibliotecari")) {
                    VentanaBibliotecarios visor = new VentanaBibliotecarios();
               }if (resultado[0].equals("valid") && resultado[1].equals("lector")) {
                    VentanaLectores visor = new VentanaLectores();
                
               } if (!resultado[0].equals("valid")) {
                    JOptionPane.showMessageDialog(VentanaLogin.this, "Error no s'ha trobat el usuari", "Informació", JOptionPane.INFORMATION_MESSAGE);
               }
               
            }
        });

    }
 
}
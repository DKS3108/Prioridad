import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana {
    private JPanel Principal;
    private JTextField txtnombre;
    private JComboBox cbotipo;
    private JSpinner spiprioridad;
    private JButton encolarButton;
    private JTextArea txtlistar;
    private JButton btnAtender;
    private Banco bbarrio= new Banco();

    public Ventana() {
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre =txtnombre.getText();
                String tipo=cbotipo.getSelectedItem().toString();
                int p=Integer.parseInt(spiprioridad.getValue().toString());
                Cliente c=new Cliente(nombre,tipo,p);
                bbarrio.encolar(c);
                listar();
            }
        });
        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Cliente c=bbarrio.desencolar();
                    listar();
                    JOptionPane.showMessageDialog(null,c.toString()+"Fue atendido");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public void listar(){
        List<Cliente> resultado=bbarrio.listarClientes();
        txtlistar.setText("");
        for (Cliente c:resultado){
            txtlistar.append(c.toString());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

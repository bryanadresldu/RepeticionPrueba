import javax.sound.sampled.Port;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class productosForm extends JFrame {

    private JPanel productosPanel;
    private JButton regresarButton;
    private JTextField codigo_cargar;
    private JTextField  nombre_cargar;
    private JTextField detalle_cargar;
    private JTextField  stock_cargar;

    public productosForm() {
        setTitle(" Productos");
        setContentPane(productosPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        for (Producto p : ListaProductos.getListaProductos()) {
            String codigo=p.getCodigo();
            String nombre=p.getNombre();
            String detalle=p.getDetalle();
            int stock=p.getStock();
            codigo_cargar.setText(codigo);
            nombre_cargar.setText(nombre);
            detalle_cargar.setText(detalle);
            stock_cargar.setText(String.valueOf(stock));
        }


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new menuForm();
                dispose();
            }
        });
    }


}

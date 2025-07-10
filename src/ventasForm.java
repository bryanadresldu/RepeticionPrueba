import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventasForm extends JFrame {

    private JPanel ventasPanel;
    private JTextField cantidad_textField;
    private JTextField codigoBuscar_textField;
    private JLabel producto_cargar;
    private JLabel precio_cargar;
    private JButton calcularButton;
    private JLabel subtotal_calcular;
    private JLabel totalPagar_calcular;
    private JButton regresarAlMenuButton;
    private JButton buscar_button;
    private Producto productoSeleccionado;

    public ventasForm() {
        setTitle(" Ventas");
        setContentPane(ventasPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        buscar_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoBuscado=codigoBuscar_textField.getText();
                productoSeleccionado=null;
                if (codigoBuscado.isEmpty())
                    JOptionPane.showMessageDialog(null,"Codigo vacio");
                else {
                    for (Producto p:ListaProductos.listaProductos){
                        if (ListaProductos.listaProductos!=null){
                            if (p.getCodigo().equals(codigoBuscado)){
                                productoSeleccionado=p;
                                producto_cargar.setText(p.getNombre());
                                precio_cargar.setText(String.valueOf(p.getPrecioUnitario()));
                            }else
                                JOptionPane.showMessageDialog(null,"Producto no encontrado");
                        }else
                            JOptionPane.showMessageDialog(null, "No hay productos registrados aun");
                    }

                }
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(productoSeleccionado!=null){
                    int cantidad=Integer.parseInt(cantidad_textField.getText());
                    double precio=Double.parseDouble(precio_cargar.getText());
                    int stock=productoSeleccionado.getStock();
                    if (cantidad>0 &&cantidad<=stock){
                        double subtotal=cantidad*precio;
                        subtotal_calcular.setText(String.valueOf(subtotal));
                        double totalPagar=subtotal*1.15;
                        totalPagar_calcular.setText(String.valueOf(totalPagar));
                        stock-=cantidad;
                        for (Producto p : ListaProductos.getListaProductos()) {
                            p.setStock(stock);
                        }

                    }else{
                        JOptionPane.showMessageDialog(null,"Stock insuficiente");}
                }else
                    JOptionPane.showMessageDialog(null,"Ingrese un codigo de producto valido");
            }
        });


        regresarAlMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new menuForm();
                dispose();

            }
        });

    }
}

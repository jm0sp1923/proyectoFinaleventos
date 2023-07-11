/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Container;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author jm0sp
 */
public class FormularioEditarRegistro extends JDialog {

    public JTable tabla;
    public DefaultTableModel modelo;
    public JLabel usuarios, total;
    public JComboBox<String> usuariosC;
    public JTextField codigoT, totalT;
    public JButton buscar, cancelar,modificar;

    public FormularioEditarRegistro(Frame e, boolean modal) {
        super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);

        usuarios = new JLabel("Usuarios");
        total = new JLabel("Total");

        String tipo[] = {"Placa", "Factura", "Todos", "Empleado"};
        usuariosC = new JComboBox<>(tipo);
        usuariosC.setSelectedItem(null);
        codigoT = new JTextField(10);
        codigoT.setEnabled(false);

        totalT = new JTextField(10);

        buscar = new JButton("Buscar");
        cancelar = new JButton("Cancelar");
        modificar = new JButton("Modificar");
        
        modelo = new DefaultTableModel();
        modelo.addColumn("Factura");
        modelo.addColumn("Vehiculo");
        modelo.addColumn("Placa");
        modelo.addColumn("Cliente");
        modelo.addColumn("H entrada");
        modelo.addColumn("H salida");
        modelo.addColumn("Horas");
        modelo.addColumn("Valor H");
        modelo.addColumn("Total");
        modelo.addColumn("Nombre empleado");
        modelo.addColumn("Modificar");

        tabla = new JTable(modelo) {
            
            public Class<?> getColumnClass(int column) {
                if (column == 10) {
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }

            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 10) {
                    return getDefaultRenderer(Boolean.class);
                }
                return super.getCellRenderer(row, column);
            }

            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        JScrollPane scroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        TableColumn columna_factura = tabla.getColumnModel().getColumn(0);
        columna_factura.setPreferredWidth(25);

        TableColumn columna_vehiculo = tabla.getColumnModel().getColumn(1);
        columna_vehiculo.setPreferredWidth(25);

        TableColumn columna_placa = tabla.getColumnModel().getColumn(2);
        columna_placa.setPreferredWidth(35);

        TableColumn columna_cliente = tabla.getColumnModel().getColumn(3);
        columna_cliente.setPreferredWidth(75);

        TableColumn columna_Hentrada = tabla.getColumnModel().getColumn(4);
        columna_Hentrada.setPreferredWidth(35);

        TableColumn columna_Hsalida = tabla.getColumnModel().getColumn(5);
        columna_Hsalida.setPreferredWidth(35);

        TableColumn columna_horas = tabla.getColumnModel().getColumn(6);
        columna_horas.setPreferredWidth(35);

        TableColumn columna_valorH = tabla.getColumnModel().getColumn(7);
        columna_valorH.setPreferredWidth(40);

        TableColumn columna_total = tabla.getColumnModel().getColumn(8);
        columna_total.setPreferredWidth(45);

        TableColumn columna_nombreEmpleado = tabla.getColumnModel().getColumn(9);
        columna_nombreEmpleado.setPreferredWidth(80);

        TableColumn columna_Modificar = tabla.getColumnModel().getColumn(10);
        columna_Modificar.setPreferredWidth(25);

        usuarios.setBounds(20, 15, 70, 40);
        usuariosC.setBounds(80, 25, 100, 22);
        codigoT.setBounds(195, 25, 150, 20);
        buscar.setBounds(355, 25, 90, 20);
        scroll.setBounds(10, 60, 780, 300);
         modificar.setBounds(150, 400, 180, 25);
        cancelar.setBounds(400, 400, 180, 25);
       
        
        c.add(usuarios);

        c.add(codigoT);
        c.add(usuariosC);
        c.add(buscar);
        c.add(modificar);
        c.add(cancelar);
        c.add(scroll);
    }

}

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
public class FormularioVisualizarEliminarUsuario extends JDialog {

    public JTable tabla;
    public DefaultTableModel modelo;
    public JLabel usuarios, codigo;
    public JComboBox<String> nivel;
    public JTextField codigoT;
    public JButton buscar, eliminar, cancelar;

    public FormularioVisualizarEliminarUsuario(Frame e, boolean modal) {
        super(e,modal); 
        Container c = getContentPane();
        c.setLayout(null);

        usuarios = new JLabel("Usuarios");
        codigo = new JLabel("Codigo");

        String niveles[] = {"Codigo", "Nivel 1", "Nivel 2", "Nivel 3"};
        nivel = new JComboBox<>(niveles);
        nivel.setSelectedItem(null);
        
        codigoT = new JTextField(10);
        codigoT.setEnabled(false);
        
        buscar = new JButton("Buscar");
        eliminar = new JButton("Eliminar seleccionados");
        cancelar = new JButton("Cancelar");

        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nivel");
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo");
        modelo.addColumn("Contrasena");
        modelo.addColumn("Eliminar");

        tabla = new JTable(modelo) {
            public Class<?> getColumnClass(int column) {
                if (column == 5) {
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }

            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 5) {
                    return getDefaultRenderer(Boolean.class); 
                }
                return super.getCellRenderer(row, column);
            }

            public boolean isCellEditable(int row, int column) {
                return column == 5; 
            }
        };
               
        
        JScrollPane scroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        TableColumn columna_codigo = tabla.getColumnModel().getColumn(0);
        columna_codigo.setPreferredWidth(25);
        
        TableColumn columna_nivel = tabla.getColumnModel().getColumn(1);
        columna_nivel.setPreferredWidth(25);
        
        TableColumn columna_nombre = tabla.getColumnModel().getColumn(2);
        columna_nombre.setPreferredWidth(90);
        
        TableColumn columna_correo = tabla.getColumnModel().getColumn(3);
        columna_correo.setPreferredWidth(90);
        
        TableColumn columna_contrasena = tabla.getColumnModel().getColumn(4);
        columna_contrasena.setPreferredWidth(55);
        
        TableColumn columna_eliminar = tabla.getColumnModel().getColumn(5);
        columna_eliminar.setPreferredWidth(30);
        
       
        
        usuarios.setBounds(20, 15, 70, 40);
        nivel.setBounds(80, 25, 80, 22);
        codigo.setBounds(190, 15, 70, 40);
        codigoT.setBounds(235, 25, 100, 20);
        buscar.setBounds(350, 25, 90, 20);
        scroll.setBounds(10, 60, 450, 300);
        eliminar.setBounds(40, 400, 180, 25);
        cancelar.setBounds(250, 400, 180, 25);
        
        
        c.add(usuarios);
        c.add(codigo);
        c.add(codigoT);
        c.add(nivel);
        c.add(buscar);
        c.add(eliminar);
        c.add(cancelar);
        c.add(scroll);

      
    }

}

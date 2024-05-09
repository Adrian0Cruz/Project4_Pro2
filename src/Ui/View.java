package Ui;
//@author Jesús Hernández
import javax.swing.JButton;
import javax.swing.JOptionPane;
import programacion2_pro4.*;
public class View extends javax.swing.JPanel {
    List L2;
    public View ( ) { initComponents(); }
    public JButton RjButton1 (  ) {
        return jButton1;
    }
    public JButton RGen_List (  ) {
        return Gen_List;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        Grado = new javax.swing.JComboBox<>();
        GetGen = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Get_Cod = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        But_Info = new javax.swing.JButton();
        Gen_List = new javax.swing.JButton();

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 204));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setText("Eliminar ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        Grado.setBackground(new java.awt.Color(204, 204, 204));
        Grado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Grado.setForeground(new java.awt.Color(0, 0, 0));
        Grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grado: ", "PreJardin", "Jardin" }));

        GetGen.setBackground(new java.awt.Color(204, 204, 204));
        GetGen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GetGen.setForeground(new java.awt.Color(0, 0, 0));
        GetGen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Genero: ", "Femenino", "Masculino" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Visualizar Datos");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Back Arrow.png"))); // NOI18N
        jButton1.setText("Back");

        jTable1.setBackground(new java.awt.Color(153, 153, 153));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grado", "Edad", "Identificación", "Nombre", "Genero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        Get_Cod.setBackground(new java.awt.Color(153, 153, 153));
        Get_Cod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Get_Cod.setForeground(new java.awt.Color(0, 0, 0));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Buscar Codigo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        But_Info.setBackground(new java.awt.Color(153, 153, 153));
        But_Info.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        But_Info.setForeground(new java.awt.Color(0, 0, 0));
        But_Info.setText("Informes");
        But_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_InfoActionPerformed(evt);
            }
        });

        Gen_List.setBackground(new java.awt.Color(153, 153, 153));
        Gen_List.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Gen_List.setForeground(new java.awt.Color(0, 0, 0));
        Gen_List.setText("Listado General");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Get_Cod))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GetGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(But_Info))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Gen_List)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(Get_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GetGen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(But_Info)
                        .addGap(26, 26, 26)
                        .addComponent(Gen_List))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ( Get_Cod.getText (  ).isBlank() ) {
            JOptionPane.showMessageDialog(this,
                    "No Has Puesto El Codigo A Buscar", "ERROR", JOptionPane.ERROR_MESSAGE);
            Get_Cod.grabFocus (  );
            return;
        }
        L2.ShowInfo ( Integer.parseInt ( Get_Cod.getText (  ) ) );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int X = Integer.parseInt ( jTable1.getValueAt ( jTable1.getSelectedRow (  ), 2).toString (  ) );
        L2.EliminatedCod ( X );
        L2.LLenarTabla ( jTable1 );
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void But_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_InfoActionPerformed
        if ( GetGen.getSelectedIndex (  ) == 0 ) {
            JOptionPane.showMessageDialog(this,
                    "No Has Seleccionado El Genero", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] opciones = {"CountChild", "Promedio", "Cancelar"};
        int Seleccion = JOptionPane.showOptionDialog(this, "Selecciona una opción:",
                "Seleccione Informe", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0] );
        switch ( Seleccion ) {
            case 0 ->{
                if ( Grado.getSelectedIndex (  ) == 0 ) {
                    JOptionPane.showMessageDialog(this,
                            "No Has Seleccionado El Grado", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                L2.CountChild ( Grado.getSelectedItem (  ).toString (  ),
                        GetGen.getSelectedItem (  ).toString (  ) );
                break;
            }
            case 1 ->{
                L2.Promedio( GetGen.getSelectedItem().toString() );
                break;
            }
            case 2 ->{
                JOptionPane.showMessageDialog(this ,
                        "Cancelado");
                break;
            }
        }
    }//GEN-LAST:event_But_InfoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_Info;
    private javax.swing.JButton Gen_List;
    private javax.swing.JComboBox<String> GetGen;
    private javax.swing.JTextField Get_Cod;
    private javax.swing.JComboBox<String> Grado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
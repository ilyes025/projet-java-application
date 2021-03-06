/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class UsersJFrame extends javax.swing.JFrame {
    Connection con;
    /**
     * Creates new form UsersJFrame
     */
    public UsersJFrame() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
             MenuJFrame m = new MenuJFrame(); // open the main menu 
             m.setVisible(true);
            try{
                con.close();
                dispose();
        }catch(Exception ex){System.out.println(ex.getMessage());}
        }
        });
        setResizable(false);
        setLocation(350,100);
        this.setTitle("Users");
        initComponents();
        table1.setDefaultRenderer(Object.class, new Render());
        JButton btn1 = new JButton();
        btn1.setName("m");
        btn1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Pictures\\java\\1486505375-edit-pen-change-option-pencil-write_81422.png"));
        JButton btn2 = new JButton();
        btn2.setName("r");
        btn2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Pictures\\java\\1491313931-cross_82985.png"));
        
      
        try{
            
            Connection cnx= DBConnect.openConnection();
            PreparedStatement ps=cnx.prepareStatement("SELECT * FROM users");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel tm=(DefaultTableModel)table1.getModel();
            
            tm.setRowCount(0);
            
            while(rs.next()){
                Object o[] = {rs.getInt("user_id"), rs.getString("username"), rs.getString("authorization"), btn1, btn2};
                tm.addRow(o);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USER_ID", "USERNAME", "AUTHORIZATION", "MODIFY", "REMOVE"
            }
        ));
        table1.setEnabled(false);
        table1.setRowHeight(40);
        table1.setSelectionBackground(new java.awt.Color(255, 102, 153));
        table1.setShowVerticalLines(false);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 610, 320));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/user_icon-icons.png"))); // NOI18N
        jLabel3.setText("USERS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 130, 50));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/sign-emergency-code-sos_61_icon-icons.com_57216.png"))); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 110, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/sign-add-icon_34367.png"))); // NOI18N
        jButton1.setText("Add User");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 40));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 210, 40));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\ProjetJAVA\\ProjetJAVA\\src\\projetjava\\iconfinder-search-4341327_120553.png")); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/4stretched-1366-768-468462.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new UserInfo().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        int column = table1.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/table1.getRowHeight();
        
        if(row<table1.getRowCount() && row>=0 && column < table1.getColumnCount() && column>=0){
            Object value=table1.getValueAt(row, column);
            if (value instanceof JButton){
                ((JButton)value).doClick();
                JButton bouton = (JButton)value;
                
                 if(bouton.getName().equals("m")){
                     int q = JOptionPane.showConfirmDialog(null, "Do you really want to modify this user account?","Modify",JOptionPane.YES_NO_OPTION);
                     if(q==0){
                     try{
                     String user =(table1.getModel().getValueAt(row,1)).toString();
                     int idUser = Integer.parseInt((table1.getModel().getValueAt(row,0)).toString());
                         dispose();
                         new UserInfo(user, idUser).setVisible(true);
                        
                     }catch(Exception e){
                         JOptionPane.showMessageDialog(null, e);
                     }
                     }
                 }
                 if(bouton.getName().equals("r")){
                     int p = JOptionPane.showConfirmDialog(null, "Do you really want to remove this user account?","Remove",JOptionPane.YES_NO_OPTION);
                     if(p==0){
                     try{
                     int row1=table1.getSelectedRow();
                     String x=(table1.getModel().getValueAt(row,0)).toString();
                     String sql;
                     sql="DELETE FROM users WHERE user_id = "+x;
                         PreparedStatement pst=null;
                         Connection cnx1= DBConnect.openConnection();
                         pst=cnx1.prepareStatement(sql);
                         pst.execute();
                         dispose();
                         new UsersJFrame().setVisible(true);
                        
                     }catch(Exception e){
                         JOptionPane.showMessageDialog(null, e);
                     }
                     }
                 }
            }
        }
    }//GEN-LAST:event_table1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
        new MenuJFrame().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try
        {
            table1.setDefaultRenderer(Object.class, new Render());
        JButton btn1 = new JButton();
        btn1.setName("m");
        btn1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Pictures\\java\\1486505375-edit-pen-change-option-pencil-write_81422.png"));
        JButton btn2 = new JButton();
        btn2.setName("r");
        btn2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Pictures\\java\\1491313931-cross_82985.png"));
            DefaultTableModel tm=(DefaultTableModel)table1.getModel();
            String search;
            search=jTextField1.getText();
            String req="SELECT * FROM users where user_id like '%"+search+"%' or username like '%"+search+"%' or authorization like '%"+search+"%';";  
            if(search=="") req="SELECT * FROM users";
            /*Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url,DB_user,password);*/
            Connection con= DBConnect.openConnection();
            Statement st=(Statement) con.createStatement();
            ResultSet rs=st.executeQuery(req);
            tm.setRowCount(0); // clear jtable
            while(rs.next())
            {
                Object obj[] = {rs.getInt("user_id"), rs.getString("username"), rs.getString("authorization"), btn1, btn2};
                tm.addRow(obj);
            }           
            st.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null, ex.toString(), "Failure", JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsersJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import projetjava.Evolution;
import projetjava.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetjava.DBConnect;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class Statistic extends javax.swing.JFrame {

    /**
     * Creates new form Statistic1
     */
    Connection con;
    public Statistic() {
        initComponents();
        this.setLocation(400, 50);
        this.show();
        this.setTitle("Statstic");
         String jTextFieldstr1="";
        String jTextFieldstr2="";
        String jTextFieldstr3="";
        String jTextFieldstr4="";
        String jTextFieldstr5="";
        String jTextFieldstr6="";
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
        
        
        
        try{
            
            Connection cnx= DBConnect.openConnection();
            PreparedStatement ps=cnx.prepareStatement("SELECT count(*)as article_nbr FROM javadatabase.articles;");
            ResultSet rs=ps.executeQuery();
            
            
            while(rs.next()){
                //System.out.print(rs.getString("donators_nbr"));
                jTextFieldstr1=rs.getString("article_nbr");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }

  
        try{
            
            Connection cnx= DBConnect.openConnection();
            PreparedStatement ps=cnx.prepareStatement("SELECT count(*) as donators_nbr FROM javadatabase.donators");
            ResultSet rs=ps.executeQuery();
            
            
            while(rs.next()){
                //System.out.print(rs.getString("donators_nbr"));
                jTextFieldstr2=rs.getString("donators_nbr");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        
        
        try{
            
            Connection cnx= DBConnect.openConnection();
            PreparedStatement ps=cnx.prepareStatement("SELECT count(*) as receivers_nbr FROM javadatabase.receivers;");
            ResultSet rs=ps.executeQuery();
            
            
            while(rs.next()){
                //System.out.print(rs.getString("donators_nbr"));
                jTextFieldstr3=rs.getString("receivers_nbr");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        
         try{
            
            Connection cnx= DBConnect.openConnection();
            PreparedStatement ps=cnx.prepareStatement("SELECT count(*) as artic_nbr  FROM javadatabase.articles\n" +
                                                        "WHERE articles.ARTICLE_STATUS = \"Accepted\" ;");
            ResultSet rs=ps.executeQuery();
            
            
            while(rs.next()){
                //System.out.print(rs.getString("donators_nbr"));
                jTextFieldstr4=rs.getString("artic_nbr");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
            
        }
          try{
            
            Connection cnx= DBConnect.openConnection();
            PreparedStatement ps=cnx.prepareStatement("SELECT count(*)as article_dir_nbr FROM javadatabase.articles\n" +
                                                          "WHERE RECEIVER_ID >= 1;");
            ResultSet rs=ps.executeQuery();
            
            
            while(rs.next()){
                //System.out.print(rs.getString("donators_nbr"));
                jTextFieldstr5=rs.getString("article_dir_nbr");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);  
        }
        
        
        try{
            
            Connection cnx= DBConnect.openConnection();
            PreparedStatement ps=cnx.prepareStatement("SELECT count(*) as sale_nbr FROM javadatabase.articles\n" +
                                                        "WHERE DEPSALE_ID >= 1;");
            ResultSet rs=ps.executeQuery();
            
            
            while(rs.next()){
                //System.out.print(rs.getString("donators_nbr"));
                jTextFieldstr6=rs.getString("sale_nbr");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);  
        }
        
        
        jTextField1.setText(jTextFieldstr1);
        jTextField2.setText(jTextFieldstr2);
        jTextField3.setText(jTextFieldstr3);
        jTextField4.setText(jTextFieldstr4);
        jTextField5.setText(jTextFieldstr5);
        jTextField6.setText(jTextFieldstr6);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("    STATISTICS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 23, 187, 44));

        jLabel2.setText("Number of received donations:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 201, -1));

        jLabel4.setText("Number of donors: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, 201, -1));

        jLabel5.setText("Number of receivers:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 241, 201, -1));

        jLabel6.setText("Number of accepted donations:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 306, -1, -1));

        jLabel13.setText("Number of direct donations:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 371, 201, -1));

        jLabel14.setText("Number of  sold donations:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 446, 201, -1));

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 108, -1, -1));

        jTextField2.setText("jTextField2");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 173, -1, -1));

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 238, -1, -1));

        jTextField4.setText("jTextField4");
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 303, -1, -1));

        jTextField5.setText("jTextField5");
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 365, -1, -1));

        jTextField6.setText("jTextField6");
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 440, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setText("Category");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 160, 69));

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setText("Accept / refuse ratio ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 160, 70));

        jButton3.setBackground(new java.awt.Color(255, 255, 102));
        jButton3.setText("Stock Evolution");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 160, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/graph-growth.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Category second = new Category();
        second.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Evolution second3 = new Evolution();
        second3.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Ratio second1 =new Ratio();
        second1.setVisible(true);
         dispose();

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
            java.util.logging.Logger.getLogger(Statistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistic().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}

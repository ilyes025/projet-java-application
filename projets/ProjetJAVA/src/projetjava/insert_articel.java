/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aymen
 */
public class insert_articel extends javax.swing.JFrame {

    /**
     * Creates new form insert_articel
     */
    private int DonatorID,MemberID,ReceptionQuantity,Cat_id,type_id;
    private String Ref,Description,Cat,Article_statuts="inProgress",Type,Date;
    boolean test=false;
    Connection con;
    Statement stm;
    public insert_articel() throws ClassNotFoundException, InstantiationException {
         initComponents();
         this.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
             Article m = new Article(); // open the main menu 
             m.setVisible(true);
            try{
                con.close();
                dispose();
        }catch(Exception ex){System.out.println(ex.getMessage());}
        }
        });
          this.setTitle("Insert Article");
         
            
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //con = DriverManager.getConnection("jdbc:mysql://localhost/javadatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "samir");     
            con = DBConnect.openConnection();
            stm=con.createStatement();
            System.out.println("connected");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(insert_articel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insert_articel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    int verif() throws SQLException{
        try{
               // MemberID=Integer.parseInt(jTextField4.getText());
                DonatorID=Integer.parseInt(jTextField3.getText());
                ReceptionQuantity=Integer.parseInt(jTextField6.getText());  
                return 1;
            }catch(NumberFormatException e){
                return 0;
                
            }
        
    }
    int getid() throws SQLException {
        int a=0;
                String req3="select max(TYPE_ID) AS max_id from javadatabase.type";
                PreparedStatement stat;
                stat=con.prepareStatement(req3);
                ResultSet res=stat.executeQuery();
                if (res.next()) {
                    a = res.getInt("max_id") + 1;
                    
                    }
                return a;
                
        
                 }
                  

        public void insert() throws SQLException{
          Ref=jTextField1.getText();
          Description=jTextField2.getText();
          Date=jTextField5.getText();         /*
          Date actuelle =new Date();
          DateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd");
          String date=dateformat.format(actuelle);
          String d=date;*/
          
            try{
                //MemberID=Integer.parseInt(jTextField4.getText());
                DonatorID=Integer.parseInt(jTextField3.getText());
                ReceptionQuantity=Integer.parseInt(jTextField6.getText());  
                
     
            }catch(NumberFormatException e){
            }
       
        Cat=jComboBox1.getSelectedItem().toString();
            if("Meubles".equals(Cat)){
                Cat_id=1;            
            }
            else if("Tables/chaises".equals(Cat)){
                Cat_id=2;            
            }
            else if("Electro-ménager".equals(Cat)){
                Cat_id=3;            
            }
            else if("Vaiseelle".equals(Cat)){
                Cat_id=4;            
            }
            else if("Literie".equals(Cat)){
                Cat_id=5;            
            }
            else if("Mobilier divers".equals(Cat)){
                Cat_id=6;            
            }
       Type=jTextField7.getText();

       
            int id=0;
            String req_id="SELECT max(ARTICLE_ID) FROM javadatabase.articles;";
            ResultSet rs_id=stm.executeQuery(req_id);
            String max;
            while(rs_id.next())
            {
                max=rs_id.getString("max(ARTICLE_ID)");
                if(max==null) id=0; // case of an empty database
                else
                id=Integer.valueOf(max);
            }
            id++;
       
       
            try{
                System.out.println(getid());
       String req0="INSERT INTO javadatabase.type (`TYPE_ID`,`NATURE`, `TYPE_QUANTITY`,`CATEGORY_ID`) \n" +
"	VALUES ('"+getid()+"','"+Type+"','"+ReceptionQuantity+"','"+Cat_id+"')";
       String req1="SET FOREIGN_KEY_CHECKS=0" ;      
        String req="INSERT INTO javadatabase.articles (`ARTICLE_ID`,`DESCRIPTION` , `DONATOR_ID`, `CATEGORY_ID`, `RECEIPT_QUANTITY`,`REFERENCE`,`ARTICLE_STATUS`,`RECEIPT_DATE`,`TYPE_ID`) \n" +
"	VALUES ('"+id+"','"+Description+"','"+DonatorID+"','"+Cat_id+"', '"+ReceptionQuantity+"','"+Ref+"','"+Article_statuts+"','"+Date+"','"+getid()+"')";
       
                stm.execute(req1);
                stm.execute(req0);
                stm.execute(req);
                jTextField1.setText("");jTextField2.setText("");jTextField3.setText("");jTextField5.setText("");jTextField6.setText("");jTextField7.setText("");
                jComboBox1.setSelectedItem("Not Selected");
            } catch (SQLException ex) {
                Logger.getLogger(Insert_article.class.getName()).log(Level.SEVERE, null, ex);
                
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */    

    /**
     * @param args the command line arguments
     */
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Reference");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, -1));

        jLabel3.setText("Description");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, -1));

        jLabel1.setText("Reception Date");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, -1));

        jLabel4.setText("Reception Quantity");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, -1));

        jLabel6.setText("Donator ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 80, 20));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 80, 25));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 258, 32));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 80, 25));

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 80, 25));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Selected", "Meubles", "Tables/chaises", "Electro-ménager", "Vaisselle", "Literies", "Mobilier divers" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jLabel7.setText("Category");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 80, -1));

        jButton1.setText("Add Article");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 80, 25));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 222, 102, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 2, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("yyyy-MM-dd");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 80, 20));

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 80, 25));

        jLabel9.setText("Type");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 40, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetjava/greenhands.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 480, 430));

        setSize(new java.awt.Dimension(444, 433));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
           
       
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
       if(("".equals(jTextField1.getText())) ||("".equals(jTextField3.getText()))||("".equals(jTextField2.getText()))||("".equals(jTextField5.getText()))||("".equals(jTextField6.getText()))||"Not Selected".equals(jComboBox1.getSelectedItem().toString())||("".equals(jTextField7.getText()))){
            JOptionPane.showMessageDialog(null,"Please fill all the fields and choose a category item !");   
        }
      
       else try {
            if(verif()==0) {
                JOptionPane.showMessageDialog(null,"DonatorID and Reception Quantity must be Integers");
                   
            }else {
                insert();
                JOptionPane.showMessageDialog(null,"Article added successfully");
            }
        } catch (SQLException ex) {
            Logger.getLogger(insert_articel.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            jTextField7.setEditable(true);
        }else{
        jTextField7.setEditable(false);
        }
    }//GEN-LAST:event_jTextField7KeyPressed

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
            java.util.logging.Logger.getLogger(insert_articel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insert_articel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insert_articel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insert_articel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new insert_articel().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(insert_articel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(insert_articel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}

package ATM;

import com.mycompany.atm_app.Main;
import javax.swing.JOptionPane;
import java.sql.*;
//import com.mycompany.bank_atm_emad.LOGIN;

public class LogIn extends javax.swing.JFrame {
    
    public static int CustID ;
    public LogIn() {
        initComponents();
        this.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        BankLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        atmButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        IDField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        signINBUT = new javax.swing.JButton();
        clrNBUTT1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 105, 139));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 100));

        BankLabel1.setIcon(new javax.swing.ImageIcon("ICONS/BANK.jpg"));

        jLabel5.setFont(new java.awt.Font("Kristen ITC", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Automated Teller Machine");

        atmButton1.setBackground(new java.awt.Color(0, 105, 139));
        atmButton1.setForeground(new java.awt.Color(255, 255, 255));
        atmButton1.setText("BMS");
        atmButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atmButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(BankLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(atmButton1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(BankLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(atmButton1)
                .addGap(18, 18, 18))
        );

        jPanel4.setBackground(new java.awt.Color(4, 72, 92));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PIN");

        IDField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        IDField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        passField.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        passField.setForeground(new java.awt.Color(0, 54, 76));
        passField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        signINBUT.setBackground(new java.awt.Color(4, 72, 92));
        signINBUT.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        signINBUT.setForeground(new java.awt.Color(255, 255, 255));
        signINBUT.setText("SIGN IN");
        signINBUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signINBUTActionPerformed(evt);
            }
        });

        clrNBUTT1.setBackground(new java.awt.Color(153, 0, 0));
        clrNBUTT1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        clrNBUTT1.setForeground(new java.awt.Color(255, 255, 255));
        clrNBUTT1.setText("Clear");
        clrNBUTT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrNBUTT1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(signINBUT)
                            .addGap(18, 18, 18)
                            .addComponent(clrNBUTT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(IDField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(77, 77, 77))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signINBUT)
                    .addComponent(clrNBUTT1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atmButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atmButton1ActionPerformed
        //com.mycompany.bank_atm_emad.LOGIN obj = new LOGIN();
        //this.setVisible(false);
    }//GEN-LAST:event_atmButton1ActionPerformed

    private void signINBUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signINBUTActionPerformed
        String ID = IDField.getText();
        CustID = Integer.parseInt(ID);
        String pass = passField.getText();
        if (ID.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your ID!");
        }
        else if (pass.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your Password!");
        }
        else {
            String sqlQuery = "SELECT * FROM Customer WHERE Customer_ID = '" + ID + "' AND Password = '" + pass + "'";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.0.2.15:2024;DatabaseName=BANKSYSDB", "omar", "hussein");
                PreparedStatement pst = conn.prepareStatement(sqlQuery);
                ResultSet rs = pst.executeQuery();
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid data!");
                } else {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                   com.mycompany.atm_app.Main obj = new Main();
                   this.setVisible(false);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }


    }//GEN-LAST:event_signINBUTActionPerformed

    private void clrNBUTT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrNBUTT1ActionPerformed
        // TODO add your handling code here:
        IDField.setText("");
        passField.setText("");
    }//GEN-LAST:event_clrNBUTT1ActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BankLabel1;
    private javax.swing.JTextField IDField;
    private javax.swing.JButton atmButton1;
    private javax.swing.JButton clrNBUTT1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField passField;
    private javax.swing.JButton signINBUT;
    // End of variables declaration//GEN-END:variables
}

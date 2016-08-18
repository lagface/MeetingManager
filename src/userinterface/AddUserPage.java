/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import meetingmanager.control.AdminControl;
import meetingmanager.entity.Employee;
import meetingmanager.entity.Room;

/**
 *
 * @author Matthew
 */
public class AddUserPage extends javax.swing.JPanel {

    /**
     * Creates new form AddUserPage
     */
    public AddUserPage() {
        initComponents();
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
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Add a User");

        jLabel2.setText("Name");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("UserID");

        jLabel4.setText("Password");

        jCheckBox1.setText("Admin?");

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(jTextField2)
                                .addComponent(jTextField1))
                            .addComponent(jButton1))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        System.out.println("Entering JTextFieldAction...");
        String loginId = jTextField1.getText();
        String username = jTextField2.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        boolean isAdmin = jCheckBox1.isSelected();
        
        if(loginId.length() < 1 || password.length() < 1) {
            JOptionPane.showMessageDialog(null, "Must enter and login and password");
        }
        
        Employee newEmp = new Employee()
                .setLoginId(loginId)
                .setName(username)
                .setPassword(password)
                .isAdmin(isAdmin);
        try {
            AdminControl.addEmployee(newEmp);
            JOptionPane.showMessageDialog(null, "User " + newEmp.getLoginId() + " added.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "That login id already exists!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                            
        System.out.println("Entering JTextFieldAction...");
        String loginId = jTextField1.getText();
        String username = jTextField2.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        boolean isAdmin = jCheckBox1.isSelected();
        
        if(loginId.length() < 1 || password.length() < 1) {
            JOptionPane.showMessageDialog(null, "Must enter and login and password");
        }
        
        Employee newEmp = new Employee()
                .setLoginId(loginId)
                .setName(username)
                .setPassword(password)
                .isAdmin(isAdmin);
        try {
            AdminControl.addEmployee(newEmp);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "That login id already exists!");
            e.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(null, "User " + newEmp.getLoginId() + " added.");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

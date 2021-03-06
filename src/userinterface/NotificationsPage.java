/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import meetingmanager.control.EmployeeControl;
import meetingmanager.control.MeetingControl;
import meetingmanager.entity.Employee;
import meetingmanager.entity.Notification;
import meetingmanager.entity.Meeting;
import meetingmanager.entity.Room;
import meetingmanager.exception.InviteeNotFoundException;
import static meetingmanager.userinterface.UIUtils.*;

/**
 *
 * @author Matthew
 */
public class NotificationsPage extends javax.swing.JPanel{
    private Employee emp;
    private Map<Integer, Meeting> invitationRowMap;
    private Map<Meeting, Boolean> invitations;
    private List<Notification> notifications;
    private Map<Integer, Notification> notificationRowMap;
    public String DATABASE_ERROR_MESSAGE = "Something went terribly wrong with the database. Whoops.";
    private EmployeePage parent;
    /**
     * Creates new form NotificationsPage
     */
    public NotificationsPage(Employee employee, EmployeePage parent) {
        initComponents();
        this.emp = employee;
        clearTable(jTable1);
        clearTable(jTable2);
        loadNotifications();
        loadInvites();
        this.parent = parent;
    }

    private void loadNotifications() {
        try {
            notifications = EmployeeControl.getNotifications(emp);
            notificationRowMap = new HashMap<>();
            
            int rowNumber = 0;
            for(int i = 0; i < notifications.size(); i++) {
                Object[] row = vectorizeNotification(notifications.get(i));
                addRow(jTable2, row);
                notificationRowMap.put(rowNumber, notifications.get(i));
                rowNumber++;
            }
        } catch (SQLException e) {
            showMessage(DATABASE_ERROR_MESSAGE);
        }
    }
    
    private void removeNotification(int row) {
        int oldSize = notificationRowMap.size();
        Notification notification = notificationRowMap.remove(row);
        notifications.remove(notification);
        deleteRow(jTable2, row);
        
        for(int i = row + 1; i < oldSize; i++) {
            Notification next = notificationRowMap.remove(i);
            notificationRowMap.put(i - 1, next);
        }
    }
    
    private Object[] vectorizeNotification(Notification notification) {
        return new Object[] { notification.getMessage() };
    }
    
    private void loadInvites(){
        try{
            int rowNumber = 0;
            invitations = EmployeeControl.getInvitedMeetings(emp);
            invitationRowMap = new HashMap<>();
            
            for(Meeting meeting: invitations.keySet()){
                Employee owner = meeting.getOwner();
                Room room = meeting.getLocation();
                Object[] row = vectorizeInvites(owner, room, meeting);
                invitationRowMap.put(rowNumber, meeting);
                addRow(jTable1, row);
                rowNumber++;
            }
            
        } catch (SQLException e){
            showMessage(DATABASE_ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private Object[] vectorizeInvites(Employee e, Room r, Meeting m){
        return new Object[] { "Invited by " + e.getName() + " at room: " + r.getLocation(), e.getName(), m.getStartTime(), m.getEndTime() };
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title", "Owner", "Start Time", "End time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("Notifications");

        jLabel2.setText("Updates");

        jLabel3.setText("Please Respond");

        jButton1.setText("Accept");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Decline");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Dismiss");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jButton1)
                        .addGap(144, 144, 144)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)))
                .addComponent(jButton3)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton3)))
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ACCEPT INVITATION
        if(jTable1.getSelectedRow() < 0)
            return;
        
        try {
            int row = jTable1.getSelectedRow();
            Meeting meeting = invitationRowMap.get(row);
            MeetingControl.acceptInvitation(meeting, emp);
            removeInvitation(row);
            showMessage("Thank you! You are now attending " + meeting.getTitle());
            parent.refreshSchedule();
        } catch (SQLException e) {
            showMessage("Database error while trying to accept invitation.");
            e.printStackTrace();
        } catch (InviteeNotFoundException e) {
            showMessage("Apparently you weren't actually invited to this meeting. Whoops!");
            e.printStackTrace();
        }
    }                                        

    private void removeInvitation(int row) {
        deleteRow(jTable1, row);
        int oldSize = invitationRowMap.size();
        Meeting meeting = invitationRowMap.remove(row);
        invitations.remove(meeting);
        
        for(int i = row + 1; i < oldSize; i++) {
            Meeting next = invitationRowMap.remove(i);
            invitationRowMap.put(i - 1, next);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // DECLINE INVITATION
        if(jTable1.getSelectedRow() < 0)
            return;
        
        int row = jTable1.getSelectedRow();
        try {
            Meeting meeting = invitationRowMap.get(row);
            MeetingControl.declineInvitation(meeting, emp);
            removeInvitation(row);
            showMessage("Meeting invitation declined.");
        } catch (SQLException e) {
            showMessage("Database error while trying to decline invitation.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // REMOVE NOTIFICATION
        int[] selectedRows = jTable2.getSelectedRows();
        
        try {

            for(int i = 0; i < selectedRows.length; i++) {
                Notification notification = notificationRowMap.get(selectedRows[i]);
                EmployeeControl.deleteNotification(notification);
                removeNotification(selectedRows[i]);
            }
        } catch (SQLException e) {
            showMessage("Database error while deleting notifications.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

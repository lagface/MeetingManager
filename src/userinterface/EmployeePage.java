/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import meetingmanager.control.EmployeeControl;
import meetingmanager.control.MeetingControl;
import meetingmanager.entity.Employee;
import meetingmanager.entity.Meeting;
import meetingmanager.entity.TimeSlot;
import static meetingmanager.userinterface.UIUtils.*;
/**
 *
 * @author Matthew
 */
public class EmployeePage extends javax.swing.JPanel {
    
    /**
     * Creates new form EmployeePage
     */
    private Employee emp;
    private SortedSet<Meeting> meetings;
    private Map<Integer, Meeting> rowMap;
    
    public int TITLE = 0;
    public int START = 1;
    public int END = 2;
    public String DATABASE_ERROR_MESSAGE = "Something went terribly wrong with the database. Whoops.";
    
    public EmployeePage(Employee employee) {
        initComponents();
        clearTable(jTable1);
        clearTable(jTable3);
        this.emp = employee;
        loadSchedule();
        loadMeetings();
        showMeetings();
        jLabel5.setText("Welcome, " + emp.getName() );
    }
    
    public void refreshMeetings() {
        clearMeetings();
        loadMeetings();
        showMeetings();
    }
    
    private void clearMeetings() {
        clearTable(jTable1);
    }
    
    private void loadMeetings() {
        try {
            meetings = MeetingControl.getOwnedMeetings(emp);
        } catch (SQLException e) {
            showMessage("Database error while loading meetings.");
        }
    }
    
    private void showMeetings() {
        rowMap = new HashMap<Integer, Meeting>();
        int row = 0;
 
        for(Meeting meeting : meetings) {
            addRow(jTable1, vectorizeMeeting(meeting));
            rowMap.put(row, meeting);
            row++;
        }
    }
    
    private static Object[] vectorizeMeeting(Meeting meeting) {
        return new Object[] {meeting.getTitle(), meeting.getStartTime(), meeting.getLocation().getLocation()};
    }
    
    private void loadSchedule() {
        try {
            List<TimeSlot> schedule = EmployeeControl.getEmployeeSchedule(emp);
            
            for(int i = 0; i < schedule.size(); i++) {
                Object[] row = vectorizeSchedule(schedule.get(i));
                addRow(jTable3, row);
            }
        } catch (SQLException e) {
            showMessage(DATABASE_ERROR_MESSAGE);
        }
    }
    
    public void refreshSchedule() {
        clearTable(jTable3);
        loadSchedule();
    }
    
    public void addEvent(TimeSlot event) {
            addRow(jTable3, vectorizeSchedule(event));
    }

    private Object[] vectorizeSchedule(TimeSlot schedule) {
        return new Object[] { schedule.getTitle(),schedule.getStartTime(),schedule.getEndTime() };
    }
    
/*
    public EmployeePage(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Employee Page");

        jLabel2.setText("Meetings");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "Time", "Location"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "Start", "End"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setText("Notifications");

        jLabel4.setText("Schedule");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Logout");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton11.setText("Update info");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Check new notifications");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(190, 190, 190)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton5)
                            .addComponent(jButton7)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton11)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jButton12)))
                    .addComponent(jLabel2))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFrame newFrame = new JFrame("Create a Meeting");
        newFrame.add(new AddMeetingPage(emp).setParent(this));
        newFrame.pack();
        newFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JFrame newFrame = new JFrame("Add to Schedule");
        newFrame.add(new AddSchedulePage(emp, this));
        newFrame.pack();
        newFrame.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(EmployeePage.this);
        topFrame.add(new Login());
        EmployeePage.this.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // UPDATE USER INFORMATION PAGE
        JFrame newFrame = new JFrame("User info");
        newFrame.add(new UpdateUserPage(emp));
        newFrame.pack();
        newFrame.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // DELETE FROM SCHEDULE
        try {
            if (jTable3.getSelectedRow() < 0)
                return;
            
            int row = jTable3.getSelectedRow();
            
            String title = (String) jTable3.getValueAt(row, TITLE);
            Date start = (Date) jTable3.getValueAt(row, START);
            Date end = (Date) jTable3.getValueAt(row, END);
            
            TimeSlot toRemove = new TimeSlot().setTitle(title);
            toRemove.setStartTime(start);
            toRemove.setEndTime(end);
            
            EmployeeControl.removeEvent(emp, toRemove);
            deleteRow(jTable3, row);
            
            showMessage("Event deleted.");

        } catch (SQLException e) {
            showMessage("Something went horribly wrong with the database");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // OPEN UPDATE SCHEDULE WINDOW
              
            if (jTable3.getSelectedRow() < 0)
                return;
            
            int row = jTable3.getSelectedRow();
            
            String title = (String) jTable3.getValueAt(row, TITLE);
            Date start = (Date) jTable3.getValueAt(row, START);
            Date end = (Date) jTable3.getValueAt(row, END);
            
            TimeSlot toEdit = new TimeSlot().setTitle(title);
            toEdit.setStartTime(start);
            toEdit.setEndTime(end);
            
            
            JFrame newFrame = new JFrame("Update Schedule");
            newFrame.add(new UpdateEmployeeSched(emp, this, toEdit, row, jTable3));
            newFrame.pack();
            newFrame.setVisible(true);
                 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // OPENS POPUP FOR NOTIFICATIONS
        JFrame newFrame = new JFrame("Notifications");
            newFrame.add(new NotificationsPage(emp, this));
            newFrame.pack();
            newFrame.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // UPDATE MEETING BUTTON
        if(jTable1.getSelectedRow() < 0)
            return;
        JFrame newFrame = new JFrame("Update Meeting");
            newFrame.add(new UpdateMeetingPage(rowMap.get(jTable1.getSelectedRow())));
            newFrame.pack();
            newFrame.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // DELETE MEETING
        if (jTable1.getSelectedRow() < 0)
            return; 
        
        int row = jTable1.getSelectedRow();
        
        if(warn("Are you sure you want to delete this meeting?")) {
            try {
                Meeting meetingToDelete = rowMap.get(row);
                MeetingControl.deleteMeeting(meetingToDelete);
                refreshSchedule();
                refreshMeetings();
                showMessage("Meeting Deleted.");
            } catch (SQLException e) {
                showMessage("Database issue while trying to delete meeting.");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}

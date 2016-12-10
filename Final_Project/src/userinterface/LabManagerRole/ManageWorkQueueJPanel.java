/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabManagerRole;

import Business.EcoSystem;
import Business.Enterprise.CompostingCenterEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Composting;
import Business.Organization.Lab;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CompostManagerWorkRequest;
import Business.WorkQueue.InventoryWorkRequest;
import Business.WorkQueue.LabManagerWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;
import userinterface.CompostManagerRole.CompostManagerWorkAreaJPanel;

/**
 *
 * @author Aadesh Randeria
 */
public class ManageWorkQueueJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageWorkQueueJPanel
     */
    private JPanel userProcessContainer;
    private Lab organization;
    private Enterprise enterprise;
    private UserAccount account;
    private Network network;
    ManageWorkQueueJPanel(JPanel userProcessContainer, UserAccount account, Lab organization, Enterprise enterprise, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.account = account;
        this.network=network;
        populateRequestTable();
    }
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblManageWorkQueue.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            int quantity = ((LabManagerWorkRequest) request).getQuantity();
            row[3] = quantity;
            
            String result = ((LabManagerWorkRequest) request).getTestResult();
            row[4] = result == null ? "Waiting" : result;
            
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblManageWorkQueue = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();
        btnComposting = new javax.swing.JButton();

        tblManageWorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Receiver", "Status", "Quantity", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblManageWorkQueue);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnRequest.setText("Request Test");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnComposting.setText("Send for Composting");
        btnComposting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompostingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(btnProcess)
                        .addGap(18, 18, 18)
                        .addComponent(btnRequest)
                        .addGap(18, 18, 18)
                        .addComponent(btnComposting)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnProcess)
                    .addComponent(btnRequest)
                    .addComponent(btnComposting))
                .addContainerGap(343, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblManageWorkQueue.getSelectedRow();       
        
        if (selectedRow >= 0) {
            LabManagerWorkRequest request = (LabManagerWorkRequest) tblManageWorkQueue.getValueAt(selectedRow, 0);
            request.setStatus("Processing");

            RequestTestJPanel rtjp = new RequestTestJPanel(userProcessContainer, organization, request, account, network);
            userProcessContainer.add("RequestTestJPanel", rtjp);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        } else {
            JOptionPane.showMessageDialog(null, "Please select a message to request."); 
            return;
        }
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnCompostingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompostingActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblManageWorkQueue.getSelectedRow();       
        
        if (selectedRow >= 0) {
            LabManagerWorkRequest request = (LabManagerWorkRequest) tblManageWorkQueue.getValueAt(selectedRow, 0);
            request.setStatus("Processing");
            //CompostManagerWorkRequest compostRequest = new CompostManagerWorkRequest(); 
            request.setMessage(request.getMessage());
            request.setReceiver(request.getReceiver());
            request.setQuantity(request.getQuantity());
            request.setStatus("Sent");
            request.setTestResult("Waiting");
            Enterprise en= null;
            for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof CompostingCenterEnterprise){
                    en=e;
                    Organization org=null;
                    for(Organization o : en.getOrganizationDirectory().getOrganizationList()){
                        if(o instanceof Composting){
                            org=o;
                            break;
                            
                        }
                    }
                    if(org!=null){
                        org.getWorkQueue().getWorkRequestList().add(request);
                        account.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Request Sent to Composting Manager");

        } else {
            JOptionPane.showMessageDialog(null, "Please select a message to send for composting."); 
            return;
        }
    }//GEN-LAST:event_btnCompostingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnComposting;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRequest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblManageWorkQueue;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InventoryManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Inventory;
import Business.Organization.MainOffice;
import Business.Organization.RecordList;
import Business.Organization.Records;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodWorkRequest;
import Business.WorkQueue.InventoryWorkRequest;
import Business.WorkQueue.MainOfficeWorkRequest;
import Business.WorkQueue.StoreWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class InventoryManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form InventoryManagerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Inventory organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    private EcoSystem business;
    public InventoryManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Inventory organization, Enterprise enterprise,Network network, EcoSystem business) {
        initComponents();
        this.business=business;
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.network=network;
        txtStock.setText(Integer.toString(organization.getStock()));
        txtGiveAway.setText(Integer.toString(organization.getGiveAway()));
        if(organization.getStock()<20){
            btnGiveAway.setEnabled(false);
        }
        populateRequestTable();
    }
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblInventory.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            int quantity = ((FoodWorkRequest) request).getQuantity();
            row[3] = quantity;
            String location = ((FoodWorkRequest) request).getLocation();
            row[4] = location;
            String result = ((FoodWorkRequest) request).getTestResult();
            row[5] = result == null ? "Waiting" : result;
            
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
        tblInventory = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnRequestWork = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnGiveAway = new javax.swing.JButton();
        btnDailySub = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtGiveAway = new javax.swing.JTextField();

        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Receiver", "Status", "Quantity", "Location", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInventory);
        if (tblInventory.getColumnModel().getColumnCount() > 0) {
            tblInventory.getColumnModel().getColumn(0).setResizable(false);
            tblInventory.getColumnModel().getColumn(1).setResizable(false);
            tblInventory.getColumnModel().getColumn(2).setResizable(false);
            tblInventory.getColumnModel().getColumn(3).setResizable(false);
            tblInventory.getColumnModel().getColumn(4).setResizable(false);
            tblInventory.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setText("Refresh");

        btnRequestWork.setText("Request Work");
        btnRequestWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestWorkActionPerformed(evt);
            }
        });

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jLabel1.setText("Stock:");

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        btnGiveAway.setText("Give Away");
        btnGiveAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiveAwayActionPerformed(evt);
            }
        });

        btnDailySub.setText("Daily Submission");
        btnDailySub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDailySubActionPerformed(evt);
            }
        });

        jLabel2.setText("Give Away:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGiveAway)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDailySub))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnProcess)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGiveAway, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addComponent(btnRequestWork))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtGiveAway, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRequestWork)
                    .addComponent(btnProcess))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiveAway)
                    .addComponent(btnDailySub))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblInventory.getSelectedRow();

        if (selectedRow >= 0) {
            FoodWorkRequest request = (FoodWorkRequest) tblInventory.getValueAt(selectedRow, 0);

            request.setStatus("Processing");

            ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, network, request);
            userProcessContainer.add("processWorkRequestIJPanel", processWorkRequestJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        } else {
            JOptionPane.showMessageDialog(null, "Please select a request message to process.");
            return;
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void btnRequestWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestWorkActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestWorkJPanel", new RequestWorkJPanel(userProcessContainer, userAccount,organization, enterprise, network));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestWorkActionPerformed

    private void btnDailySubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDailySubActionPerformed
        // TODO add your handling code here:
        int finalStock=organization.getFinalStock();
        int giveAwaycount= organization.getGiveAway();
        Records records=new Records();
        records.setFoodDonated(finalStock);
        records.setFoodGiven(giveAwaycount);
        records.setRequestDate(business.getCurrentDate());
//        RecordList list=new RecordList();
//        list.addRecords(records);
//        organization.setRecordList(list);
        organization.getRecordList().addRecords(records);
        JOptionPane.showMessageDialog(null, "Daily Records Submitted Successfully");
        
        
        
    }//GEN-LAST:event_btnDailySubActionPerformed
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    private void btnGiveAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiveAwayActionPerformed
        // TODO add your handling code here:
        int stock=organization.getStock();
        int giveAway=randInt(1,stock-20);
        int count= stock-giveAway;
        if(count<0){
            JOptionPane.showMessageDialog(null, "Not enough stock available for give away");
        }
        else{
        int existingGiveAway=organization.getGiveAway();
        int total=giveAway+existingGiveAway;
        organization.setGiveAway(total);
        int totalStock=stock-giveAway;
        organization.setStock(totalStock);
        txtStock.setText(String.valueOf(totalStock));
        txtGiveAway.setText(String.valueOf(total));
        JOptionPane.showMessageDialog(null, "Food Successfully donated to NGOs and Old-Aged Homes");
        }
    }//GEN-LAST:event_btnGiveAwayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDailySub;
    private javax.swing.JButton btnGiveAway;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnRequestWork;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventory;
    private javax.swing.JTextField txtGiveAway;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}

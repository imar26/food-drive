/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StoreManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.TransportAgencyEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.RecordList;
import Business.Organization.Records;
import Business.Organization.Store;
import Business.Organization.Transport;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodWorkRequest;
import Business.WorkQueue.StoreWorkRequest;
import Business.WorkQueue.TransportWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static userinterface.InventoryManagerRole.InventoryManagerWorkAreaJPanel.randInt;

/**
 *
 * @author Apurva Sawant
 */
public class StoreWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Store organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private Network network;

    /**
     * Creates new form StoreWorkAreaJPanel
     */

    public StoreWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Store organization, Enterprise enterprise, EcoSystem business, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        this.network = network;
        txtStock.setText(Integer.toString(organization.getStock()));
        txtGiveAway.setText(Integer.toString(organization.getGiveAway()));
        if (Integer.parseInt(txtStock.getText()) < 5) {
            btnRequestFood.setEnabled(true);
        }
        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblStore.getModel();

        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            int quantity = ((FoodWorkRequest) request).getQuantity();
            row[3] = quantity;

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
        tblStore = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnRequestFood = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtGiveAway = new javax.swing.JTextField();
        btnGiveAway = new javax.swing.JButton();
        btnDailySub = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(173, 255, 255));

        tblStore.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        tblStore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Receiver", "Status", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStore);

        btnRefresh.setBackground(new java.awt.Color(255, 51, 0));
        btnRefresh.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnRequestFood.setBackground(new java.awt.Color(255, 51, 0));
        btnRequestFood.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        btnRequestFood.setText("Request Food");
        btnRequestFood.setEnabled(false);
        btnRequestFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestFoodActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 51, 0));
        btnAdd.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        btnAdd.setText("Add Food");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel1.setText("Current Stock:");

        txtStock.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N

        btnSend.setBackground(new java.awt.Color(255, 51, 0));
        btnSend.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        btnSend.setText("Send Food");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel2.setText("Give Away:");

        txtGiveAway.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N

        btnGiveAway.setBackground(new java.awt.Color(255, 51, 0));
        btnGiveAway.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        btnGiveAway.setText("Give Away");
        btnGiveAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiveAwayActionPerformed(evt);
            }
        });

        btnDailySub.setBackground(new java.awt.Color(255, 51, 0));
        btnDailySub.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        btnDailySub.setText("Daily Submission");
        btnDailySub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDailySubActionPerformed(evt);
            }
        });

        txtQuantity.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel3.setText("Quantity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiveAway, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGiveAway, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRequestFood)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDailySub)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(jLabel1)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtGiveAway, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiveAway)
                    .addComponent(btnRequestFood)
                    .addComponent(btnAdd)
                    .addComponent(btnDailySub))
                .addContainerGap(221, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnRequestFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestFoodActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestFoodJPanel", new RequestFoodJPanel(userProcessContainer, userAccount, organization, enterprise, business, network));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestFoodActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblStore.getSelectedRow();

        if (selectedRow >= 0) {
            FoodWorkRequest request = (FoodWorkRequest) tblStore.getValueAt(selectedRow, 0);

            if (request.getMessage().equalsIgnoreCase("Food given at store")) {
                request.setStatus("Added");
                int stock = organization.getStock();
                int finalStock = organization.getFinalStock();
                int quantity = ((FoodWorkRequest) request).getQuantity();
                int total = stock + quantity;
                int finalTotal = finalStock + quantity;
                organization.setFinalStock(finalTotal);
                organization.setStock(total);
                txtStock.setText(Integer.toString(total));
                JOptionPane.showMessageDialog(null, "Stock Updated Successfully.");
                organization.getWorkQueue().getWorkRequestList().remove(request);
                populateRequestTable();

            } else {
                JOptionPane.showMessageDialog(null, "Please select a valid request to process.");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a request message to process.");
            return;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed

        int selectedRow = tblStore.getSelectedRow();

        if (selectedRow >= 0) {
            //         StoreWorkRequest request = (StoreWorkRequest) tblStore.getValueAt(selectedRow, 0);
            FoodWorkRequest request = (FoodWorkRequest) tblStore.getValueAt(selectedRow, 0);
//           for(WorkRequest request1: organization.getWorkQueue().getWorkRequestList())
//           {
//               System.out.println("req:"+request.getId());
//               System.out.println("req1:"+request1.getId()+" "+request1.getClass());
//               
//               if(request1.getId()==request.getId())
//               {
//                   
//                request1.setStatus("Food Sent");
//                //organization.getWorkQueue().getWorkRequestList().remove(request1);
//                
//               }
//           
//           }

            if (request.getMessage().equalsIgnoreCase("Request for food")) {
                if (request.getStatus().equalsIgnoreCase("Request Sent") || request.getStatus().equalsIgnoreCase("Food Request Partially Completed")) {
                    if (!txtQuantity.getText().isEmpty()) {
                        if ((organization.getStock() - Integer.parseInt(txtQuantity.getText())) > 10) {
                            //request.setStatus("Food Sent for delivery");
                            //   request.setResult("Yes");
                            Organization senderorg = request.getSenderOrganization();
                            int stock = organization.getStock();
                            int quantity = Integer.parseInt(txtQuantity.getText());
                            int total = stock - quantity;
                            int requestQuantity = request.getQuantity();
                            organization.setStock(total);
                            request.setQuantity(requestQuantity - quantity);
                            if (quantity < requestQuantity) {
                                request.setStatus("Food Request Partially Completed");
                            } else {
                                request.setStatus("Food Sent for delivery");
                            }
                            txtStock.setText(Integer.toString(total));
                            JOptionPane.showMessageDialog(null, "Food request accepted");
                            populateRequestTable();
                            FoodWorkRequest trasnportRequest = new FoodWorkRequest();
                            trasnportRequest.setQuantity(quantity);
                            trasnportRequest.setLocation(organization.getLocation());
                            trasnportRequest.setSenderOrganization(senderorg);
                            trasnportRequest.setStatus("Sent to Transport");
                            trasnportRequest.setMessage("Ready for pickup");
                            Enterprise en = null;
                            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                                System.out.println("Enterprise" + enterprise.getName());
                                if (enterprise instanceof TransportAgencyEnterprise) {
                                    System.out.println("Yes");
                                    en = enterprise;
                                    Organization org = null;
                                    for (Organization organization : en.getOrganizationDirectory().getOrganizationList()) {

                                        if (organization instanceof Transport) {
                                            //  System.out.println("Yes Organization");
                                            org = organization;
                                            break;
                                        }
                                    }
                                    if (org != null) {
                                        //  System.out.println("Org"+org.getName());
                                        //  System.out.println("User Account"+userAccount.getUsername());
                                        org.getWorkQueue().getWorkRequestList().add(trasnportRequest);
                                        //  System.out.println("Orga"+org.getWorkQueue().getWorkRequestList());
                                        userAccount.getWorkQueue().getWorkRequestList().add(trasnportRequest);
                                    }
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Stock is below the threshold. Cannot process the request.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter quantity to send food");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Request already processed by another store.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid action. You cannot send food for this request.");
            }
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnGiveAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiveAwayActionPerformed
        // TODO add your handling code here:
        int stock = organization.getStock();
        int giveAway = randInt(1, 3);
        int count = stock - giveAway;
        if (count < 0) {
            JOptionPane.showMessageDialog(null, "Not enough stock available for give away");
        } else {
            int existingGiveAway = organization.getGiveAway();
            int total = giveAway + existingGiveAway;
            organization.setGiveAway(total);
            int totalStock = stock - giveAway;
            organization.setStock(totalStock);
            txtStock.setText(String.valueOf(totalStock));
            txtGiveAway.setText(String.valueOf(total));
            JOptionPane.showMessageDialog(null, "Food Successfully donated");
        }
    }//GEN-LAST:event_btnGiveAwayActionPerformed

    private void btnDailySubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDailySubActionPerformed
        // TODO add your handling code here:
        //int ans = JOptionPane.showConfirmDialog(null, "Really want to add?", "Warning", JOptionPane.YES_NO_OPTION);
        //if (ans == 0) {
            int finalStock = organization.getFinalStock();
            int giveAwaycount = organization.getGiveAway();
            Records records = new Records();
            records.setFoodDonated(finalStock);
            records.setFoodGiven(giveAwaycount);
            records.setRequestDate(business.getCurrentDate());
            System.out.println("current date" + business.getCurrentDate());
            //RecordList list=new RecordList();
            organization.getRecordList().addRecords(records);
            //  list.addRecords(records);
            //  organization.setRecordList(list);
            organization.setFinalStock(0);
            organization.setGiveAway(0);
            organization.setStock(0);
            txtGiveAway.setText(String.valueOf(organization.getGiveAway()));
            txtStock.setText(String.valueOf(organization.getStock()));
            JOptionPane.showMessageDialog(null, "Daily Records Submitted Successfully");
        //}
    }//GEN-LAST:event_btnDailySubActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDailySub;
    private javax.swing.JButton btnGiveAway;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRequestFood;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStore;
    private javax.swing.JTextField txtGiveAway;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}

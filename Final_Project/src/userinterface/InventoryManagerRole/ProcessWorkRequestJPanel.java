/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InventoryManagerRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.MainCenterEnterprise;
import Business.Network.Network;
import Business.Organization.Inventory;
import Business.Organization.Organization;
import Business.Organization.Store;
import Business.Organization.StoreChain;
import Business.WorkQueue.FoodWorkRequest;
import Business.WorkQueue.StoreWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class ProcessWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    
    private JPanel userProcessContainer;
    private FoodWorkRequest request;
    private Network network;
    public ProcessWorkRequestJPanel(JPanel userProcessContainer,Network network, FoodWorkRequest request) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.request=request;
        this.network=network;
        
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
        txtResult = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 12)); // NOI18N
        jLabel1.setText("Result:");

        txtResult.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N

        btnBack.setBackground(new java.awt.Color(255, 51, 0));
        btnBack.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(255, 51, 0));
        btnSubmit.setFont(new java.awt.Font("Lucida Calligraphy", 0, 12)); // NOI18N
        btnSubmit.setText("Submit Result");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSubmit)))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSubmit))
                .addContainerGap(399, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        request.setTestResult(txtResult.getText());
        request.setStatus("Completed");
        for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()) {
            if(e instanceof MainCenterEnterprise) {
                for(Organization o: e.getOrganizationDirectory().getOrganizationList()) {
                    for (Store store : ((StoreChain) o).getStoreChain()) {
                             if(store.equals(request.getSenderOrganization()))
                             {
                                 System.out.println("in store"+request.getSenderOrganization());
                               Organization org=request.getSenderOrganization();
                            int quantity = request.getQuantity();
                             int old_qty = ((Store)org).getStock();
                             System.out.println("old qty: "+old_qty);
                             ((Store)org).setStock(old_qty+quantity);
                             JOptionPane.showMessageDialog(null, "Request Completed Successfully");
                             }
                         }
                }
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        InventoryManagerWorkAreaJPanel imwjp = (InventoryManagerWorkAreaJPanel) component;
        imwjp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.TransportManagerRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.TransportAgencyEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Transport;
import Business.Role.DriverRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DriverWorkRequest;
import Business.WorkQueue.MainOfficeWorkRequest;
import Business.WorkQueue.TransportWorkRequest;
import javax.swing.JPanel;

/**
 *
 * @author Aadesh Randeria
 */
public class RequestTestJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private Transport organization;
    private TransportWorkRequest request;
    private UserAccount userAccount;
    private EcoSystem business;
    /**
     * Creates new form RequestTestJPanel
     */
    public RequestTestJPanel(JPanel userProcessContainer, Transport organization, TransportWorkRequest request, UserAccount userAccount, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.request = request;
        this.userAccount = userAccount;
        this.business = business;
        
        populateDriverComboBox();
        
        int quantity = request.getQuantity();
        txtQuantity.setText(Integer.toString(quantity));        
        String location = request.getLocation();
        txtLocation.setText(location);
    }
    
    public void populateDriverComboBox() {
        comboBoxDriver.removeAllItems();
        for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList()) {
            if(ua.getRole() instanceof DriverRole) {
                comboBoxDriver.addItem(ua);
            }
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

        jLabel1 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxDriver = new javax.swing.JComboBox();
        btnRequest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();

        jLabel1.setText("Message:");

        jLabel2.setText("Select Driver:");

        comboBoxDriver.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRequest.setText("Request Test");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnBack.setText("Back");

        jLabel3.setText("Quantity:");

        jLabel4.setText("Location:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMessage)
                            .addComponent(comboBoxDriver, 0, 309, Short.MAX_VALUE)
                            .addComponent(txtQuantity)
                            .addComponent(txtLocation)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRequest)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnRequest))
                .addContainerGap(283, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        DriverWorkRequest request=new DriverWorkRequest();
        request.setSender(userAccount);
        request.setMessage(txtMessage.getText());
        request.setQuantity(Integer.valueOf(txtQuantity.getText()));
        request.setLocation(txtLocation.getText());
        request.setStatus("Sent");
        
        for(Network network : business.getNetworkList()){
            System.out.println("Network"+ network.getName());
            Enterprise en=null;
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                System.out.println("Enterprise"+ enterprise.getName());
                 if(enterprise instanceof TransportAgencyEnterprise){
                     System.out.println("Yes");
                    en = enterprise;
                    Organization org = null;
                    for (Organization organization : en.getOrganizationDirectory().getOrganizationList()){
                        
                        if (organization instanceof Transport){
                            System.out.println("Yes Organization");
                            org = organization;
                            break;
                        }
                    }
                    if (org!=null){
                        System.out.println("Org"+org.getName());
                        System.out.println("User Account"+userAccount.getUsername());
                        org.getWorkQueue().getWorkRequestList().add(request);
                        System.out.println("Orga"+org.getWorkQueue().getWorkRequestList());
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                    }
                    else{
                        //send it to a stall specified
                    }
                }
            }   
        }
    }//GEN-LAST:event_btnRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequest;
    private javax.swing.JComboBox comboBoxDriver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
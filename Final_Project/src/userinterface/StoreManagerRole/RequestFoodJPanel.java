/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StoreManagerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MainCenterEnterprise;
import Business.Organization.Organization;
import Business.Organization.Store;
import Business.Organization.StoreChain;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class RequestFoodJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private Store organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    /**
     * Creates new form RequestFoodJPanel
     */
    public RequestFoodJPanel(JPanel userProcessContainer, UserAccount account, Store organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business=business;
        populateTable();
    }
    public LinkedHashMap sortHashMapByValuesD(HashMap passedMap) {
   List mapKeys = new ArrayList(passedMap.keySet());
   List mapValues = new ArrayList(passedMap.values());
   Collections.sort(mapValues);
   Collections.sort(mapKeys);

   LinkedHashMap sortedMap = new LinkedHashMap();

   Iterator valueIt = mapValues.iterator();
   while (valueIt.hasNext()) {
       Object val = valueIt.next();
       Iterator keyIt = mapKeys.iterator();

       while (keyIt.hasNext()) {
           Object key = keyIt.next();
           String comp1 = passedMap.get(key).toString();
           String comp2 = val.toString();

           if (comp1.equals(comp2)){
               passedMap.remove(key);
               mapKeys.remove(key);
               sortedMap.put((String)key, (Double)val);
               break;
           }

       }

   }
   return sortedMap;
}
    public void populateTable(){
        HashMap<String, Double> map = new HashMap<String, Double>();
        if(enterprise instanceof MainCenterEnterprise){
            StoreChain org1=null;
            for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
                if(org instanceof StoreChain)
                org1=(StoreChain)org;
                for(Store s : org1.getStoreChain()){
                    int x1 = organization.getLatitude();
                    int y1 = organization.getLongitude();
                    int x2 = s.getLatitude();
                    int y2 = s.getLongitude();
                    double distance= 0;
                    int x3 = (x1-x2)*(x1-x2);
                    int y3 = (y1-y2)*(y1-y2);
                    distance = Math.sqrt(x3+y3);
                    
                    map.put(s.getName(), distance);
                }
            }
        }
        LinkedHashMap lmap=new LinkedHashMap();
        lmap=sortHashMapByValuesD(map);
        Iterator iterator = lmap.keySet().iterator();
        DefaultTableModel model = (DefaultTableModel) tblStores.getModel();
        
        model.setRowCount(0);
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = lmap.get(key).toString();
            Object[] row = new Object[2];
            row[0] = key;
            row[1] = value;
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStoreWorkQueue = new javax.swing.JTable();
        btnRequestMO = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setText("Nearby Stores:");

        tblStores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Distance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStores);

        jLabel2.setText("Quantity: ");

        jButton1.setText("Request");

        tblStoreWorkQueue.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblStoreWorkQueue);
        if (tblStoreWorkQueue.getColumnModel().getColumnCount() > 0) {
            tblStoreWorkQueue.getColumnModel().getColumn(0).setResizable(false);
            tblStoreWorkQueue.getColumnModel().getColumn(1).setResizable(false);
            tblStoreWorkQueue.getColumnModel().getColumn(2).setResizable(false);
            tblStoreWorkQueue.getColumnModel().getColumn(3).setResizable(false);
            tblStoreWorkQueue.getColumnModel().getColumn(4).setResizable(false);
        }

        btnRequestMO.setText("Request Main Office");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(154, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRequestMO)
                .addGap(314, 314, 314))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(btnRequestMO)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRequestMO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblStoreWorkQueue;
    private javax.swing.JTable tblStores;
    // End of variables declaration//GEN-END:variables
}

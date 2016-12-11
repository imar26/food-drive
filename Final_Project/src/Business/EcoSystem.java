/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Enterprise.MainCenterEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Store;
import Business.Organization.StoreChain;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
//import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author HP
 */
public class EcoSystem extends Organization {
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private Date currentDate;
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public static EcoSystem getInstance(){
        if(business==null){
            business= new EcoSystem();
        }
        return business;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList();
    }
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }

    public int getDonation(int month){
        int totalDonation=0;
        for(Network network: networkList){
             totalDonation+=network.donationByNetwork(month);
          }
        return totalDonation;
    }
    
    public int getDonation(String city){
        int totalDonation=0;
        for(Network network: networkList){
            if(network.getName().equalsIgnoreCase(city))
             totalDonation+=network.donationByNetwork();
          }
        return totalDonation;
    }
    
    public HashMap<String, Integer> giveAcrossStores(String city){
        HashMap<String, Integer> hmap=null;
        
         for(Network network: networkList){
            if(network.getName().equalsIgnoreCase(city)){
//              for(Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()){
//                 if(enterprise instanceof MainCenterEnterprise)
//                     for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
//                        if(org instanceof StoreChain){
//                          for(Store store:((StoreChain) org).getStoreChain()){
//                            store.
                hmap=network.giveAwayByNetwork();

              }
         }
         return hmap;
      }
                 
    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
//    public boolean checkIfUserNameIsUnique(String userName){
//        if(! this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
//            return false;
//        }
//        for(Network network: networkList){
//            
//        }
//        return true;
//    }
    
}

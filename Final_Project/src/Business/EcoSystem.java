/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
//import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class EcoSystem extends Organization {
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;

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

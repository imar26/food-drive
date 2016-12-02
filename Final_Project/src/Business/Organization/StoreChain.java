/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Apurva Sawant
 */
public class StoreChain extends Organization{

    private ArrayList<Store> storeChain;
    public StoreChain() {
        super(Organization.Type.StoreChain.getValue());
        storeChain= new ArrayList();
    }

    public ArrayList<Store> getStoreChain() {
        return storeChain;
    }

    public void setStoreChain(ArrayList<Store> storeChain) {
        this.storeChain = storeChain;
    }

    
    public void addStore(Store store){
        storeChain.add(store);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

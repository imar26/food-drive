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

    private ArrayList<Store> store;
    public StoreChain() {
        super(Organization.Type.StoreChain.getValue());
        store= new ArrayList<>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

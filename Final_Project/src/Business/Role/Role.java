/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        Donor("Donor"),
        LabManager("Lab Manager"),
        LabAssistant("Lab Assistant"),
        CompostManager("Compost Manager"),
        TransportManager("Transport Manager"),
        Driver("Driver"),
        Doctor("Doctor");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, Business business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}
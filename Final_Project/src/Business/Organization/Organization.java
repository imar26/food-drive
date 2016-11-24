/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Aadesh Randeria
 */
public abstract class Organization {
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    //private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    
}

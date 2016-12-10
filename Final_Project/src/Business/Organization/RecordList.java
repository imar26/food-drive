/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class RecordList {
    private ArrayList<Records> recordList;
    
    public RecordList(){
        recordList = new ArrayList<Records>();
    }

    public ArrayList<Records> getRecordList() {
        return recordList;
    }

    public void setRecordList(ArrayList<Records> recordList) {
        this.recordList = recordList;
    }
    public void addRecords(Records record){
        
        recordList.add(record);
        
    }
    
}

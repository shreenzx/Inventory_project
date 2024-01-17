/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connectionmanager.ConnectionManager;
import java.sql.*;
import model.Delete;

/**
 *
 * @author shree
 */
public class DeleteDAO {
    public void delete(Delete d) throws SQLException, ClassNotFoundException{
        ConnectionManager conm = new ConnectionManager();
	Connection con = conm.establishConnection();
	int prodID=d.getProdID();	
	Statement st = con.createStatement();
	String query = "delete from product where prodID = "+prodID;
        PreparedStatement ps = con.prepareStatement(query);
        ps.execute(query);
        
        ps.executeUpdate();
        
	conm.closeConnection();
        
    }
    
}

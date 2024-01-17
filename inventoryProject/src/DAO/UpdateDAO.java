/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import connectionmanager.ConnectionManager;
import model.Update;
public class UpdateDAO {
    public void update(Update u) throws ClassNotFoundException, SQLException{
        int prodID=u.getProdID();
	int quan=u.getQuan();
        ConnectionManager conm = new ConnectionManager();
	Connection con = conm.establishConnection();
       
        String query = "update product set quan = "+quan+" where prodID = "+prodID;
        PreparedStatement ps = con.prepareStatement(query);
        
        ps.execute(query);
        
        ps.executeUpdate();
        
	conm.closeConnection();
    }
    
}

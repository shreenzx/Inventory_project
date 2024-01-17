/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import connectionmanager.ConnectionManager;
import model.Login;

public class LoginDAO {
    public boolean loginValidation(Login l) throws ClassNotFoundException, SQLException
	{
		String username = l.getUsername();
		String password = l.getPass();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from login");
		while(rs.next())
		{
			if(username.equals(rs.getString("username")) && password.equals(rs.getString("pass")))
			{
				conm.closeConnection();
				return true;
			}
		}
		conm.closeConnection();
		return false;
	}
}



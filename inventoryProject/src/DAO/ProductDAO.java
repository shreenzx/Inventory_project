/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import connectionmanager.ConnectionManager;
import model.Product;
public class ProductDAO {
    public void addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		int prodID=p.getProdID();
		String prodName=p.getProdName();
		int minSellQuan=p.getMinSellQuan();
		int price=p.getPrice();
		int quan=p.getQuan();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		String query = "insert into product values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,prodID);
		ps.setString(2, prodName);
		ps.setInt(3,minSellQuan);
		ps.setInt(4,price);
		ps.setInt(5,quan);
		
		ps.executeUpdate();
		
		conm.closeConnection();
	}
    public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from product");
		while(rs.next())
		{
			System.out.println(rs.getInt("prodID")+" | "+rs.getString("prodName")+" | "+rs.getInt("minSellQuan")+" | "+rs.getInt("price")+" | "+rs.getInt("quan"));
		}
	}
    
    


}

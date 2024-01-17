/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DeleteDAO;
import java.sql.SQLException;
import java.util.Scanner;
import model.Product;
import model.Login;
import model.Update;
import model.Delete;
import DAO.LoginDAO;
import DAO.ProductDAO;
import DAO.UpdateDAO;
public class Main {
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        Scanner sc = new Scanner(System.in);
        Login l = new Login();
	LoginDAO ldao = new LoginDAO();
        Product p = new Product();
        Update u = new Update();
        Delete d = new Delete();
        DeleteDAO pdad = new DeleteDAO();
	ProductDAO pdao = new ProductDAO();
        UpdateDAO pdau = new UpdateDAO();
        int n;
        do
        {
        System.out.println("1. Admin\n" +"2. Agent\n" +"3. Exit\n" +"****************************************************\n" +"Enter your choice");
        n = sc.nextInt();
        switch(n){
            case 1: System.out.println("Admin Login"+"\nEnter Unsername");
                    String user = sc.next();
                    System.out.println("Enter Password");
                    String pass = sc.next();
                    l.setUsername(user);
		    l.setPass(pass);

                    if(ldao.loginValidation(l)){
                        System.out.println("Admin Login Success!"+"\n****************************************************");
                        int a;
                        do{
                        System.out.println("1. Add Product\n" +"2. Display Product\n" +"3. Update Product\n"+"4. Delete Product\n"+"5. Logout\n" +"****************************************************\n" +"Enter your option");
                        a = sc.nextInt();
                        switch(a){
                            case 1: System.out.println("Add Product\n" +"Enter the productId");
                                    int product = sc.nextInt();
                                    System.out.println("Enter the productName");
                                    sc.nextLine();
                                    String name = sc.nextLine();
                                    System.out.println("Enter the minimum sell quantity");
                                    int min_quantity = sc.nextInt();
                                    System.out.println("Enter the price");
                                    int price = sc.nextInt();
                                    System.out.println("Enter the quantity");
                                    int quantity = sc.nextInt();
                                    p.setProdID(product);
				    p.setProdName(name);
				    p.setMinSellQuan(min_quantity);
				    p.setPrice(price);
				    p.setQuan(quantity);
				    pdao.addProduct(p);
                                    System.out.println("Product added successfully\n" +"****************************************************");
                                    break;
                            case 2: System.out.println("Product details are below:");
                                    pdao.display();
                                    break;
                            case 3: System.out.println("Enter the product id ");
                                    int product1 = sc.nextInt();
                                    System.out.println("Details to be updated");
                                    System.out.println("Enter the Current Stock quantity ");
                                    int quantity1 = sc.nextInt();
                                    u.setProdID(product1);
                                    u.setQuan(quantity1);
                                    pdau.update(u);
                                    System.out.println("Updated Successfully\n" +"****************************************************");
                                    break;
                            case 4: System.out.println("Enter the product id to be deleted: ");
                                    int product2 = sc.nextInt();
                                    d.setProdID(product2);
                                    pdad.delete(d);
                                    System.out.println("Product successfully deleted\n" +"****************************************************");
                                    break;
                            case 5: System.out.println("Logout");break;
                                    
                                    
                        }
                        }while(a!=5);
                        
                    }
                    else{
                        System.out.println("Invalid username/Password");
                    }
                    break;
            case 2: System.out.println("Agent Login\n" +"Enter your username");
                    String name = sc.next();
                    System.out.println("Enter the password");
                    String pass1 = sc.next();
                    if(name.equals("Admin") && pass1.equals("Admin@123")){
                        System.out.println("Admin Login Success!"+"\n****************************************************");
                    }
                    int b;
                    do{
                        System.out.println("1. Display Product\n" +"2. Logout\n" +"****************************************************\n" +"Enter your option");
                        b = sc.nextInt();
                        switch(b){
                            case 1: System.out.println("Display product");
                                    pdao.display();
                                    break;
                            case 2: System.out.println("Logout"); break;
                        }
                    }while(b!=2);
                    break;
            case 3: System.out.println("Exit");break;
        }
        }while(n!=3);
    }
}

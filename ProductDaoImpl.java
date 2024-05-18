package product.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import oracle.jdbc.util.Login;
import product.db.DBconnection;
import product.model.Register;
import product.model.Product;

public class ProductDaoImpl implements ProductDao {
DBconnection proddao=new DBconnection();
	
	@Override
	public int createRecord(List<Register> lst) {
		// TODO Auto-generated method stub
		
		Register regobj=lst.get(0);
		int i=0;
		Connection con=null;
		try {
			con=proddao.getDbConnection();
			PreparedStatement pstate=con.prepareStatement("insert into Registration values(?,?,?,?,?)");
			pstate.setInt(1,regobj.getRegNo());
			pstate.setString(2,regobj.getCustName());
			pstate.setString(3,regobj.getUserName());
			pstate.setString(4,regobj.getPassword());
			pstate.setFloat(5,regobj.getAccbal());
			i = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}

	
	
	public List<Register> list() {
		int i=0;
		Connection conn=null;
		List<Register>lst=new LinkedList<Register>();
		try {
			conn=DBconnection.getDbConnection();
			String str = "select * from registration";
			
			Statement state=conn.createStatement();
			ResultSet result=state.executeQuery(str);
			
			while(result.next())
			{
				Register reg=new Register(result.getInt(1),result.getString(2), result.getString(3), result.getString(4), result.getFloat(5));
				lst.add(reg);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}


	



	@Override
	public int LoginRecord(List<Login> lst) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int ProductRecord(List<Product> lst) {
		// TODO Auto-generated method stub
		return 0;
	}


	}
	

	
	


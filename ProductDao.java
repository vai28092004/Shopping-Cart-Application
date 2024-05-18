package product.dao;

import java.util.List;

import oracle.jdbc.util.Login;
import product.model.Product;
import product.model.Register;


public interface ProductDao {
	
	int createRecord(List<Register> lst);
	//boolean validateUser()
	
	
	int LoginRecord(List<Login> lst);
	int ProductRecord(List<Product>lst);


	List<Register> list();
}

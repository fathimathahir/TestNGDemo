package basicng;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.sym.Name;

public class DataProviderClass {
	
	@DataProvider (name="products")
	
	public Object [][]  amazonproducts()
	{
		return new Object [][] {{"watch"},{"laptop"},{"shoes"},{"books"},{"mobiles"}};
		
	}
@DataProvider (name="twodimensional")
	
	public Object [][] amazonproduct()
	{
		return new Object [][] {{"watch","Toys"},{"laptop","chocolates"},{"shoes","homedecor"},{"books","Furniture"}};
		
	}
@DataProvider (name="2d")

public Object [][]facebook()
{
	return new Object [][] {{"hajarafathi97@gmail.com","fathima1236"},{"hajarafathima97@gmail.com","fathima1236"}};
	
}
}

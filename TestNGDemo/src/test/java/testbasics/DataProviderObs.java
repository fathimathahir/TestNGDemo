package testbasics;

import org.testng.annotations.DataProvider;

public class DataProviderObs {
	@DataProvider (name="inputdetails")

	public Object [][]submitform()
	{
		return new Object [][] {{"Fathima","Thahir","hajarafathi97@gmail.com","kollam","kerala","691015"},
			{"Fathima","T","hajara@gmail.com","kollam","kerala","691015"},
			{"Hajara","hanan","hajarafathi@gmail.com","Tvm","kerala","691015"},
			{"Fathi","Hajara","hajarafathima97@gmail.com","kollam","kerala","691015"}};
		
	}

}

package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DDTest 
{

	
	@Test(priority = 1,dataProvider ="Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String userID,String username, String fname, String lname, String usermail,String pwd,String ph)
	{
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(username);
		userpayload.setFirstname(fname);
		userpayload.setLastname(lname);
		userpayload.setEmail(usermail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		Response response =  UserEndPoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	
	
	
	@Test(priority = 2, dataProvider="UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String username)
	{
		
		 Response response=UserEndPoints.DeleteUser(username);
			Assert.assertEquals(response.getStatusCode(),200);
	
	}
}

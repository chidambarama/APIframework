package api.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTests 
{

	Faker faker;
	User userpayload;

	public Logger logger;

	@BeforeClass
	public void setup()
	{
		faker=new Faker();

		userpayload=new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		//logger

		logger=LogManager.getLogger(this.getClass());
	}



	@Test(priority = 1)
	public void testPostUser()
	{
		logger.info("*****************Creating  user*********************");
		Response response =  UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*****************user is created *******************");

	}

	@Test(priority = 2)
	public void testGetUserByName()
	{
		logger.info("******************reading user info*******************");
		Response response=UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("**********************user info is displayed***************");

	}

	@Test(priority = 3)
	public void testUpdateUserByName()
	{
		/**
		 * update data using payload
		 */

		logger.info("******************updating user info*******************");
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		Response response=UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("******************updated user info*******************");

		/**
		 * checking data after update
		 */
		Response responseAftertheUpdate = UserEndPoints.readUser(this.userpayload.getUsername());
		Assert.assertEquals(responseAftertheUpdate.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void testDeleteByUserName()
	{
		logger.info("******************deleting user info*******************");
		Response response=UserEndPoints.DeleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******************deleted user info*******************");

	}


}


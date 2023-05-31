package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndPoints 
{


	public static Response createUser(User payload)
	{

		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)					
				.when()
				.post(Routes.post_url);

		return response;

	}


	public static Response readUser(String username)
	{

		Response response=given()

				.pathParam("username", username)
				.when()
				.get(Routes.get_url);

		return response;

	}
	
	public static Response updateUser(String username, User payload)
	{

		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)	
				.pathParam("username", username)
				.when()
				.put(Routes.put_url);

		return response;

	}
	
	
	public static Response DeleteUser(String username)
	{

		Response response=given()

				.pathParam("username", username)
				.when()
				.get(Routes.delete_url);

		return response;

	}

}

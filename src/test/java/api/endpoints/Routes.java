package api.endpoints;

/*
 * Swagger  URI:https://petstore.swagger.io
 * 
 * CreateUser(Post):https://petstore.swagger.io/v2/user
 * Getuser(Get):https://petstore.swagger.io/v2/user/{username}
 * UpdateUser(Put):https://petstore.swagger.io/v2/user/{username}
 * DeleteUser(Delete):https://petstore.swagger.io/v2/user/{username}
 * 
 * 
 */
public class Routes
{

	public static String base_url="https://petstore.swagger.io/v2";
	
	
	//User module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	
	
	
	
	
}

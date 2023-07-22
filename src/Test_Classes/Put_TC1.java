package Test_Classes;

import java.time.LocalDateTime;

import org.testng.Assert;
import Common_API_Methods.PUT_API_Method;
import RequestRepository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC1 {

	public static void extractor() {

		int statusCode = PUT_API_Method.ResponseStatusCode(Put_Req_Repository.BaseURI(),
				Put_Req_Repository.Put_Resource(), Put_Req_Repository.Put_TC1());
		System.out.println(statusCode);

		String ResponseBody = PUT_API_Method.ResponseBody(Put_Req_Repository.BaseURI(),
				Put_Req_Repository.Put_Resource(), Put_Req_Repository.Put_TC1());
		System.out.println(ResponseBody);
	
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0, 11);
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_updatedAt = JspResponse.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0, 11);

        //Validate the ResponseBody parameters
		Assert.assertEquals(Res_name, "Saurabhi");
		Assert.assertEquals(Res_job, "Client Service Engineer");
		Assert.assertEquals(Res_updatedAt, expecteddate);
	}

}
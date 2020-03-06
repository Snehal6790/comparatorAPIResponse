package api;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import readfile.ReadFileData;
import restfulservices.RestfulApiLoader;

import java.io.IOException;

public class ApiValidation {

    @Test(dataProvider="getData")
    public void ApiTestValidationUrl(String url1, String url2) {
        RestfulApiLoader restfulApiLoader = new RestfulApiLoader(url1, url2);
        try {
            boolean isValid = restfulApiLoader.isEqual();
            if(isValid == false) {
                System.out.println("API response are not equal");
                Assert.assertFalse(restfulApiLoader.isEqual(), "URL responses are not equal");
            }
            else {
                System.out.println("API response are equal");
                Assert.assertTrue(restfulApiLoader.isEqual(), "URL responses are same");
            }
        }
        catch(AssertionError e) {
            e.setStackTrace(new StackTraceElement[0]);
            throw e;
        }
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        ReadFileData fReader = new ReadFileData();
        return fReader.readFileData();
    }
}

package base;

import org.testng.annotations.BeforeClass;
import utils.BaseAPI;

public class BaseTest {
	
	@BeforeClass
    public void setup() {
        BaseAPI.setup();
    }

}

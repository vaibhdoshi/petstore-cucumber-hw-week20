package com.petstore.storeinfo;

import com.petstore.petinfo.UsersSteps;
import com.petstore.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

//@UseTestDataFrom("src/test/java/resources/testdata/userinfo.csv")
//@RunWith(SerenityParameterizedRunner.class)
public class CreatePetDataDrivenTest extends TestBase {
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Integer userStatus;

    @Steps
    UsersSteps usersSteps;

    @Title("Data driven test for adding multiple users to the application")
    @Test
    public void createMultipleStudents() {

        usersSteps.createUser(id,username,firstname,lastname, email,password,userStatus).statusCode(200);
    }
}

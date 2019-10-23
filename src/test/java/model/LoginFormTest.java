package model;

import migsoft.model.LoginForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginFormTest {

    private LoginForm loginFormExpected;

    @Before
    public void setUp(){
        loginFormExpected = new LoginForm();
    }

    @Test
    public void testGetterUssernameLoginForm_Sucesso(){
        loginFormExpected.setUsername("login");
        Assert.assertSame("login", loginFormExpected.getUsername());
    }

    @Test
    public void testGetterUsernameLoginForm_Falha(){
        loginFormExpected.setUsername("test");
        Assert.assertNotSame("login", loginFormExpected.getUsername());
    }

    @Test
    public void testGetterPasswordLoginForm_Sucesso(){
        loginFormExpected.setPassword("1234abcd");
        Assert.assertSame("1234abcd",loginFormExpected.getPassword());
    }

    @Test
    public void testGetterPasswordLoginForm_Falha(){
        loginFormExpected.setPassword("abcd1234");
        Assert.assertNotSame(" ",loginFormExpected.getPassword());
    }
}

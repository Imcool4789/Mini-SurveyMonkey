package com.group5.MiniSurveyMonkey.test.LoginTest;


import com.group5.MiniSurveyMonkey.Login.DBUser;
import com.group5.MiniSurveyMonkey.Login.DBUserDetails;
import com.group5.MiniSurveyMonkey.Login.DBUserDetailsService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpringSecurityUnitTest {
    DBUserDetailsService dbUserDetailsService;
    DBUserDetails dbUserDetails;

    @Test
    public void testAuthorities() {
        DBUser test = new DBUser();
        test.setRoles("ROLE_ADMIN");
        assertEquals(test.getRoles(), "ROLE_ADMIN");
    }
}

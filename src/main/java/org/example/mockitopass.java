package org.example;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class mockitopass {
    @Test
    public void testWeakPassword() {
        String weakPassword = "abc";
        PasswordUtil passwordUtil = new PasswordUtil();
        PasswordUtil.SecurityLevel result = passwordUtil.assessPassword(weakPassword);
        assertEquals(PasswordUtil.SecurityLevel.WEAK, result);
    }

    @Test
    public void testMediumPassword() {
        String mediumPassword = "abc12345"; // At least 8 characters, letters, and digits
        PasswordUtil.SecurityLevel result = PasswordUtil.assessPassword(mediumPassword);
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, result);
    }

    @Test
    public void testStrongPassword() {
        String strongPassword = "abc123$45"; // At least 8 characters, letters, digits, and special character
        PasswordUtil.SecurityLevel result = PasswordUtil.assessPassword(strongPassword);
        assertEquals(PasswordUtil.SecurityLevel.STRONG, result);
    }

}

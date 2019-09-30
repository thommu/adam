package com.ert.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.ert.bean.LoginBean;

/**
 * 
 * This class is used to test the methods in LoginDao.java
 * 
 * @author Thommu
 *
 */

public class TestLoginDao {
	
	LoginBean loginBean= null;
	LoginDao loginDao = null;
	
	@Before
	public void setUp() {
		loginBean = new LoginBean();
		loginDao = new LoginDao();
	}
	
	@Test
	public void  testAuthenticateUser_ValidUser() {
		try {
			loginBean.setUserName("tom");
			loginBean.setPassword("tom123");
			assertEquals(loginDao.SUCCESS,loginDao.authenticateUser(loginBean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void  testAuthenticateUser_UsernameBlank() {
		try {
			loginBean.setUserName("");
			loginBean.setPassword("tom123");
			assertEquals(loginDao.ERROR_INVALID_AUTH,loginDao.authenticateUser(loginBean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void  testAuthenticateUser_PasswordBlank() {
		try {
			loginBean.setUserName("tom123");
			loginBean.setPassword("");
			assertEquals(loginDao.ERROR_INVALID_AUTH,loginDao.authenticateUser(loginBean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAuthenticateUser_UsernameLength() {
		try {
			loginBean.setUserName("tom123skskskksjjjduuudjdjdududjdjjdjduuudjdjdududdjjdududjjdjdudududjdjdjdudud");
			loginBean.setPassword("");
			assertEquals(loginDao.ERROR_USERNAME_LENGTH,loginDao.authenticateUser(loginBean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAuthenticateUser_UsernameNull() {
		try {
			loginBean.setUserName(null);
			loginBean.setPassword("");
			assertEquals(loginDao.ERROR_UNKNOWN_USERNAME_PASSWORD,loginDao.authenticateUser(loginBean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAuthenticateUser_PasswordLength() {
		try {
			loginBean.setUserName("tom123");
			loginBean.setPassword("1234567890987654322112345678900098766543322112344567890098766543221");
			assertEquals(loginDao.ERROR_PASSWORD_LENGTH,loginDao.authenticateUser(loginBean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAuthenticateUser_PasswordNull() {
		try {
			loginBean.setUserName("tom");
			loginBean.setPassword(null);
			assertEquals(loginDao.ERROR_UNKNOWN_USERNAME_PASSWORD,loginDao.authenticateUser(loginBean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAuthenticateUser_WrongPassword() {
		try {
			loginBean.setUserName("tom123");
			loginBean.setPassword("wrongpass");
			assertEquals(loginDao.ERROR_INVALID_AUTH,loginDao.authenticateUser(loginBean));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void  testAuthenticateUser_LoginBeanNull() {
		try {
			loginBean.setUserName("tom");
			loginBean.setPassword("tom123");
			assertEquals(loginDao.ERROR_UNKNOWN,loginDao.authenticateUser(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

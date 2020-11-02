package edu.eci.cvds.test;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

import edu.eci.cvds.services.EquiposServices;
import edu.eci.cvds.services.EquiposServicesFactory;

public class EquiposServicesTest {
	
	@Inject
    private SqlSession sqlSession;
	
	private EquiposServices equiposServices;

    public EquiposServicesTest() {
    	equiposServices = EquiposServicesFactory.getInstance().getEquiposServicesTesting();
    }
    
    @Test
	public void test() {
    	Assert.assertTrue("Not yet implemented", true);
	}
    
}

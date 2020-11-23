package edu.eci.cvds.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class ValidacionSesion extends AccessControlFilter {
	
	String welcomeurl;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		Subject subject = getSubject(request, response);
	    return !subject.isAuthenticated(); // THE POINT
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		welcomeurl="/faces/sesion.xhtml";
        WebUtils.issueRedirect(request, response, welcomeurl);
        return false;
	}
	
	public String getWelcomeurl() {
        return welcomeurl;
    }

    public void setWelcomeurl(String welcomeurl) {
        this.welcomeurl = welcomeurl;
    }

}
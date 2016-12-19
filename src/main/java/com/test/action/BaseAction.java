package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class BaseAction extends ActionSupport
        implements ServletRequestAware, ServletResponseAware, SessionAware, ApplicationAware {

    private static final long serialVersionUID = -1101792624159255155L;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Map<String, Object> session;
    protected Map<String, Object> application;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;

    }

}

package com.test.action;

import com.alibaba.fastjson.JSONObject;
import com.test.BuildHelper;
import com.test.bean.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;

import java.io.PrintWriter;
import java.util.List;

@AllowedMethods({"execute", "action", "req"})
@Action(value = "test", results = {
        @Result(name = "action", location = "/WEB-INF/jsp/action.jsp"),
        @Result(name = "success", location = "/WEB-INF/jsp/index.jsp")
})
@InterceptorRefs({@InterceptorRef("defaultStack"), @InterceptorRef("testInterceptor")})
public class TestAction extends BaseAction {

    private static final long serialVersionUID = -1314518014039734426L;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String action() {
        List<User> users = BuildHelper.buildUsers();
        request.setAttribute("users", users);
        request.setAttribute("title", "用户列表");
        return "action";
    }

    public void req() throws Exception {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("age", age);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8;");
        PrintWriter out = response.getWriter();
        out.print(object.toJSONString());
        out.flush();
        out.close();
    }
}
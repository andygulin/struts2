package com.test.action;

import com.alibaba.fastjson.JSON;
import com.test.BuildHelper;
import com.test.bean.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;

import java.io.PrintWriter;
import java.util.List;

@AllowedMethods("all")
@Action(value = "user")
@InterceptorRefs({@InterceptorRef("defaultStack"), @InterceptorRef("testInterceptor")})
public class UserAction extends BaseAction {

    private static final long serialVersionUID = -1885854904242552572L;

    public void all() throws Exception {
        List<User> users = BuildHelper.buildUsers();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(users));
        out.flush();
        out.close();
    }
}

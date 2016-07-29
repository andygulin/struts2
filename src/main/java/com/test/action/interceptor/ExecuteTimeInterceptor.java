package com.test.action.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ExecuteTimeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 4172535605107971334L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		StopWatch watch = new StopWatch("ExecuteTime");
		watch.start("ExecuteTimeInterceptor");
		String result = invocation.invoke();
		watch.stop();
		System.out.println(StringUtils.repeat("=", 80));
		System.out.println("Action :" + invocation.getAction());
		System.out.println("Result : " + invocation.getResult());
		System.out.println("Id : " + watch.getId());
		System.out.println("LastTaskName : " + watch.getLastTaskName());
		System.out.println("LastTaskTimeMillis " + watch.getLastTaskTimeMillis());
		System.out.println("TaskCount : " + watch.getTaskCount());
		System.out.println("TotalTimeMillis : " + watch.getTotalTimeMillis());
		System.out.println("TotalTimeSeconds : " + watch.getTotalTimeSeconds());
		System.out.println("LastTaskInfo : " + JSON.toJSONString(watch.getLastTaskInfo()));
		System.out.println("TaskInfo : " + JSON.toJSONString(watch.getTaskInfo()));
		System.out.println(StringUtils.repeat("=", 80));
		return result;
	}
}
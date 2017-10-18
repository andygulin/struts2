package com.test.action.interceptor;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StopWatch;

public class ExecuteTimeInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 4172535605107971334L;

    private static final Logger LOGGER = LogManager.getLogger(ExecuteTimeInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        StopWatch watch = new StopWatch("ExecuteTime");
        watch.start("ExecuteTimeInterceptor");
        String result = invocation.invoke();
        watch.stop();
        LOGGER.info(StringUtils.repeat("=", 80));
        LOGGER.info("Action : {}", invocation.getAction());
        LOGGER.info("Result : {}", invocation.getResult());
        LOGGER.info("Id : {}", watch.getId());
        LOGGER.info("LastTaskName : {}", watch.getLastTaskName());
        LOGGER.info("LastTaskTimeMillis : {}", watch.getLastTaskTimeMillis());
        LOGGER.info("TaskCount : {}", watch.getTaskCount());
        LOGGER.info("TotalTimeMillis : {}", watch.getTotalTimeMillis());
        LOGGER.info("TotalTimeSeconds : {}", watch.getTotalTimeSeconds());
        LOGGER.info("LastTaskInfo : {}", JSON.toJSONString(watch.getLastTaskInfo()));
        LOGGER.info("TaskInfo : {}", JSON.toJSONString(watch.getTaskInfo()));
        LOGGER.info(StringUtils.repeat("=", 80));
        return result;
    }
}
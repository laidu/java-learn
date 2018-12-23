package org.laidu.learn.btrace.monitor;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * print method run time spend
 * run on jvisualvm whit BTrace Worker
 * @author tiancai.zang
 * 2018-02-06 12:42.
 */
@BTrace
public class MethodRunTime {
    // : 2018-02-06 12:42  print method run time spend

    @OnMethod(clazz = "/com.alpha.tools.mobile.+/", method = "/.+/", location = @Location(Kind.RETURN))
    public static void traceExecute(@ProbeClassName String name, @ProbeMethodName String method, @Duration long time){
        long durationTime = time/1000000;
        if(durationTime > 0){
            String output = strcat(name,".");
            output = strcat(output,method);
            output = strcat(output,"#");
            output = strcat(output,str(probeLine()));
            output = strcat(output,">>");
            output = strcat(output,str(durationTime));
            output = strcat(output,">>ThreadId:");
            output = strcat(output,str(threadId(currentThread())));
            println(output);
        }
    }
}
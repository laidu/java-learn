package org.laidu.learn.language.feature.object;

import java.lang.instrument.Instrumentation;


/**
 * InstrumentationAgent
 *
 * @author zangtiancai
 * @date 2019-03-18 19:18.
 */
public class InstrumentationAgent {

    private static volatile Instrumentation globalInstrumentation;

    public static void premain(final String agentArgs, final Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static long getObjectSize(final Object object) {
        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }
        return globalInstrumentation.getObjectSize(object);
    }
}

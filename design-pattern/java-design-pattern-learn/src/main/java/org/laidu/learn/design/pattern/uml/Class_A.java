package org.laidu.learn.design.pattern.uml;

/**
 * User: zangtiancai
 * Date: 2017/8/24
 * Time: 下午2:14
 */
public class Class_A {

    private String attribute_private;
    String attribute_default;
    protected String attribute_protected;
    public String attribute_public;
    static String attribute_static;
    final String attribute_final = "";

    public String sayHello(){
        return "Hello";
    }
}

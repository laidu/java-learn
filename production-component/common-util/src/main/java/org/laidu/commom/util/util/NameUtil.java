package org.laidu.commom.util.util;

import java.util.ArrayList;
import java.util.List;

/**
 * name util
 * <p>
 * Created by tiancai.zang on 2017-12-18 16-07.
 */
public final class NameUtil {

    /**
     * Private constructor.
     */
    private NameUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static NameUtil getInstance() {
        return NameUtilHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class NameUtilHolder {

        private static final NameUtil INSTANCE =
                new NameUtil();
    }


    /**
     * 头峰式转下划线
     * @param name
     * @return
     */
    public  String to_(String name){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < name.length() ; ++i){
            char c = name.charAt(i);
            if (c >= 'A' && c <= 'Z'){
                stringBuilder.append("_").append(Character.toLowerCase(c));
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 下划线转头峰式
     * @param name
     * @return
     */
    public String toCamelCase (String name){
        String camelCase = "";
        String [] arr = name.split("_");
        List<String> list = new ArrayList<String>();

        //将数组中非空字符串添加至list
        for(String a : arr){
            if(a.length() > 0){
                list.add(a);
            }
        }
        for(int i=0;i<list.size();i++){
            if(i>0){    //后面单词首字母大写
                char c = list.get(i).charAt(0);
                String s = String.valueOf(c).toUpperCase() + list.get(i).substring(1).toLowerCase();
                camelCase+=s;
            }else{  //首个单词小写
                camelCase+=list.get(i).toLowerCase();
            }
        }
        return camelCase;
    }

}
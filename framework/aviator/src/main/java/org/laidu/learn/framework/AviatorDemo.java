package org.laidu.learn.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;

public class AviatorDemo {


    private static final AviatorEvaluatorInstance instance;

    private static final Expression expression;

    static {
        instance = AviatorEvaluator.newInstance();
        try {
            instance.importFunctions(YxhService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        expression = instance.compile("a = YxhService.print(YxhService,demo.uid)", true);
    }


    public static void main(String[] args) throws Exception {

        YxhService yxhService = new YxhService();

        ExecutorService executorService = Executors.newFixedThreadPool(16);

        for (int i = 0; i < 15; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 10000000_0000L; j++) {
                    Map<String, Object> env = new HashMap<>();
                    YxhDemo demo = new YxhDemo();
                    demo.setUid("123");
                    env.put("demo", demo);
                    env.put("YxhService", yxhService);
                    String a = (String) expression.execute(env);
//                    System.out.println(a);
                }
            });
        }

//        executorService.submit(() -> {
//            while (true) {
//                Thread.sleep(100);
//                System.gc();
//            }
//        });

        executorService.shutdown();

    }



    public static class YxhDemo {

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        private String uid;

        public String print(String str){
            return str;
        }
    }

    public static class YxhService {

        public String print(String str){
            return str;
        }
    }



}

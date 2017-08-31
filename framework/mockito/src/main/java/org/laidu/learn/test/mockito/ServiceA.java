package org.laidu.learn.test.mockito;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * ServiceA
 * <p>
 * Created by 臧天才 on 2017-08-31 11:07.
 */
@Slf4j
@Data
public class ServiceA {

    private ServiceB serviceB;

    private ServiceC serviceC;

    public void invokeServiceB(){
        serviceB.service();
    }

    public void invokeServiceC(){
        serviceC.service();
    }

}

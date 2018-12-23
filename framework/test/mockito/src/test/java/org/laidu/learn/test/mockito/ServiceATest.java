package org.laidu.learn.test.mockito;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@Slf4j
@DisplayName("Mockito ServiceA Test")
class ServiceATest {

    private ServiceA serviceA;

    @BeforeEach
    void setUp() {

        serviceA = new ServiceA();

        ServiceB serviceB = mock(ServiceB.class);
        doAnswer(InvocationOnMock::callRealMethod).when(serviceB).service();
        ServiceC serviceC = mock(ServiceC.class);
        doAnswer(InvocationOnMock::callRealMethod).when(serviceC).service();

        serviceA.setServiceB(serviceB);
        serviceA.setServiceC(serviceC);
    }

    @Test
    @DisplayName("invokeServiceB")
    void invokeServiceB() {

        serviceA.invokeServiceB();
    }

    @Test
    @DisplayName("invokeServiceC")
    void invokeServiceC() {

        serviceA.invokeServiceC();
    }

    @Test
    @DisplayName("验证某些行为")
    void name() {
    }
}
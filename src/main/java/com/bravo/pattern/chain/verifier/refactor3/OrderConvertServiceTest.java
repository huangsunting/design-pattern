package com.bravo.pattern.chain.verifier.refactor3;

import com.bravo.pattern.chain.verifier.refactor3.support.OrderConvertRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OrderConvertServiceTest {

    @Resource(name = "orderConvertServiceRefactor3")
    private OrderConvertService orderConvertService;

    @Test
    public void test() {
        OrderConvertRequest request = new OrderConvertRequest(9527L, "123456", 2);
        boolean convert = orderConvertService.convert(request);
        System.out.println(convert);
    }

}
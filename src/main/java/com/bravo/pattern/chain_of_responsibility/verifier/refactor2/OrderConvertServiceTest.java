package com.bravo.pattern.chain_of_responsibility.verifier.refactor2;

import com.bravo.pattern.chain_of_responsibility.verifier.refactor2.support.OrderConvertRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OrderConvertServiceTest {

    @Resource(name = "orderConvertServiceByVerifyChain")
    private OrderConvertService orderConvertService;

    @Test
    public void test() {
        OrderConvertRequest request = new OrderConvertRequest(9527L, "123456", 1);
        boolean convert = orderConvertService.convert(request);
        System.out.println(convert);
    }

}
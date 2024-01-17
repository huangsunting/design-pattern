package com.bravo.pattern.chain.verifier_generic.biz;

import com.bravo.pattern.chain.verifier_generic.biz.support.BizRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OrderConvertServiceTest {

    @Resource
    private OrderConvertService orderConvertService;

    @Test
    public void test() {
        BizRequest request = new BizRequest(9527L, "123456", 2);
        boolean convert = orderConvertService.convert(request);
        System.out.println(convert);
    }

}

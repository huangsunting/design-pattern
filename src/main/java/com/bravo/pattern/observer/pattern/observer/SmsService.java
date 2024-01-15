package com.bravo.pattern.observer.pattern.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsService implements Observer {

    public void update(String phone, String content) {
        log.info("用户(" + phone + ")你在京西数码购买了" + content);
    }

}

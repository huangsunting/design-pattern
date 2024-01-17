package com.bravo.pattern.chain.pipeline.biz;


import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserMessage {
    private String user;
    private String inputContent;
    private Date date;

    @Override
    public String toString() {
        return DateUtil.formatDateTime(date) + " " + user + "说: " + inputContent;
    }
}

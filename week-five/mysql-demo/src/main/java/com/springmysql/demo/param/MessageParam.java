package com.springmysql.demo.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class MessageParam extends PageParam{
    private Integer msgId;
    private String msgText;
    private String msgSummary;
}
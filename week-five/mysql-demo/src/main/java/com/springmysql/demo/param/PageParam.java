package com.springmysql.demo.param;

import lombok.Data;

@Data
public class PageParam {
    private Integer beginLine;
    private Integer pageSize = 3;
    private Integer currentPage = 0;
    public int getBeginLine() {
        return pageSize * currentPage;
    }
}
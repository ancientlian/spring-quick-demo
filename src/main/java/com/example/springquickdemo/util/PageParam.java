package com.example.springquickdemo.util;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import java.util.List;

/**
 * @author lian
 */
@Data
public class PageParam<T> {


    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;

    /**
     * 当前页 默认1
     */
    private long current = 1;

    /**
     * 查询数据列表
     */
    private List<T> records;

    /**
     * 总数
     */
    private long total = 0;

    /**
     * 是否进行 count 查询
     */
    @JsonIgnore
    private boolean isSearchCount = true;
    @JsonIgnore
    private String countId;
    @JsonIgnore
    private Long maxLimit;
    @JsonIgnore
    private boolean optimizeCountSql;


    @JsonIgnore
    public boolean getSearchCount() {
        if (total < 0) {
            return false;
        }
        return isSearchCount;
    }


}

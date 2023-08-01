package com.example.springquickdemo;

import com.example.springquickdemo.dto.SysLogVO;
import com.example.springquickdemo.mapstruct.DateTestConvert;
import com.example.springquickdemo.model.SysLog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringQuickDemoApplicationTests {

    @Test
    void contextLoads() {
        SysLog sysLog = new SysLog();
        sysLog.setCreateDate(new Date());
        SysLogVO sysLogVO = DateTestConvert.INSTANCE.dataConvert(sysLog);
        System.out.println("sysLogVO = " + sysLogVO);
    }

}

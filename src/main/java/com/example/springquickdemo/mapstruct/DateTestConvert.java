package com.example.springquickdemo.mapstruct;

import com.example.springquickdemo.dto.SysLogVO;
import com.example.springquickdemo.model.SysLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author lian
 */
@Mapper
public interface DateTestConvert {
    DateTestConvert INSTANCE =  Mappers.getMapper(DateTestConvert.class);



    @Mapping(source = "createDate", target = "createDateTime", dateFormat = "yyyy-MM-dd")
    SysLogVO dataConvert(SysLog sysLog);
}

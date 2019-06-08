package com.shape.singleproject.admin;

import com.google.common.collect.Maps;
import com.shape.singleproject.constant.*;
import com.shape.singleproject.domain.EnumEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 提供前端所有枚举类型数据
 */
@RestController
@RequestMapping("/admin/enum")
@Slf4j
public class AdminEnumListController {

    @GetMapping("/allEnum")
    public HashMap<String, List<EnumEntry>> allEnum() {
        HashMap<String, List<EnumEntry>> map = Maps.newHashMap();

        // 管理员级别
        map.put("adminLevelList", Stream.of(AdminLevelEnum.values())
                .map(x -> new EnumEntry(x.getLevel(), x.getDesc()))
                .collect(Collectors.toList()));

        // 星座枚举
        map.put("constellationList", Stream.of(ConstellationEnum.values())
                .map(x -> new EnumEntry(x.getCode(), x.getDescription()))
                .collect(Collectors.toList()));

        // 学历枚举
        map.put("educationList", Stream.of(EducationEnum.values())
                .map(x -> new EnumEntry(x.getCode(), x.getDescription()))
                .collect(Collectors.toList()));

        // 举报状态枚举
        map.put("reportStatusList", Stream.of(ReportStatusEnum.values())
                .map(x -> new EnumEntry(x.getStatus(), x.getDesc()))
                .collect(Collectors.toList()));

        // 举报类型枚举
        map.put("reportTypeList", Stream.of(ReportType.values())
                .map(x -> new EnumEntry(x.getReportCode(), x.getDesc()))
                .collect(Collectors.toList()));

        // 性别枚举
        map.put("sexList", Stream.of(SexEnum.values())
                .map(x -> new EnumEntry(x.getCode(), x.getDescription()))
                .collect(Collectors.toList()));

        // 标签类型枚举
        map.put("tagTypeList", Stream.of(TagTypeEnum.values())
                .map(x -> new EnumEntry(x.getTagCode(), x.getTagDesc()))
                .collect(Collectors.toList()));

        // 用户状态枚举
        map.put("userStatusList", Stream.of(UserStatusEnum.values())
                .map(x -> new EnumEntry(x.getStatus(), x.getDescription()))
                .collect(Collectors.toList()));

        map.put("ynList", Stream.of(YnEnum.values())
                .map(x -> new EnumEntry(x.getCode(), x.getDesc()))
                .collect(Collectors.toList()));

        return map;
    }
}

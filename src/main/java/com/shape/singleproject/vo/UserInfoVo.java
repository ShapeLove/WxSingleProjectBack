package com.shape.singleproject.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserInfoVo {
    private List<String> photoList;
    private String openId;
    private String name;
    private Integer yn;
    private String constellationStr;
    private LocalDate birthday;
    private String educationStr;
    private Integer sex;
    private String province;
    private String city;
    private String hobby;
    private Integer height;
    private Integer weight;
    private String selfEvaluation;
    private String workArea;
    private String wantSay;
    private String family;
    private String standFriend;
    private String department;
    private Integer status;
    private String dongdong;
    private String wxNumber;
    private Boolean attention;
    private Boolean allAttention;
    private Integer doingTags;
    private String doingTagsDesc;
    private Integer activityTags;
    private String activityTagsDesc;
    private Integer planTags;
    private String planTagsDesc;
}

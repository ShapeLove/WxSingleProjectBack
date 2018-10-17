package com.shape.singleproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenidValue {
    private String openid;
    private String sessionKey;
    private Integer userStatus;
}

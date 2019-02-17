package com.shape.singleproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenidValue {
    private String customKey;
    private String openId;
    private String sessionKey;
}

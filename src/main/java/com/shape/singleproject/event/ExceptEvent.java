package com.shape.singleproject.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptEvent {
    private String methodName;
    private String exceptMessage;

}

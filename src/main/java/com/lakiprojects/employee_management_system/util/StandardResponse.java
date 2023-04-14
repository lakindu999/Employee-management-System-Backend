package com.lakiprojects.employee_management_system.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data

public class StandardResponse {
    private int code;
    private String message;
    private Object content;
}

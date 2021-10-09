package com.code.design;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class SignUpRequest {

    @NotEmpty
    private String name;

    public Member toEntity() {
        return new Member(name);
    }

}

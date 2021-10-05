package com.code.design.part1;

public interface ChangePasswordService {
    public void change(Long id, PasswordChangeRequest dto);
}

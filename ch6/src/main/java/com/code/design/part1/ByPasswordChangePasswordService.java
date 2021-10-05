package com.code.design.part1;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ByPasswordChangePasswordService implements ChangePasswordService {

    private MemberFindService memberFindService;

    @Override
    public void change(final Long id, PasswordChangeRequest dto) {
        if (dto.getPassword().equals("비밀번호가 일치하는지 판단 로직...")) {
            final Member member = memberFindService.findById(id);
            final String newPassword = dto.getNewPassword();
            member.changePassword(newPassword);
        }
    }
}

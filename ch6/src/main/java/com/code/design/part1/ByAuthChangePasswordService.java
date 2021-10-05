package com.code.design.part1;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ByAuthChangePasswordService implements ChangePasswordService {

    private final MemberFindService memberFindService;

    @Override
    public void change(Long id, PasswordChangeRequest dto) {

        if (dto.getAuthCode().equals("인증 코드가 적합한지 로직 추가...")) {
            final Member member = memberFindService.findById(id);
            final String newPassword = dto.getNewPassword();
            member.changePassword(newPassword);
            // 로직 추가...
        }
    }
}

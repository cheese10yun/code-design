package com.code.design.part1;

public interface MemberService {

    Member findById(Long id);

    Member findByEmail(String email);

    Member create(Member member);

    void changePassword(PasswordChangeRequest dto);

    Member updateName(Long id, String name);

}
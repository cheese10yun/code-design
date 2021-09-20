package com.code.design.lombok;

import static org.assertj.core.api.BDDAssertions.then;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    public void setter_남용의_문제() {

    }

    @Test
    public void toString_양방향_순한_참조_문제() {
        final Member member = Member.builder()
            .email("asd@asd.com")
            .name("name")
            .build();

        final Coupon coupon = Coupon.builder()
            .member(member)
            .build();

        final List<Coupon> coupons = new ArrayList<>();
        coupons.add(coupon);
        member.setCoupons(coupons);

        System.out.println(member); // toString 순한 참조 발생, java.lang.StackOverflowError
    }

    @Test
    public void EqualsAndHashCode_의_문제() {
    }

    @Test
    public void 클래스_상단의_Builder_의_문제() {

        // id, createdAt, updatedAt은 데이터베이스에서 지정하기로 했는데 설정이 가능하다.
        // email, name은 필수 값인데
        Member.builder()
            .id(1L)
            .createAt(LocalDateTime.of(2021, 12, 12, 12, 12))
            .updateAt(LocalDateTime.of(2010, 12, 12, 12, 12))
            .build();

        // 이미 사용한 쿠폰을 만들 수 있다.
        Coupon.builder()
            .used(false)
            .build();
    }

    @Test
    public void Builder_default_는_지양하자() {
        final Member member = Member.builder()
            .build();

        then(member.getEmail()).isEqualTo("test@test.com"); // POJO 값 그대로 예상
        then(member.getName()).isEqualTo("yun"); // POJO 값 그대로 예상
    }

    @Test
    public void 생성자위_Builder_의_적적한_책임_부여() {
        final Member member = Member.builder()
            .name("asd")
            .email("asd@asd.com")
            .build();

        Coupon.builder()
            .member(member)
            .build();

    }

    @Test
    public void 생성자_접근_지시자는_최소한_으로() {
        final Coupon coupon = new Coupon(); // 필수값, 비지니스로직을 모두 무시하고 객체 생성 가능
        final Member member = new Member(); // 필수값, 비지니스로직을 모두 무시하고 객체 생성 가능
    }
}
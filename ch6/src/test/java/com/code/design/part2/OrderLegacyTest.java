package com.code.design.part2;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import org.junit.jupiter.api.Test;


class OrderLegacyTest {

    // Order의 getMessageTypes 메서드를 사용 할 때 불편하다
    // 안좋은 캡슐화
    @Test
    public void anti_message_test_01() {
        final OrderLegacy orderLegacy = new OrderLegacy("KAKAO,EMAIL,SMS");
        final String[] split = orderLegacy.getMessageTypes();

        then(split).contains("KAKAO", "EMAIL", "SMS");
    }

    @Test
    public void KAKAO를_KAOKO_라고_잘못_입력했을_경우() {
        final OrderLegacy orderLegacy = new OrderLegacy("KAOKO,EMAIL,SMS");
        final String[] split = orderLegacy.getMessageTypes();

        then(split).doesNotContain("KAKAO");
        then(split).contains("EMAIL", "SMS");
    }

    @Test
    public void 메시지에_KAKAO_EMAIL_SMS_처럼_공백이_들어_간다면_실패한다() {
        final OrderLegacy orderLegacy = new OrderLegacy("KAKAO, EMAIL, SMS");
        final String[] split = orderLegacy.getMessageTypes();

        then(split).contains("KAKAO");
        then(split).doesNotContain("EMAIL", "SMS");
    }

    @Test
    public void 메시지가_없을_때_빈문자열을_보낼_경우() {
        final OrderLegacy orderLegacy = new OrderLegacy("");
        final String[] split = orderLegacy.getMessageTypes();

        then(split).contains("");
    }

    @Test
    public void 메시지가_없을_때_null_보내는_경우() {
        final OrderLegacy orderLegacy = new OrderLegacy(null);
        thenThrownBy(() -> orderLegacy.getMessageTypes())
            .isInstanceOf(NullPointerException.class);

    }

    @Test
    public void 메시지가_중복으로_올경우() {
        final OrderLegacy orderLegacy = new OrderLegacy("KAKAO, KAKAO, KAKAO");
        final String[] split = orderLegacy.getMessageTypes();

        then(split).contains("KAKAO");
        then(split).hasSize(3);
    }
}
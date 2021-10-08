package com.code.design;

import com.code.design.member.Member;
import com.code.design.order.Order;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    /**
     * 외부 인프라 서비스를 호출한다고 가정한다
     */
    public void sendOrderEmail(Order order) {
        System.out.println("주문자 이메일: " + order.getOrderer().getEmail());
        System.out.println("주문 가격: " + order.getProductAmount());
    }

    /**
     * 외부 인프라 서비스를 호출한다고 가정한다
     */
    public void sendSignUpEmail(Member member) {
        throw new RuntimeException("회원 가입 이메일 전송 실패");
//        System.out.println(member.getName() + " 님 회원가입을 축하드립니다.");
    }

}

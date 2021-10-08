package com.code.design.order;

import com.code.design.order.OrderSheetRequest.Account;
import com.code.design.order.OrderSheetRequest.Card;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.ObjectUtils;

public class OrderSheetFormValidator implements ConstraintValidator<OrderSheetForm, OrderSheetRequest> {

    @Override
    public void initialize(OrderSheetForm constraintAnnotation) {

    }

    @Override
    public boolean isValid(OrderSheetRequest value, ConstraintValidatorContext context) {
        int invalidCount = 0;

        if (value.getPayment().getAccount() == null && value.getPayment().getCard() == null) {
            addConstraintViolation(context, "카드 정보 혹은 계좌정보는 필수입니다.", "payment");
            invalidCount += 1;
        }

        if (value.getPayment().getPaymentMethod() == PaymentMethod.CARD) {
            final Card card = value.getPayment().getCard();

            if (card == null) {
                addConstraintViolation(context, "카드 필수입니다.", "payment", "card");
                invalidCount += 1;
            } else {
                if (ObjectUtils.isEmpty(card.getBrand())) {
                    addConstraintViolation(context, "카드 브렌드는 필수입니다.", "payment", "card", "brand");
                    invalidCount += 1;
                }
                if (ObjectUtils.isEmpty(card.getCsv())) {
                    addConstraintViolation(context, "CSV 값은 필수 입니다.", "payment", "card", "csv");
                    invalidCount += 1;
                }
                if (ObjectUtils.isEmpty(card.getNumber())) {
                    addConstraintViolation(context, "카드 번호는 필수 입니다.", "payment", "card", "number");
                    invalidCount += 1;
                }
            }
        }

        if (value.getPayment().getPaymentMethod() == PaymentMethod.BANK_TRANSFER) {
            final Account account = value.getPayment().getAccount();

            if (account == null) {
                addConstraintViolation(context, "계좌정보는 필수입니다.", "payment", "account");
                invalidCount += 1;
            } else {
                if (ObjectUtils.isEmpty(account.getBankCode())) {
                    addConstraintViolation(context, "은행코드는 필수입니다.", "payment", "account", "bankCode");
                    invalidCount += 1;
                }
                if (ObjectUtils.isEmpty(account.getHolder())) {
                    addConstraintViolation(context, "계좌주는 값은 필수 입니다.", "payment", "account", "holder");
                    invalidCount += 1;
                }
                if (ObjectUtils.isEmpty(account.getNumber())) {
                    addConstraintViolation(context, "계좌번호는 필수값입니다.", "payment", "account", "number");
                    invalidCount += 1;
                }
            }
        }

        return invalidCount == 0;
    }

    private void addConstraintViolation(
        final ConstraintValidatorContext context,
        final String errorMessage,
        final String firstNode,
        final String secondNode,
        final String thirdNode
    ) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
            .addPropertyNode(firstNode)
            .addPropertyNode(secondNode)
            .addPropertyNode(thirdNode)
            .addConstraintViolation();
    }

    private void addConstraintViolation(
        final ConstraintValidatorContext context,
        final String errorMessage,
        final String firstNode
    ) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
            .addPropertyNode(firstNode)
            .addConstraintViolation();
    }

    private void addConstraintViolation(
        final ConstraintValidatorContext context,
        final String errorMessage,
        final String firstNode,
        final String secondNode
    ) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
            .addPropertyNode(firstNode)
            .addPropertyNode(secondNode)
            .addConstraintViolation();
    }
}
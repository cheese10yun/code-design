package com.code.design.test_3;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

import com.code.design.Member;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Test_2 {

    @Test
    public void 기존_matcher_불편한점() {
//        org.hamcrest.MatcherAssert.assertThat("aa", org.hamcrest.Matchers.is("aa"));

    }

    @Test
    public void 문장_검사() {
        final String title = "AssertJ is best matcher";
        then(title)
            .isNotNull()
            .startsWith("AssertJ")
            .contains(" ")
            .endsWith("matcher")
        ;
    }

    @Test
    public void 다양한_기능_제공() {
        then(BigDecimal.ZERO).isEqualByComparingTo(BigDecimal.valueOf(0));
        then(" ").isBlank();
        then("").isEmpty();
        then("YWJjZGVmZw==").isBase64();
        then("AA").isIn("AA", "BB", "CC");

        final LocalDate targetDate = LocalDate.of(2020, 5, 5);
        then(targetDate).isBetween(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 12));
    }

    @Test
    public void collection_검증() {
        final List<Member> members = new ArrayList<>();
        members.add(new Member("Kim"));
        members.add(new Member("Joo"));
        members.add(new Member("Jin"));

        then(members).hasSize(3);
        then(members).allSatisfy(member -> {
                System.out.println(member);
                then(member.getName()).isIn("Kim", "Joo", "Jin");
                then(member.getId()).isNull();
            }
        );
    }

    @Test
    public void thenThrownBy_사용법() {
        thenThrownBy(() -> new Member(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void BDD_Style() {
        assertThat(10).isEqualTo(10);
        assertThat(true).isTrue();

        then(10).isEqualTo(10);
        then(true).isTrue();
    }
}
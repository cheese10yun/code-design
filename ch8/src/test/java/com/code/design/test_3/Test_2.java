package com.code.design.test_3;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import com.code.design.Member;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Test_2 {

    @Test
    public void 문장_검사() {
        final String title = "AssertJ is best matcher";

        then(title).isNotNull()
            .startsWith(title)
            .contains(" ")
            .endsWith("matcher");
    }

    @Test
    public void collection_검증() {
        final List<Member> members = new ArrayList<>();
        members.add(new Member("Kim"));
        members.add(new Member("Joo"));
        members.add(new Member("Jin"));

        then(members).anySatisfy(member ->
            then(member.getName()).isIn("Kim", "Joo", "Jin")
        );
    }

    @Test
    public void thenThrownBy_사용법() {
        thenThrownBy(() -> new Member(""))
            .isInstanceOf(IllegalArgumentException.class)
    }
}
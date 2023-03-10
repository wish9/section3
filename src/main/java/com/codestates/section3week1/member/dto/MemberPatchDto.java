package com.codestates.section3week1.member.dto;

import javax.validation.constraints.Pattern;

public class MemberPatchDto {
    private long memberId;

    @Pattern(regexp = "^\\S+(\\s?\\S+)*$", message = "이름은 공백이 아니어야 합니다.")
    // 공백 아닌 문자 1개 이상((공백인 문자 0개 또는 1개)(공백이 아닌 문자 1개 이상)) -> 마지막 맨 바깥 쪽 괄호 조건이 0개 이상(즉, 있어도 되고 없어도 된다)
    private String name;
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 10or11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}

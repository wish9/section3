package com.codestates.section3week1.member.mapstruct.mapper;

import com.codestates.section3week1.member.entity.Member;
import com.codestates.section3week1.member.dto.MemberPatchDto;
import com.codestates.section3week1.member.dto.MemberPostDto;
import com.codestates.section3week1.member.dto.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto); // MemberPostDto를 Member로 변환
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto); // MemberPatchDto를 Member로 변환
    MemberResponseDto memberToMemberResponseDto(Member member); // Member를 MemberResponseDto로 변환
}

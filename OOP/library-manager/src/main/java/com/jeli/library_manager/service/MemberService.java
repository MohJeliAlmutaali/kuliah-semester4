package com.jeli.library_manager.service;

import com.jeli.library_manager.model.Member;
import com.jeli.library_manager.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id_member) {
        return memberRepository.findById(id_member);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(Long id_member) {
        memberRepository.deleteById(id_member);
    }
}

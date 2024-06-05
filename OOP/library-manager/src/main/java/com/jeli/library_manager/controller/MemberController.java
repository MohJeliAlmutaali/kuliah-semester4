package com.jeli.library_manager.controller;

import com.jeli.library_manager.model.Member;
import com.jeli.library_manager.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id_member) {
        return memberService.getMemberById(id_member);
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id_member, @RequestBody Member memberDetails) {
        Optional<Member> memberOptional = memberService.getMemberById(id_member);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.setName(memberDetails.getName());
            member.setEmail(memberDetails.getEmail());
            member.setIdnumber(memberDetails.getIdnumber());
            member.setAddress(memberDetails.getAddress());
            member.setPhone(memberDetails.getPhone());
            return memberService.saveMember(member);
        } else {
            throw new RuntimeException("Member not found with id " + id_member);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id_member) {
        memberService.deleteMember(id_member);
    }
}

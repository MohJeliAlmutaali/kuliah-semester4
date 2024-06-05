package com.jeli.library_manager.repository;

import com.jeli.library_manager.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

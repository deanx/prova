package com.wallmart.prova.repo;

import java.util.List;

import com.wallmart.prova.domain.Member;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> findAllOrderedByName();

    public Member register(Member member);
}

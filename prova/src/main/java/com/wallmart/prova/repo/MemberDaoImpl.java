package com.wallmart.prova.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.wallmart.prova.domain.Member;
import com.wallmart.prova.infra.web.HttpUtils;

@Repository
@Transactional
public class MemberDaoImpl implements MemberDao
{
	@Autowired
	private EntityManager em;

    public Member findById(Long id)
    {
        return em.find(Member.class, id);
    }

    @Cacheable(value="wallmart-cache")
    public Member findByEmail(String email)
    {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = builder.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);


        criteria.select(member).where(builder.equal(member.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    @Cacheable("wallmart-cache")
    public List<Member> findAllOrderedByName()
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
        Root<Member> member = criteria.from(Member.class);


        criteria.select(member).orderBy(cb.asc(member.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    public Member register(Member member)
    {
        Member newMember = em.merge(member);
        
        return newMember;
    }
}

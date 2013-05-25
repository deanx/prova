package com.wallmart.prova.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wallmart.prova.domain.MemberRole;

@Repository
@Transactional
public class MemberRoleDaoImpl implements MemberRoleDao {
	
	@Autowired
    private EntityManager em;
	
	
	public void register(MemberRole member) {
		em.persist(member);
	}
}

package com.wallmart.prova.test;

import java.util.List;

import junit.framework.Assert;

import com.wallmart.prova.domain.Member;
import com.wallmart.prova.repo.MemberDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml",
"classpath:/META-INF/spring/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class MemberDaoTest
{
    @Autowired
    private MemberDao memberDao;

    @Test
    public void testFindById()
    {
        Member member = memberDao.findById(0l);

        Assert.assertEquals("Joao Da Silva", member.getName());
        Assert.assertEquals("joao@silva.com.br", member.getEmail());
        Assert.assertEquals("2323122122", member.getPhoneNumber());
        Assert.assertEquals("prova", member.getPassword());
        return;
    }

    @Test
    public void testFindByEmail()
    {
        Member member = memberDao.findByEmail("joao@silva.com.br");

        Assert.assertEquals("Joao Da Silva", member.getName());
        Assert.assertEquals("joao@silva.com.br", member.getEmail());
        Assert.assertEquals("2323122122", member.getPhoneNumber());
        Assert.assertEquals("prova", member.getPassword());
        return;
    }

    @Test
    public void testRegister()
    {
        Member member = new Member();
        member.setEmail("joana@louca.com.br");
        member.setName("Joana Louca");
        member.setPhoneNumber("2125552121");
        member.setPassword("senha");
        
        Member newMember = memberDao.register(member);
        Long id = newMember.getId();
        Assert.assertNotNull(id);
        
        Assert.assertEquals(2, memberDao.findAllOrderedByName().size());
        Member newMember2 = memberDao.findById(id);

        Assert.assertEquals("Joana Louca", newMember2.getName());
        Assert.assertEquals("joana@louca.com.br", newMember2.getEmail());
        Assert.assertEquals("2125552121", newMember2.getPhoneNumber());
        Assert.assertEquals("senha", newMember2.getPassword());
        return;
    }

    @Test
    public void testFindAllOrderedByName()
    {
        Member member = new Member();
        member.setEmail("joana@louca.com.br");
        member.setName("Joana Louca");
        member.setPhoneNumber("2125552121");
        member.setPassword("senha");
        memberDao.register(member);

        List<Member> members = memberDao.findAllOrderedByName();
        Assert.assertEquals(2, members.size());
        Member newMember = members.get(0);

        Assert.assertEquals("Joana Louca", newMember.getName());
        Assert.assertEquals("joana@louca.com.br", newMember.getEmail());
        Assert.assertEquals("2125552121", newMember.getPhoneNumber());
        Assert.assertEquals("senha", newMember.getPassword());
        return;
    }
}

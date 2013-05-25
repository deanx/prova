package com.wallmart.prova.mvc;

 import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wallmart.prova.domain.Member;
import com.wallmart.prova.domain.MemberRole;
import com.wallmart.prova.repo.MemberDao;
import com.wallmart.prova.repo.MemberRoleDao;

@Controller
@RequestMapping(value="/members")
public class MemberController
{
    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberRoleDao memberRoleDao;
    
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method=RequestMethod.GET)
    public String membrosByName(Model model)
    {
        model.addAttribute("newMember", new Member());
        model.addAttribute("members", memberDao.findAllOrderedByName());
        return "members";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(method=RequestMethod.POST, produces = "application/json")
    public @ResponseBody List<Member> registerNewMember(@RequestParam String role, @Valid @ModelAttribute("newMember") Member newMember, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
            Member member = memberDao.register(newMember);
            MemberRole roles = new MemberRole(member);
            roles.setMemberRole(role);
            memberRoleDao.register(roles);
            
        }

        return memberDao.findAllOrderedByName();
    }
}

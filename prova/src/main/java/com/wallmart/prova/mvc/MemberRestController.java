package com.wallmart.prova.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wallmart.prova.domain.Member;
import com.wallmart.prova.repo.MemberDao;

@Controller
@RequestMapping("/rest/members")
public class MemberRestController {
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Member> getAllMembers() {

		return memberDao.findAllOrderedByName();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Member membroById(@PathVariable("id") Long id) {
		return memberDao.findById(id);
	}
}

package com.wallmart.prova.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MemberRole")
public class MemberRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public MemberRole(Member member) {
		this.memberId = member.getId();
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	
	@Column(name="member_id")
	private Long memberId;
	
	@Column(name="member_role")
	private String memberRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}
}

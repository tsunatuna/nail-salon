package com.project.nail.domain.entity.loginuser.custom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_user")
public class MLoginUser implements java.io.Serializable {

	@Id
	@Column(name="user_id")
	private String loginUserId;
	@Column(name="password")
	private String password;

	public MLoginUser() {
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
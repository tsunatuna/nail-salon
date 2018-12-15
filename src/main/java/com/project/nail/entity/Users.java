package com.project.nail.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import com.project.nail.service.user.MyUserDetail;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class Users {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Integer id;

	@Column(name="login_id")
	protected String loginId;

	@Column(name="display_name")
	protected String name;

	@Column(name="password")
	protected String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected List<Authorities> authorities;

	/**
	* {@link UserDetails}に変換します。
	* @return
	*/
	public UserDetails toMyUserDetail() {
		return MyUserDetail.create(this);
	}

}

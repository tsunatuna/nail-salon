package com.project.nail.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.nail.entity.type.AuthoritiesId;

import lombok.Data;

@Data
@Entity
@Table(name="authorities")
public class Authorities {

	@Id
	private AuthoritiesId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Users user;

	public Authorities() {
	}

	/** コンストラクタ */
	public Authorities(AuthoritiesId id){
		this.id = id;
	}
}
package com.project.nail.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

/**
 * DB共通Entity
 */
@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {

	/** 登録日 */
	private Date createdDate;
	/** 更新日 */
	private Date updatedDate;
	/** 削除フラグ */
	private int isDeleted;

	/**
	 * 登録前
	 */
	@PrePersist
	public void prePersist() {
		Date date = new Date();
		createdDate = date;
		updatedDate = date;
		isDeleted = 0;
	}

	/**
	 * 更新前
	 */
	@PreUpdate
	public void preUpdate() {
		Date date = new Date();
		updatedDate = date;
	}
}

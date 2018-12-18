package com.project.nail.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 予約情報エンティティ
 * @author igaguri
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class TrnReserves extends AbstractEntity implements Serializable {

	@Id
	/** 予約ID */
	private String reservedId;
	/** デザインID */
	private String designId;
	/** ユーザID */
	private int userId;
	/** 予約日 */
	private Date reservedDate;
	/** 予約開始時間 */
	private Time reservedTime;

	/**
	 * コンストラクタ
	 */
	public TrnReserves() {

	}

	public TrnReserves(String reservedId, String designId, int userId, Date reservedDate, Time reservedTime) {
		this.reservedId = reservedId;
		this.designId = designId;
		this.userId = userId;
		this.reservedDate = reservedDate;
		this.reservedTime = reservedTime;
	}
}

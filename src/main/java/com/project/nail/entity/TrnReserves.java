package com.project.nail.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TrnReserves {

	@Id
	// 予約ID
	private String reservedId;
	// デザインID
	private String designId;
	// ユーザID
	private int userId;
	// 予約日
	private Date reservedDate;
	// 予約開始時間
	private Time reservedStartTime;
	//予約終了時間
	private Time reservedEndTime;
	//登録日時
	private Timestamp createdDate;
	// 更新日時
	private Timestamp updatedDate;
	// 削除フラグ
	private int isDeleted;
}

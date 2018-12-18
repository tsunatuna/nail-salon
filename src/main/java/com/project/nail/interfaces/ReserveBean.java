package com.project.nail.interfaces;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import lombok.Data;

@Data
public class ReserveBean implements Serializable {
	/** 予約ID */
	private String reservedId;
	/** デザインID */
	private String designId;
	/** 予約日 */
	private Date reservedDate;
	/** 予約開始時間 */
	private Time reservedTime;
}

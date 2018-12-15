package com.project.nail.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Reserve {
	@Id
	private String id;
	private int userId;
	private Date reservedDate;
	private Date reservedTime;
	private int deleteFlg;
}

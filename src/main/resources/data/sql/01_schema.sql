DROP TABLE IF EXISTS NAILSALON.HIBERNATE_SEQUENCE

CREATE TABLE IF NOT EXISTS NAILSALON.USERS (
  USER_ID INT AUTO_INCREMENT COMMENT 'ユーザID',
  LOGIN_ID VARCHAR(256) COMMENT 'ログインID',
  PASSWORD VARCHAR(256) COMMENT 'パスワード',
  DISPLAY_NAME VARCHAR(255) COMMENT '表示用ユーザ名',
  ENABLED BOOLEAN COMMENT 'ユーザ有効有無フラグ',
  PRIMARY KEY(USER_ID)
)
DEFAULT CHARSET=UTF8
COMMENT='ユーザ情報マスタ';

CREATE TABLE IF NOT EXISTS NAILSALON.AUTHORITIES (
  USER_ID INT COMMENT 'ユーザID',
  AUTHORITY VARCHAR(256) COMMENT '権限',
  FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
)
DEFAULT CHARSET=UTF8
COMMENT='権限情報マスタ';

CREATE TABLE IF NOT EXISTS NAILSALON.RESERVE (
  ID VARCHAR(20) COMMENT '予約番号',
  USER_ID INT COMMENT 'ユーザID',
  RESERVED_DATE DATE COMMENT '予約日',
  RESERVED_TIME TIME COMMENT '予約時間',
  DELETE_FLG INT(1) DEFAULT 0 COMMENT '削除フラグ',
  PRIMARY KEY(ID)
)
DEFAULT CHARSET=UTF8
COMMENT='予約情報';

INSERT INTO ROLES (ROLE_NAME) VALUES('ROLE1');
INSERT INTO ROLES (ROLE_NAME) VALUES('ROLE2');
INSERT INTO ROLES (ROLE_NAME) VALUES('ROLE3');

INSERT INTO USERS (ID_ROLE, LOGIN, PASSWORD, EMAIL, CELL)
  VALUES(1, 'LOGIN1', 'PASSWORD1', 'EMAIL1', 'CELL1');
INSERT INTO USERS (ID_ROLE, LOGIN, PASSWORD, EMAIL, CELL)
  VALUES(1, 'LOGIN2', 'PASSWORD2', 'EMAIL2', 'CELL2');
INSERT INTO USERS (ID_ROLE, LOGIN, PASSWORD, EMAIL, CELL)
  VALUES(1, 'LOGIN3', 'PASSWORD3', 'EMAIL3', 'CELL3');
INSERT INTO USERS (ID_ROLE, LOGIN, PASSWORD, EMAIL, CELL)
  VALUES(2, 'LOGIN4', 'PASSWORD4', 'EMAIL4', 'CELL4');
INSERT INTO USERS (ID_ROLE, LOGIN, PASSWORD, EMAIL, CELL)
  VALUES(2, 'LOGIN5', 'PASSWORD5', 'EMAIL5', 'CELL5');
INSERT INTO USERS (ID_ROLE, LOGIN, PASSWORD, EMAIL, CELL)
  VALUES(2, 'LOGIN6', 'PASSWORD6', 'EMAIL6', 'CELL6');


INSERT INTO CLIENT (ID_USER, FIRST_NAME, LAST_NAME)
  VALUES(1, 'CLIENT_FIRST_NAME1', 'CLIENT_LAST_NAME1');
INSERT INTO CLIENT (ID_USER, FIRST_NAME, LAST_NAME)
  VALUES(2, 'CLIENT_FIRST_NAME2', 'CLIENT_LAST_NAME2');
INSERT INTO CLIENT (ID_USER, FIRST_NAME, LAST_NAME)
  VALUES(3, 'CLIENT_FIRST_NAME3', 'CLIENT_LAST_NAME3');

INSERT INTO TRIP_PROVIDER (ID_USER, TP_NAME)
  VALUES(4, 'TP_NAME1');
INSERT INTO TRIP_PROVIDER (ID_USER, TP_NAME)
  VALUES(5, 'TP_NAME2');
INSERT INTO TRIP_PROVIDER (ID_USER, TP_NAME)
  VALUES(6, 'TP_NAME3');

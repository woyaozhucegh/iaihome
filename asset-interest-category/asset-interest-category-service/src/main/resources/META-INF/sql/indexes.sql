create index IX_1A161533 on IAIHOME_Interestcategory (userId, groupId);
create index IX_403E1AD1 on IAIHOME_Interestcategory (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D5812193 on IAIHOME_Interestcategory (uuid_[$COLUMN_LENGTH:75$], groupId);
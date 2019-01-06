create table IAIHOME_Interestcategory (
	uuid_ VARCHAR(75) null,
	interestCategoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);
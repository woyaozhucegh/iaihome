/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.asset.interest.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.interest.model.Interestcategory;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Interestcategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Interestcategory
 * @generated
 */
@ProviderType
public class InterestcategoryCacheModel implements CacheModel<Interestcategory>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InterestcategoryCacheModel)) {
			return false;
		}

		InterestcategoryCacheModel interestcategoryCacheModel = (InterestcategoryCacheModel)obj;

		if (interestCategoryId == interestcategoryCacheModel.interestCategoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, interestCategoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", interestCategoryId=");
		sb.append(interestCategoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Interestcategory toEntityModel() {
		InterestcategoryImpl interestcategoryImpl = new InterestcategoryImpl();

		if (uuid == null) {
			interestcategoryImpl.setUuid("");
		}
		else {
			interestcategoryImpl.setUuid(uuid);
		}

		interestcategoryImpl.setInterestCategoryId(interestCategoryId);
		interestcategoryImpl.setGroupId(groupId);
		interestcategoryImpl.setCompanyId(companyId);
		interestcategoryImpl.setUserId(userId);

		if (userName == null) {
			interestcategoryImpl.setUserName("");
		}
		else {
			interestcategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			interestcategoryImpl.setCreateDate(null);
		}
		else {
			interestcategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			interestcategoryImpl.setModifiedDate(null);
		}
		else {
			interestcategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		interestcategoryImpl.resetOriginalValues();

		return interestcategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		interestCategoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(interestCategoryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long interestCategoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}
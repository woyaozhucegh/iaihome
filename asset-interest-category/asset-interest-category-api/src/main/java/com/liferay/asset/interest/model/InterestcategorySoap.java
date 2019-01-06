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

package com.liferay.asset.interest.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.asset.interest.service.http.InterestcategoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.asset.interest.service.http.InterestcategoryServiceSoap
 * @generated
 */
@ProviderType
public class InterestcategorySoap implements Serializable {
	public static InterestcategorySoap toSoapModel(Interestcategory model) {
		InterestcategorySoap soapModel = new InterestcategorySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setInterestCategoryId(model.getInterestCategoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static InterestcategorySoap[] toSoapModels(Interestcategory[] models) {
		InterestcategorySoap[] soapModels = new InterestcategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InterestcategorySoap[][] toSoapModels(
		Interestcategory[][] models) {
		InterestcategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InterestcategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new InterestcategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InterestcategorySoap[] toSoapModels(
		List<Interestcategory> models) {
		List<InterestcategorySoap> soapModels = new ArrayList<InterestcategorySoap>(models.size());

		for (Interestcategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InterestcategorySoap[soapModels.size()]);
	}

	public InterestcategorySoap() {
	}

	public long getPrimaryKey() {
		return _interestCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setInterestCategoryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getInterestCategoryId() {
		return _interestCategoryId;
	}

	public void setInterestCategoryId(long interestCategoryId) {
		_interestCategoryId = interestCategoryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _interestCategoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}
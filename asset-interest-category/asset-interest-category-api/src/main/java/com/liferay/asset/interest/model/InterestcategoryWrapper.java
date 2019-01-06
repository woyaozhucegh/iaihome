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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Interestcategory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Interestcategory
 * @generated
 */
@ProviderType
public class InterestcategoryWrapper implements Interestcategory,
	ModelWrapper<Interestcategory> {
	public InterestcategoryWrapper(Interestcategory interestcategory) {
		_interestcategory = interestcategory;
	}

	@Override
	public Class<?> getModelClass() {
		return Interestcategory.class;
	}

	@Override
	public String getModelClassName() {
		return Interestcategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("interestCategoryId", getInterestCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long interestCategoryId = (Long)attributes.get("interestCategoryId");

		if (interestCategoryId != null) {
			setInterestCategoryId(interestCategoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Object clone() {
		return new InterestcategoryWrapper((Interestcategory)_interestcategory.clone());
	}

	@Override
	public int compareTo(Interestcategory interestcategory) {
		return _interestcategory.compareTo(interestcategory);
	}

	/**
	* Returns the company ID of this interestcategory.
	*
	* @return the company ID of this interestcategory
	*/
	@Override
	public long getCompanyId() {
		return _interestcategory.getCompanyId();
	}

	/**
	* Returns the create date of this interestcategory.
	*
	* @return the create date of this interestcategory
	*/
	@Override
	public Date getCreateDate() {
		return _interestcategory.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _interestcategory.getExpandoBridge();
	}

	/**
	* Returns the group ID of this interestcategory.
	*
	* @return the group ID of this interestcategory
	*/
	@Override
	public long getGroupId() {
		return _interestcategory.getGroupId();
	}

	/**
	* Returns the interest category ID of this interestcategory.
	*
	* @return the interest category ID of this interestcategory
	*/
	@Override
	public long getInterestCategoryId() {
		return _interestcategory.getInterestCategoryId();
	}

	/**
	* Returns the modified date of this interestcategory.
	*
	* @return the modified date of this interestcategory
	*/
	@Override
	public Date getModifiedDate() {
		return _interestcategory.getModifiedDate();
	}

	/**
	* Returns the primary key of this interestcategory.
	*
	* @return the primary key of this interestcategory
	*/
	@Override
	public long getPrimaryKey() {
		return _interestcategory.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _interestcategory.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this interestcategory.
	*
	* @return the user ID of this interestcategory
	*/
	@Override
	public long getUserId() {
		return _interestcategory.getUserId();
	}

	/**
	* Returns the user name of this interestcategory.
	*
	* @return the user name of this interestcategory
	*/
	@Override
	public String getUserName() {
		return _interestcategory.getUserName();
	}

	/**
	* Returns the user uuid of this interestcategory.
	*
	* @return the user uuid of this interestcategory
	*/
	@Override
	public String getUserUuid() {
		return _interestcategory.getUserUuid();
	}

	/**
	* Returns the uuid of this interestcategory.
	*
	* @return the uuid of this interestcategory
	*/
	@Override
	public String getUuid() {
		return _interestcategory.getUuid();
	}

	@Override
	public int hashCode() {
		return _interestcategory.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _interestcategory.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _interestcategory.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _interestcategory.isNew();
	}

	@Override
	public void persist() {
		_interestcategory.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_interestcategory.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this interestcategory.
	*
	* @param companyId the company ID of this interestcategory
	*/
	@Override
	public void setCompanyId(long companyId) {
		_interestcategory.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this interestcategory.
	*
	* @param createDate the create date of this interestcategory
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_interestcategory.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_interestcategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_interestcategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_interestcategory.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this interestcategory.
	*
	* @param groupId the group ID of this interestcategory
	*/
	@Override
	public void setGroupId(long groupId) {
		_interestcategory.setGroupId(groupId);
	}

	/**
	* Sets the interest category ID of this interestcategory.
	*
	* @param interestCategoryId the interest category ID of this interestcategory
	*/
	@Override
	public void setInterestCategoryId(long interestCategoryId) {
		_interestcategory.setInterestCategoryId(interestCategoryId);
	}

	/**
	* Sets the modified date of this interestcategory.
	*
	* @param modifiedDate the modified date of this interestcategory
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_interestcategory.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_interestcategory.setNew(n);
	}

	/**
	* Sets the primary key of this interestcategory.
	*
	* @param primaryKey the primary key of this interestcategory
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_interestcategory.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_interestcategory.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this interestcategory.
	*
	* @param userId the user ID of this interestcategory
	*/
	@Override
	public void setUserId(long userId) {
		_interestcategory.setUserId(userId);
	}

	/**
	* Sets the user name of this interestcategory.
	*
	* @param userName the user name of this interestcategory
	*/
	@Override
	public void setUserName(String userName) {
		_interestcategory.setUserName(userName);
	}

	/**
	* Sets the user uuid of this interestcategory.
	*
	* @param userUuid the user uuid of this interestcategory
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_interestcategory.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this interestcategory.
	*
	* @param uuid the uuid of this interestcategory
	*/
	@Override
	public void setUuid(String uuid) {
		_interestcategory.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Interestcategory> toCacheModel() {
		return _interestcategory.toCacheModel();
	}

	@Override
	public Interestcategory toEscapedModel() {
		return new InterestcategoryWrapper(_interestcategory.toEscapedModel());
	}

	@Override
	public String toString() {
		return _interestcategory.toString();
	}

	@Override
	public Interestcategory toUnescapedModel() {
		return new InterestcategoryWrapper(_interestcategory.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _interestcategory.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InterestcategoryWrapper)) {
			return false;
		}

		InterestcategoryWrapper interestcategoryWrapper = (InterestcategoryWrapper)obj;

		if (Objects.equals(_interestcategory,
					interestcategoryWrapper._interestcategory)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _interestcategory.getStagedModelType();
	}

	@Override
	public Interestcategory getWrappedModel() {
		return _interestcategory;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _interestcategory.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _interestcategory.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_interestcategory.resetOriginalValues();
	}

	private final Interestcategory _interestcategory;
}
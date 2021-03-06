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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Interestcategory service. Represents a row in the &quot;IAIHOME_Interestcategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.asset.interest.model.impl.InterestcategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.asset.interest.model.impl.InterestcategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Interestcategory
 * @see com.liferay.asset.interest.model.impl.InterestcategoryImpl
 * @see com.liferay.asset.interest.model.impl.InterestcategoryModelImpl
 * @generated
 */
@ProviderType
public interface InterestcategoryModel extends BaseModel<Interestcategory>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a interestcategory model instance should use the {@link Interestcategory} interface instead.
	 */

	/**
	 * Returns the primary key of this interestcategory.
	 *
	 * @return the primary key of this interestcategory
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this interestcategory.
	 *
	 * @param primaryKey the primary key of this interestcategory
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this interestcategory.
	 *
	 * @return the uuid of this interestcategory
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this interestcategory.
	 *
	 * @param uuid the uuid of this interestcategory
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the interest category ID of this interestcategory.
	 *
	 * @return the interest category ID of this interestcategory
	 */
	public long getInterestCategoryId();

	/**
	 * Sets the interest category ID of this interestcategory.
	 *
	 * @param interestCategoryId the interest category ID of this interestcategory
	 */
	public void setInterestCategoryId(long interestCategoryId);

	/**
	 * Returns the group ID of this interestcategory.
	 *
	 * @return the group ID of this interestcategory
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this interestcategory.
	 *
	 * @param groupId the group ID of this interestcategory
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this interestcategory.
	 *
	 * @return the company ID of this interestcategory
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this interestcategory.
	 *
	 * @param companyId the company ID of this interestcategory
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this interestcategory.
	 *
	 * @return the user ID of this interestcategory
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this interestcategory.
	 *
	 * @param userId the user ID of this interestcategory
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this interestcategory.
	 *
	 * @return the user uuid of this interestcategory
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this interestcategory.
	 *
	 * @param userUuid the user uuid of this interestcategory
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this interestcategory.
	 *
	 * @return the user name of this interestcategory
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this interestcategory.
	 *
	 * @param userName the user name of this interestcategory
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this interestcategory.
	 *
	 * @return the create date of this interestcategory
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this interestcategory.
	 *
	 * @param createDate the create date of this interestcategory
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this interestcategory.
	 *
	 * @return the modified date of this interestcategory
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this interestcategory.
	 *
	 * @param modifiedDate the modified date of this interestcategory
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Interestcategory interestcategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Interestcategory> toCacheModel();

	@Override
	public Interestcategory toEscapedModel();

	@Override
	public Interestcategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
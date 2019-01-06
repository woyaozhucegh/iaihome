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

package com.liferay.asset.interest.service.impl;

import com.liferay.asset.interest.exception.NoSuchInterestcategoryException;
import com.liferay.asset.interest.model.Interestcategory;
import com.liferay.asset.interest.service.base.InterestcategoryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;



/**
 * The implementation of the interestcategory local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.asset.interest.service.InterestcategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterestcategoryLocalServiceBaseImpl
 * @see com.liferay.asset.interest.service.InterestcategoryLocalServiceUtil
 */
public class InterestcategoryLocalServiceImpl
	extends InterestcategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.asset.interest.service.InterestcategoryLocalServiceUtil} to access the interestcategory local service.
	 */
	public Interestcategory addInterestCategory(long userId, ServiceContext serviceContext)
		throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		long interestCategoryId = counterLocalService.increment();
		Interestcategory interestcategory = interestcategoryPersistence.create(interestCategoryId);
		interestcategory.setUuid(serviceContext.getUuid());
		interestcategory.setUserId(userId);
		interestcategory.setGroupId(groupId);
		interestcategory.setCompanyId(user.getCompanyId());
		interestcategory.setUserName(user.getFullName());
		interestcategory.setCreateDate(serviceContext.getCreateDate(now));
		interestcategory.setModifiedDate(serviceContext.getModifiedDate(now));
		interestcategory.setExpandoBridgeAttributes(serviceContext);
		
		interestcategoryPersistence.update(interestcategory);
		
		return interestcategory;
	}
	
	public Interestcategory updateInterestCategory(long userId, long interestCategoryId, ServiceContext serviceContext)
		throws PortalException, NoSuchInterestcategoryException {
		Date now = new Date();
		Interestcategory interestcategory = getInterestcategory(interestCategoryId);
		User user = userLocalService.getUserById(userId);
		interestcategory.setUserId(userId);
		interestcategory.setUserName(user.getFullName());
		interestcategory.setModifiedDate(serviceContext.getModifiedDate(now));
		interestcategory.setExpandoBridgeAttributes(serviceContext);
		interestcategoryPersistence.update(interestcategory);
		
		return interestcategory;
	}
	
	public Interestcategory deleteInterestCategory(long interestCategoryId, ServiceContext serviceContext)
		throws PortalException, NoSuchInterestcategoryException {
		Interestcategory interestcategory = getInterestcategory(interestCategoryId);
		interestcategory = deleteInterestcategory(interestCategoryId);
		
		return interestcategory;
	}
	
	public List<Interestcategory> getInterestCategories(long userId, long groupId, int start, int end)
		throws PortalException {
		return interestcategoryPersistence.findByU_G(userId, groupId, start, end);
	}
	
	public List<Interestcategory> getInterestCategories(long userId, long groupId, int start, int end, OrderByComparator<Interestcategory> obc)
			throws PortalException {
			return interestcategoryPersistence.findByU_G(userId, groupId, start, end, obc);
		}
	
	public int getInterestCategoriesCount(long userId, long groupId)
			throws PortalException {
			return interestcategoryPersistence.countByU_G(userId, groupId);
		}

}
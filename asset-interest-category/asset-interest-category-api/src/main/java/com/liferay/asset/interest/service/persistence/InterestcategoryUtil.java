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

package com.liferay.asset.interest.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.interest.model.Interestcategory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the interestcategory service. This utility wraps {@link com.liferay.asset.interest.service.persistence.impl.InterestcategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterestcategoryPersistence
 * @see com.liferay.asset.interest.service.persistence.impl.InterestcategoryPersistenceImpl
 * @generated
 */
@ProviderType
public class InterestcategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Interestcategory interestcategory) {
		getPersistence().clearCache(interestcategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Interestcategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Interestcategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Interestcategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Interestcategory update(Interestcategory interestcategory) {
		return getPersistence().update(interestcategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Interestcategory update(Interestcategory interestcategory,
		ServiceContext serviceContext) {
		return getPersistence().update(interestcategory, serviceContext);
	}

	/**
	* Returns all the interestcategories where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching interestcategories
	*/
	public static List<Interestcategory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the interestcategories where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @return the range of matching interestcategories
	*/
	public static List<Interestcategory> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the interestcategories where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching interestcategories
	*/
	public static List<Interestcategory> findByUuid(String uuid, int start,
		int end, OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the interestcategories where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching interestcategories
	*/
	public static List<Interestcategory> findByUuid(String uuid, int start,
		int end, OrderByComparator<Interestcategory> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first interestcategory in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interestcategory
	* @throws NoSuchInterestcategoryException if a matching interestcategory could not be found
	*/
	public static Interestcategory findByUuid_First(String uuid,
		OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first interestcategory in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static Interestcategory fetchByUuid_First(String uuid,
		OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last interestcategory in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interestcategory
	* @throws NoSuchInterestcategoryException if a matching interestcategory could not be found
	*/
	public static Interestcategory findByUuid_Last(String uuid,
		OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last interestcategory in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static Interestcategory fetchByUuid_Last(String uuid,
		OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the interestcategories before and after the current interestcategory in the ordered set where uuid = &#63;.
	*
	* @param interestCategoryId the primary key of the current interestcategory
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interestcategory
	* @throws NoSuchInterestcategoryException if a interestcategory with the primary key could not be found
	*/
	public static Interestcategory[] findByUuid_PrevAndNext(
		long interestCategoryId, String uuid,
		OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(interestCategoryId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the interestcategories where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of interestcategories where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching interestcategories
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the interestcategory where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchInterestcategoryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching interestcategory
	* @throws NoSuchInterestcategoryException if a matching interestcategory could not be found
	*/
	public static Interestcategory findByUUID_G(String uuid, long groupId)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the interestcategory where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static Interestcategory fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the interestcategory where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static Interestcategory fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the interestcategory where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the interestcategory that was removed
	*/
	public static Interestcategory removeByUUID_G(String uuid, long groupId)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of interestcategories where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching interestcategories
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the interestcategories where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching interestcategories
	*/
	public static List<Interestcategory> findByUuid_C(String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the interestcategories where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @return the range of matching interestcategories
	*/
	public static List<Interestcategory> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the interestcategories where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching interestcategories
	*/
	public static List<Interestcategory> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the interestcategories where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching interestcategories
	*/
	public static List<Interestcategory> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<Interestcategory> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first interestcategory in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interestcategory
	* @throws NoSuchInterestcategoryException if a matching interestcategory could not be found
	*/
	public static Interestcategory findByUuid_C_First(String uuid,
		long companyId, OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first interestcategory in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static Interestcategory fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last interestcategory in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interestcategory
	* @throws NoSuchInterestcategoryException if a matching interestcategory could not be found
	*/
	public static Interestcategory findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last interestcategory in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static Interestcategory fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the interestcategories before and after the current interestcategory in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param interestCategoryId the primary key of the current interestcategory
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interestcategory
	* @throws NoSuchInterestcategoryException if a interestcategory with the primary key could not be found
	*/
	public static Interestcategory[] findByUuid_C_PrevAndNext(
		long interestCategoryId, String uuid, long companyId,
		OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(interestCategoryId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the interestcategories where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of interestcategories where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching interestcategories
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the interestcategories where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching interestcategories
	*/
	public static List<Interestcategory> findByU_G(long userId, long groupId) {
		return getPersistence().findByU_G(userId, groupId);
	}

	/**
	* Returns a range of all the interestcategories where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @return the range of matching interestcategories
	*/
	public static List<Interestcategory> findByU_G(long userId, long groupId,
		int start, int end) {
		return getPersistence().findByU_G(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the interestcategories where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching interestcategories
	*/
	public static List<Interestcategory> findByU_G(long userId, long groupId,
		int start, int end,
		OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence()
				   .findByU_G(userId, groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the interestcategories where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching interestcategories
	*/
	public static List<Interestcategory> findByU_G(long userId, long groupId,
		int start, int end,
		OrderByComparator<Interestcategory> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_G(userId, groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first interestcategory in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interestcategory
	* @throws NoSuchInterestcategoryException if a matching interestcategory could not be found
	*/
	public static Interestcategory findByU_G_First(long userId, long groupId,
		OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence()
				   .findByU_G_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the first interestcategory in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static Interestcategory fetchByU_G_First(long userId, long groupId,
		OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence()
				   .fetchByU_G_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last interestcategory in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interestcategory
	* @throws NoSuchInterestcategoryException if a matching interestcategory could not be found
	*/
	public static Interestcategory findByU_G_Last(long userId, long groupId,
		OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence()
				   .findByU_G_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last interestcategory in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static Interestcategory fetchByU_G_Last(long userId, long groupId,
		OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence()
				   .fetchByU_G_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the interestcategories before and after the current interestcategory in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param interestCategoryId the primary key of the current interestcategory
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next interestcategory
	* @throws NoSuchInterestcategoryException if a interestcategory with the primary key could not be found
	*/
	public static Interestcategory[] findByU_G_PrevAndNext(
		long interestCategoryId, long userId, long groupId,
		OrderByComparator<Interestcategory> orderByComparator)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence()
				   .findByU_G_PrevAndNext(interestCategoryId, userId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the interestcategories where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	*/
	public static void removeByU_G(long userId, long groupId) {
		getPersistence().removeByU_G(userId, groupId);
	}

	/**
	* Returns the number of interestcategories where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching interestcategories
	*/
	public static int countByU_G(long userId, long groupId) {
		return getPersistence().countByU_G(userId, groupId);
	}

	/**
	* Caches the interestcategory in the entity cache if it is enabled.
	*
	* @param interestcategory the interestcategory
	*/
	public static void cacheResult(Interestcategory interestcategory) {
		getPersistence().cacheResult(interestcategory);
	}

	/**
	* Caches the interestcategories in the entity cache if it is enabled.
	*
	* @param interestcategories the interestcategories
	*/
	public static void cacheResult(List<Interestcategory> interestcategories) {
		getPersistence().cacheResult(interestcategories);
	}

	/**
	* Creates a new interestcategory with the primary key. Does not add the interestcategory to the database.
	*
	* @param interestCategoryId the primary key for the new interestcategory
	* @return the new interestcategory
	*/
	public static Interestcategory create(long interestCategoryId) {
		return getPersistence().create(interestCategoryId);
	}

	/**
	* Removes the interestcategory with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interestCategoryId the primary key of the interestcategory
	* @return the interestcategory that was removed
	* @throws NoSuchInterestcategoryException if a interestcategory with the primary key could not be found
	*/
	public static Interestcategory remove(long interestCategoryId)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence().remove(interestCategoryId);
	}

	public static Interestcategory updateImpl(Interestcategory interestcategory) {
		return getPersistence().updateImpl(interestcategory);
	}

	/**
	* Returns the interestcategory with the primary key or throws a {@link NoSuchInterestcategoryException} if it could not be found.
	*
	* @param interestCategoryId the primary key of the interestcategory
	* @return the interestcategory
	* @throws NoSuchInterestcategoryException if a interestcategory with the primary key could not be found
	*/
	public static Interestcategory findByPrimaryKey(long interestCategoryId)
		throws com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getPersistence().findByPrimaryKey(interestCategoryId);
	}

	/**
	* Returns the interestcategory with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param interestCategoryId the primary key of the interestcategory
	* @return the interestcategory, or <code>null</code> if a interestcategory with the primary key could not be found
	*/
	public static Interestcategory fetchByPrimaryKey(long interestCategoryId) {
		return getPersistence().fetchByPrimaryKey(interestCategoryId);
	}

	public static java.util.Map<java.io.Serializable, Interestcategory> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the interestcategories.
	*
	* @return the interestcategories
	*/
	public static List<Interestcategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the interestcategories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @return the range of interestcategories
	*/
	public static List<Interestcategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the interestcategories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of interestcategories
	*/
	public static List<Interestcategory> findAll(int start, int end,
		OrderByComparator<Interestcategory> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the interestcategories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of interestcategories
	*/
	public static List<Interestcategory> findAll(int start, int end,
		OrderByComparator<Interestcategory> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the interestcategories from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of interestcategories.
	*
	* @return the number of interestcategories
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static InterestcategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InterestcategoryPersistence, InterestcategoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InterestcategoryPersistence.class);

		ServiceTracker<InterestcategoryPersistence, InterestcategoryPersistence> serviceTracker =
			new ServiceTracker<InterestcategoryPersistence, InterestcategoryPersistence>(bundle.getBundleContext(),
				InterestcategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
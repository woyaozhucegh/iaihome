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

package com.liferay.asset.interest.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Interestcategory. This utility wraps
 * {@link com.liferay.asset.interest.service.impl.InterestcategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see InterestcategoryLocalService
 * @see com.liferay.asset.interest.service.base.InterestcategoryLocalServiceBaseImpl
 * @see com.liferay.asset.interest.service.impl.InterestcategoryLocalServiceImpl
 * @generated
 */
@ProviderType
public class InterestcategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.asset.interest.service.impl.InterestcategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the interestcategory to the database. Also notifies the appropriate model listeners.
	*
	* @param interestcategory the interestcategory
	* @return the interestcategory that was added
	*/
	public static com.liferay.asset.interest.model.Interestcategory addInterestcategory(
		com.liferay.asset.interest.model.Interestcategory interestcategory) {
		return getService().addInterestcategory(interestcategory);
	}

	public static com.liferay.asset.interest.model.Interestcategory addInterestCategory(
		long userId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addInterestCategory(userId, serviceContext);
	}

	/**
	* Creates a new interestcategory with the primary key. Does not add the interestcategory to the database.
	*
	* @param interestCategoryId the primary key for the new interestcategory
	* @return the new interestcategory
	*/
	public static com.liferay.asset.interest.model.Interestcategory createInterestcategory(
		long interestCategoryId) {
		return getService().createInterestcategory(interestCategoryId);
	}

	/**
	* Deletes the interestcategory from the database. Also notifies the appropriate model listeners.
	*
	* @param interestcategory the interestcategory
	* @return the interestcategory that was removed
	*/
	public static com.liferay.asset.interest.model.Interestcategory deleteInterestcategory(
		com.liferay.asset.interest.model.Interestcategory interestcategory) {
		return getService().deleteInterestcategory(interestcategory);
	}

	/**
	* Deletes the interestcategory with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interestCategoryId the primary key of the interestcategory
	* @return the interestcategory that was removed
	* @throws PortalException if a interestcategory with the primary key could not be found
	*/
	public static com.liferay.asset.interest.model.Interestcategory deleteInterestcategory(
		long interestCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteInterestcategory(interestCategoryId);
	}

	public static com.liferay.asset.interest.model.Interestcategory deleteInterestCategory(
		long interestCategoryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getService()
				   .deleteInterestCategory(interestCategoryId, serviceContext);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.asset.interest.model.impl.InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.asset.interest.model.impl.InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.asset.interest.model.Interestcategory fetchInterestcategory(
		long interestCategoryId) {
		return getService().fetchInterestcategory(interestCategoryId);
	}

	/**
	* Returns the interestcategory matching the UUID and group.
	*
	* @param uuid the interestcategory's UUID
	* @param groupId the primary key of the group
	* @return the matching interestcategory, or <code>null</code> if a matching interestcategory could not be found
	*/
	public static com.liferay.asset.interest.model.Interestcategory fetchInterestcategoryByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchInterestcategoryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns a range of all the interestcategories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.asset.interest.model.impl.InterestcategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @return the range of interestcategories
	*/
	public static java.util.List<com.liferay.asset.interest.model.Interestcategory> getInterestcategories(
		int start, int end) {
		return getService().getInterestcategories(start, end);
	}

	public static java.util.List<com.liferay.asset.interest.model.Interestcategory> getInterestCategories(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getInterestCategories(userId, groupId, start, end);
	}

	public static java.util.List<com.liferay.asset.interest.model.Interestcategory> getInterestCategories(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.interest.model.Interestcategory> obc)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getInterestCategories(userId, groupId, start, end, obc);
	}

	/**
	* Returns all the interestcategories matching the UUID and company.
	*
	* @param uuid the UUID of the interestcategories
	* @param companyId the primary key of the company
	* @return the matching interestcategories, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.asset.interest.model.Interestcategory> getInterestcategoriesByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService()
				   .getInterestcategoriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of interestcategories matching the UUID and company.
	*
	* @param uuid the UUID of the interestcategories
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of interestcategories
	* @param end the upper bound of the range of interestcategories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching interestcategories, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.asset.interest.model.Interestcategory> getInterestcategoriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.interest.model.Interestcategory> orderByComparator) {
		return getService()
				   .getInterestcategoriesByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of interestcategories.
	*
	* @return the number of interestcategories
	*/
	public static int getInterestcategoriesCount() {
		return getService().getInterestcategoriesCount();
	}

	public static int getInterestCategoriesCount(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getInterestCategoriesCount(userId, groupId);
	}

	/**
	* Returns the interestcategory with the primary key.
	*
	* @param interestCategoryId the primary key of the interestcategory
	* @return the interestcategory
	* @throws PortalException if a interestcategory with the primary key could not be found
	*/
	public static com.liferay.asset.interest.model.Interestcategory getInterestcategory(
		long interestCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getInterestcategory(interestCategoryId);
	}

	/**
	* Returns the interestcategory matching the UUID and group.
	*
	* @param uuid the interestcategory's UUID
	* @param groupId the primary key of the group
	* @return the matching interestcategory
	* @throws PortalException if a matching interestcategory could not be found
	*/
	public static com.liferay.asset.interest.model.Interestcategory getInterestcategoryByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getInterestcategoryByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the interestcategory in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interestcategory the interestcategory
	* @return the interestcategory that was updated
	*/
	public static com.liferay.asset.interest.model.Interestcategory updateInterestcategory(
		com.liferay.asset.interest.model.Interestcategory interestcategory) {
		return getService().updateInterestcategory(interestcategory);
	}

	public static com.liferay.asset.interest.model.Interestcategory updateInterestCategory(
		long userId, long interestCategoryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.asset.interest.exception.NoSuchInterestcategoryException {
		return getService()
				   .updateInterestCategory(userId, interestCategoryId,
			serviceContext);
	}

	public static InterestcategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InterestcategoryLocalService, InterestcategoryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InterestcategoryLocalService.class);

		ServiceTracker<InterestcategoryLocalService, InterestcategoryLocalService> serviceTracker =
			new ServiceTracker<InterestcategoryLocalService, InterestcategoryLocalService>(bundle.getBundleContext(),
				InterestcategoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
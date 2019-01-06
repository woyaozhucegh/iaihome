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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InterestcategoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see InterestcategoryService
 * @generated
 */
@ProviderType
public class InterestcategoryServiceWrapper implements InterestcategoryService,
	ServiceWrapper<InterestcategoryService> {
	public InterestcategoryServiceWrapper(
		InterestcategoryService interestcategoryService) {
		_interestcategoryService = interestcategoryService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _interestcategoryService.getOSGiServiceIdentifier();
	}

	@Override
	public InterestcategoryService getWrappedService() {
		return _interestcategoryService;
	}

	@Override
	public void setWrappedService(
		InterestcategoryService interestcategoryService) {
		_interestcategoryService = interestcategoryService;
	}

	private InterestcategoryService _interestcategoryService;
}
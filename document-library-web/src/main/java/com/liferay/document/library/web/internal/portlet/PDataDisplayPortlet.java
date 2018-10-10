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

package com.liferay.document.library.web.internal.portlet;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.document.library.web.internal.constants.DLWebKeys;
import com.liferay.portal.kernel.model.Release;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.application-type=full-page-application",
		"com.liferay.portlet.application-type=widget",
		"com.liferay.portlet.autopropagated-parameters=showMountFolder",
		"com.liferay.portlet.css-class-wrapper=portlet-products-data-display",
		"com.liferay.portlet.display-category=category.cms",
		"com.liferay.portlet.display-category=category.highlighted",
		"com.liferay.portlet.header-portlet-css=/products_data_display/css/productCarousel.css",
		"com.liferay.portlet.header-portlet-css=/products_data_display/css/bootstrap-fileinput.css",
		"com.liferay.portlet.header-portlet-css=/products_data_display/css/main.css",		
		"com.liferay.portlet.footer-portlet-javascript=/products_data_display/js/bootstrap-fileinput.js",
		"com.liferay.portlet.footer-portlet-javascript=/products_data_display/js/main.js",
		"com.liferay.portlet.footer-portlet-javascript=/products_data_display/js/upload.js",
		"com.liferay.portlet.icon=/products_data_display/icons/document_library.png",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.struts-path=document_library",
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.webdav-storage-token=document_library",
		"javax.portlet.display-name=Products data display",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.always-display-default-configuration-icons=true",
		"javax.portlet.init-param.portlet-title-based-navigation=false",
		"javax.portlet.init-param.single-page-application-cacheable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + DLWebKeys.PRODUCTS_DATA_DISPLAY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user",
		"javax.portlet.supported-public-render-parameter=categoryId",
		"javax.portlet.supported-public-render-parameter=resetCur",
		"javax.portlet.supported-public-render-parameter=tag",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class PDataDisplayPortlet extends MVCPortlet {

	@Reference(
		target = "(&(release.bundle.symbolic.name=com.liferay.document.library.web)(release.schema.version=1.0.0))",
		unbind = "-"
	)
	protected void setRelease(Release release) {
	}

}
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

package com.liferay.document.library.web.internal.display.context;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.document.library.web.internal.constants.DLWebKeys;
import com.liferay.document.library.web.internal.display.context.util.DLRequestHelper;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webdav.WebDAVUtil;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alejandro Tardín
 */
public class DLAdminNavigationDisplayContext {

	public DLAdminNavigationDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;

		_currentURLObj = PortletURLUtil.getCurrent(
			liferayPortletRequest, liferayPortletResponse);
		_request = liferayPortletRequest.getHttpServletRequest();

		_dlRequestHelper = new DLRequestHelper(_request);

		_themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public List<NavigationItem> getNavigationItems() {
		String mvcRenderCommandName = ParamUtil.getString(
			_liferayPortletRequest, "mvcRenderCommandName",
			"/document_library/view");

		return new NavigationItemList() {
			{
				add(
					navigationItem -> {
						_populateDocumentLibraryNavigationItem(
							navigationItem, mvcRenderCommandName);
					});

				if (DLPortletKeys.DOCUMENT_LIBRARY_ADMIN.equals(
						_dlRequestHelper.getPortletName())) {

					add(
						navigationItem -> {
							_populateFileEntryTypesNavigationItem(
								navigationItem, mvcRenderCommandName);
						});

					add(
						DLAdminNavigationDisplayContext.this
							::_populateMetadataSetsNavigationItem);
				}
			}
		};
	}

	private Portlet _getPortlet(ThemeDisplay themeDisplay) {
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		return PortletLocalServiceUtil.getPortletById(portletDisplay.getId());
	}

	private void _populateDocumentLibraryNavigationItem(
		NavigationItem navigationItem, String mvcRenderCommandName) {

		navigationItem.setActive(
			!mvcRenderCommandName.equals(
				"/document_library/view_file_entry_types"));

		PortletURL viewDocumentLibraryURL =
			_liferayPortletResponse.createRenderURL();

		viewDocumentLibraryURL.setParameter(
			"mvcRenderCommandName", "/document_library/view");
		viewDocumentLibraryURL.setParameter(
			"redirect", _currentURLObj.toString());

		navigationItem.setHref(viewDocumentLibraryURL.toString());

		navigationItem.setLabel(
			LanguageUtil.get(
				_liferayPortletRequest.getHttpServletRequest(),
				"documents-and-media"));
	}

	private void _populateFileEntryTypesNavigationItem(
		NavigationItem navigationItem, String mvcRenderCommandName) {

		navigationItem.setActive(
			mvcRenderCommandName.equals(
				"/document_library/view_file_entry_types"));

		PortletURL viewFileEntryTypesURL =
			_liferayPortletResponse.createRenderURL();

		viewFileEntryTypesURL.setParameter(
			"mvcRenderCommandName", "/document_library/view_file_entry_types");
		viewFileEntryTypesURL.setParameter(
			"redirect", _currentURLObj.toString());

		navigationItem.setHref(viewFileEntryTypesURL.toString());

		navigationItem.setLabel(
			LanguageUtil.get(
				_liferayPortletRequest.getHttpServletRequest(),
				"document-types"));
	}

	private void _populateMetadataSetsNavigationItem(
		NavigationItem navigationItem) {

		navigationItem.setActive(false);

		Portlet portlet = _getPortlet(_themeDisplay);

		PortletURL viewMetadataSetsURL = PortletURLFactoryUtil.create(
			_liferayPortletRequest,
			PortletProviderUtil.getPortletId(
				DDMStructure.class.getName(), PortletProvider.Action.VIEW),
			PortletRequest.RENDER_PHASE);

		viewMetadataSetsURL.setParameter("mvcPath", "/view.jsp");
		viewMetadataSetsURL.setParameter(
			"backURL", _themeDisplay.getURLCurrent());
		viewMetadataSetsURL.setParameter(
			"groupId", String.valueOf(_themeDisplay.getScopeGroupId()));
		//------------Tiamo------------------
		String portletName = _liferayPortletRequest.getPortletName();
		if (portletName.equals(DLWebKeys.PRODUCTS_DATA_DISPLAY)) {
			viewMetadataSetsURL.setParameter(
				"refererPortletName", DLWebKeys.PRODUCTS_DATA_DISPLAY);
		}else {
			viewMetadataSetsURL.setParameter(
				"refererPortletName", DLPortletKeys.DOCUMENT_LIBRARY);
		}
		viewMetadataSetsURL.setParameter(
			"refererWebDAVToken", WebDAVUtil.getStorageToken(portlet));
		viewMetadataSetsURL.setParameter(
			"showAncestorScopes", Boolean.TRUE.toString());
		viewMetadataSetsURL.setParameter(
			"showManageTemplates", Boolean.FALSE.toString());

		navigationItem.setHref(viewMetadataSetsURL.toString());

		navigationItem.setLabel(
			LanguageUtil.get(
				_liferayPortletRequest.getHttpServletRequest(),
				"metadata-sets"));
	}

	private final PortletURL _currentURLObj;
	private final DLRequestHelper _dlRequestHelper;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final HttpServletRequest _request;
	private final ThemeDisplay _themeDisplay;

}
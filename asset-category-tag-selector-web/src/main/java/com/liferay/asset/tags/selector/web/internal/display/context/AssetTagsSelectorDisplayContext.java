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

package com.liferay.asset.tags.selector.web.internal.display.context;

import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetTagServiceUtil;
import com.liferay.asset.tags.selector.web.internal.search.EntriesChecker;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.asset.util.comparator.AssetTagNameComparator;

import java.util.List;
import java.util.Objects;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class AssetTagsSelectorDisplayContext {

	public AssetTagsSelectorDisplayContext(
		RenderRequest renderRequest, RenderResponse renderResponse,
		HttpServletRequest request) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_request = request;
	}

	public String getClearResultsURL() {
		PortletURL clearResultsURL = _getPortletURL();

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	public String getEventName() {
		if (Validator.isNotNull(_eventName)) {
			return _eventName;
		}

		_eventName = ParamUtil.getString(
			_request, "eventName",
			_renderResponse.getNamespace() + "selectTag");

		return _eventName;
	}

	public List<DropdownItem> getFilterItemsDropdownItems() {
		return new DropdownItemList() {
			{
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							_getFilterNavigationDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(_request, "filter-by-navigation"));
					});

				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							_getOrderByDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(_request, "order-by"));
					});
			}
		};
	}

	public String getOrderByType() {
		if (Validator.isNotNull(_orderByType)) {
			return _orderByType;
		}

		_orderByType = ParamUtil.getString(_request, "orderByType", "asc");

		return _orderByType;
	}

	public String getSearchActionURL() {
		PortletURL searchActionURL = _getPortletURL();

		return searchActionURL.toString();
	}

	public String[] getSelectedTagNames() {
		if (ArrayUtil.isNotEmpty(_selectedTagNames)) {
			return _selectedTagNames;
		}

		_selectedTagNames = ParamUtil.getStringValues(
			_renderRequest, "selectedTagNames");

		return _selectedTagNames;
	}

	public String getSortingURL() {
		PortletURL sortingURL = _getPortletURL();

		sortingURL.setParameter(
			"orderByType",
			Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

		return sortingURL.toString();
	}

	public SearchContainer getTagsSearchContainer() {
		if (_tagsSearchContainer != null) {
			return _tagsSearchContainer;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		SearchContainer tagsSearchContainer = new SearchContainer(
			_renderRequest, _getPortletURL(), null, "there-are-no-tags");

		String orderByCol = _getOrderByCol();

		tagsSearchContainer.setOrderByCol(orderByCol);

		boolean orderByAsc = false;

		String orderByType = getOrderByType();

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		tagsSearchContainer.setOrderByComparator(
			new AssetTagNameComparator(orderByAsc));

		tagsSearchContainer.setOrderByType(orderByType);

		tagsSearchContainer.setRowChecker(
			new EntriesChecker(_renderRequest, _renderResponse));

		int tagsCount = AssetTagServiceUtil.getTagsCount(
			themeDisplay.getScopeGroupId(), _getKeywords());

		tagsSearchContainer.setTotal(tagsCount);

		List<AssetTag> tags = AssetTagServiceUtil.getTags(
			_getGroupIds(), _getKeywords(), tagsSearchContainer.getStart(),
			tagsSearchContainer.getEnd(),
			tagsSearchContainer.getOrderByComparator());

		tagsSearchContainer.setResults(tags);

		_tagsSearchContainer = tagsSearchContainer;

		return _tagsSearchContainer;
	}

	public int getTotalItems() {
		SearchContainer tagsSearchContainer = getTagsSearchContainer();

		return tagsSearchContainer.getTotal();
	}

	public boolean isDisabledTagsManagementBar() {
		SearchContainer tagsSearchContainer = getTagsSearchContainer();

		if (tagsSearchContainer.getTotal() <= 0) {
			return true;
		}

		return false;
	}

	public boolean isShowTagsSearch() {
		if (Validator.isNotNull(_getKeywords())) {
			return true;
		}

		SearchContainer tagsSearchContainer = getTagsSearchContainer();

		if (tagsSearchContainer.getTotal() > 0) {
			return true;
		}

		return false;
	}

	private List<DropdownItem> _getFilterNavigationDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setActive(true);
						dropdownItem.setHref(_getPortletURL());
						dropdownItem.setLabel(
							LanguageUtil.get(_request, "all"));
					});
			}
		};
	}

	private long[] _getGroupIds() {
		if (ArrayUtil.isNotEmpty(_groupIds)) {
			return _groupIds;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_groupIds = StringUtil.split(
			ParamUtil.getString(_request, "groupIds"), 0L);

		if (ArrayUtil.isEmpty(_groupIds)) {
			_groupIds = new long[] {themeDisplay.getScopeGroupId()};
		}

		return _groupIds;
	}

	private String _getKeywords() {
		if (Validator.isNotNull(_keywords)) {
			return _keywords;
		}

		_keywords = ParamUtil.getString(_request, "keywords", null);

		return _keywords;
	}

	private String _getOrderByCol() {
		if (Validator.isNotNull(_orderByCol)) {
			return _orderByCol;
		}

		_orderByCol = ParamUtil.getString(_request, "orderByCol", "name");

		return _orderByCol;
	}

	private List<DropdownItem> _getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setActive(true);
						dropdownItem.setHref(
							_getPortletURL(), "orderByCol", "name");
						dropdownItem.setLabel(
							LanguageUtil.get(_request, "name"));
					});
			}
		};
	}

	private PortletURL _getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("eventName", getEventName());
		portletURL.setParameter(
			"selectedTagNames", StringUtil.merge(getSelectedTagNames()));

		return portletURL;
	}

	private String _displayStyle;
	private String _eventName;
	private long[] _groupIds;
	private String _keywords;
	private String _orderByCol;
	private String _orderByType;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private final HttpServletRequest _request;
	private String[] _selectedTagNames;
	private SearchContainer _tagsSearchContainer;

}
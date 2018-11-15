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

package com.liferay.asset.assetcategorytagselector.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryServiceUtil;
import com.liferay.asset.kernel.service.AssetTagServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyServiceUtil;
import com.liferay.asset.assetcategorytagselector.search.EntriesChecker;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
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
public class AssetCategoryTagSelectorDisplayContext {

	public AssetCategoryTagSelectorDisplayContext(
		RenderRequest renderRequest, RenderResponse renderResponse,
		HttpServletRequest request) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_request = request;
	}

	public JSONArray getCategoriesJSONArray() throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		JSONArray jsonArray = _getCategoriesJSONArray();

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("children", jsonArray);
		jsonObject.put("disabled", true);
		jsonObject.put("expanded", true);
		jsonObject.put("icon", "folder");
		jsonObject.put("id", "0");
		jsonObject.put(
			"name", LanguageUtil.get(themeDisplay.getLocale(), "vocabularies"));

		JSONArray rootJSONArray = JSONFactoryUtil.createJSONArray();

		rootJSONArray.put(jsonObject);

		return rootJSONArray;
	}

	public long getCategoryId() {
		if (_categoryId != 0) {
			return _categoryId;
		}

		_categoryId = ParamUtil.getLong(_request, "categoryId");
System.out.println("22222222222222222222222"+_categoryId);
		return _categoryId;
	}

	public String getEventName() {
		if (Validator.isNotNull(_eventName)) {
			return _eventName;
		}

		_eventName = ParamUtil.getString(
			_request, "eventName",
			_renderResponse.getNamespace() + "selectCategory");

		return _eventName;
	}

	public String getSelectedCategories() {
		if (_selectedCategories != null) {
			return _selectedCategories;
		}

		_selectedCategories = ParamUtil.getString(
			_request, "selectedCategories");
		System.out.println("3333333333"+_selectedCategories);
		return _selectedCategories;
	}

	public String getType() {
		if (_type != null) {
			return _type;
		}

		if (!isAllowedSelectVocabularies()) {
			_type = "io";

			return _type;
		}

		_type = "check";

		if (isSingleSelect()) {
			_type = "radio";
		}

		return _type;
	}

	//---------------by Tiamo-----------------------
	
	public String getVocabularyIdsString() throws Exception {
		List<AssetVocabulary> vocabularies =
			AssetVocabularyServiceUtil.getGroupsVocabularies(_getGroupIds());

		return ListUtil.toString(
			vocabularies, AssetVocabulary.VOCABULARY_ID_ACCESSOR);
	}
	
	//--------------------------------------------------
	
	public long[] getVocabularyIds() throws Exception {
		if (_vocabularyIds != null) {
			return _vocabularyIds;
		}

		_vocabularyIds = StringUtil.split(
				getVocabularyIdsString(), 0L);
		for (int i=0;i<_vocabularyIds.length;i++) {
			System.out.println("444444444444"+_vocabularyIds[i]);
		}

		return _vocabularyIds;
	}

	public String getVocabularyTitle(long vocabularyId) throws PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay)_renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		AssetVocabulary assetVocabulary =
			AssetVocabularyLocalServiceUtil.fetchAssetVocabulary(vocabularyId);

		StringBundler sb = new StringBundler(4);

		String title = assetVocabulary.getTitle(themeDisplay.getLocale());

		sb.append(HtmlUtil.escape(title));

		sb.append(StringPool.OPEN_PARENTHESIS);

		if (assetVocabulary.getGroupId() == themeDisplay.getCompanyGroupId()) {
			sb.append(LanguageUtil.get(_request, "global"));
		}
		else {
			Group group = GroupLocalServiceUtil.fetchGroup(
				assetVocabulary.getGroupId());

			sb.append(group.getDescriptiveName(themeDisplay.getLocale()));
		}

		sb.append(StringPool.CLOSE_PARENTHESIS);

		return sb.toString();
	}

	public boolean isAllowedSelectVocabularies() {
		if (_allowedSelectVocabularies != null) {
			return _allowedSelectVocabularies;
		}

		_allowedSelectVocabularies = ParamUtil.getBoolean(
			_request, "allowedSelectVocabularies");
		System.out.println("55555555555"+_allowedSelectVocabularies);
		return _allowedSelectVocabularies;
	}

	public boolean isSingleSelect() {
		if (_singleSelect != null) {
			return _singleSelect;
		}

		_singleSelect = ParamUtil.getBoolean(_request, "singleSelect");

		return _singleSelect;
	}

	private JSONArray _getCategoriesJSONArray() throws Exception {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		System.out.println("000222");
		boolean allowedSelectVocabularies = ParamUtil.getBoolean(
			_request, "allowedSelectVocabularies");

		for (long vocabularyId : getVocabularyIds()) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put(
				"children", _getCategoriesJSONArray(vocabularyId, 0));
			jsonObject.put("disabled", !allowedSelectVocabularies);
			jsonObject.put("icon", "folder");
			jsonObject.put("id", vocabularyId);
			jsonObject.put("name", getVocabularyTitle(vocabularyId));
			jsonObject.put("vocabulary", true);
			System.out.println("77777777777777"+vocabularyId);
			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	private JSONArray _getCategoriesJSONArray(
			long vocabularyId, long categoryId)
		throws Exception {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		ThemeDisplay themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);

		List<AssetCategory> categories =
			AssetCategoryServiceUtil.getVocabularyCategories(
				categoryId, vocabularyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);

		for (AssetCategory category : categories) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			JSONArray children = _getCategoriesJSONArray(
				vocabularyId, category.getCategoryId());

			if (children.length() > 0) {
				jsonObject.put("children", children);
			}
System.out.println("ccccccccccccccccccccccccccc"+category.getCategoryId());
			jsonObject.put("icon", "page");
			jsonObject.put("id", category.getCategoryId());
			jsonObject.put("name", category.getTitle(themeDisplay.getLocale()));

			if (getSelectedCategories().contains(
					String.valueOf(category.getCategoryId()))) {

				jsonObject.put("selected", true);
			}

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

//TAG METHOD

	public String getClearResultsURL() {
		PortletURL clearResultsURL = _getPortletURL();

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	public String getTagEventName() {
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
			//add themeDisplay.getCompanyGroupId() by Tiamo
			_groupIds = new long[] {themeDisplay.getScopeGroupId(),themeDisplay.getCompanyGroupId()};
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

		portletURL.setParameter("eventName", getTagEventName());
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
	private Boolean _allowedSelectVocabularies;
	private long _categoryId;
	private String _selectedCategories;
	private Boolean _singleSelect;
	private String _type;
	private long[] _vocabularyIds;

}
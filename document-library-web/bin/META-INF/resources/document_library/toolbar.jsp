<%--
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
--%>

<%@ include file="/document_library/init.jsp" %>

<%
long repositoryId = GetterUtil.getLong((String)request.getAttribute("view.jsp-repositoryId"));

long fileEntryTypeId = ParamUtil.getLong(request, "fileEntryTypeId", -1);

DLAdminManagementToolbarDisplayContext dlAdminManagementToolbarDisplayContext = new DLAdminManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, dlAdminDisplayContext);
%>

<clay:management-toolbar
	actionDropdownItems="<%= dlAdminManagementToolbarDisplayContext.getActionDropdownItems() %>"
	clearResultsURL="<%= dlAdminManagementToolbarDisplayContext.getClearResultsURL() %>"
	componentId="dlAdminManagementToolbar"
	creationMenu="<%= dlAdminManagementToolbarDisplayContext.getCreationMenu() %>"
	disabled="<%= dlAdminManagementToolbarDisplayContext.isDisabled() %>"
	filterDropdownItems="<%= dlAdminManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	infoPanelId="infoPanelId"
	itemsTotal="<%= dlAdminManagementToolbarDisplayContext.getTotalItems() %>"
	searchActionURL="<%= String.valueOf(dlAdminManagementToolbarDisplayContext.getSearchURL()) %>"
	searchContainerId="entries"
	selectable="<%= dlAdminManagementToolbarDisplayContext.isSelectable() %>"
	showInfoButton="<%= true %>"
	showSearch="<%= dlAdminManagementToolbarDisplayContext.isShowSearch() %>"
	sortingOrder="<%= dlAdminManagementToolbarDisplayContext.getSortingOrder() %>"
	sortingURL="<%= String.valueOf(dlAdminManagementToolbarDisplayContext.getSortingURL()) %>"
	viewTypeItems="<%= dlAdminManagementToolbarDisplayContext.getViewTypes() %>"
/>

<aui:script sandbox="<%= true %>" use="aui-base,liferay-item-selector-dialog">
	var checkin = function() {
		Liferay.fire(
			'<%= renderResponse.getNamespace() %>editEntry',
			{
				action: '<%= Constants.CHECKIN %>'
			}
		);
	};

	var checkout = function() {
		Liferay.fire(
			'<%= renderResponse.getNamespace() %>editEntry',
			{
				action: '<%= Constants.CHECKOUT %>'
			}
		);
	};

	var deleteEntries = function() {
		if (<%= dlTrashUtil.isTrashEnabled(scopeGroupId, repositoryId) %> || confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-entries") %>')) {
			Liferay.fire(
				'<%= renderResponse.getNamespace() %>editEntry',
				{
					action: '<%= dlTrashUtil.isTrashEnabled(scopeGroupId, repositoryId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>'
				}
			);
		}
	};

	var download = function() {
		Liferay.fire(
			'<%= renderResponse.getNamespace() %>editEntry',
			{
				action: 'download'
			}
		);
	};

	var move = function() {
		Liferay.fire(
			'<%= renderResponse.getNamespace() %>editEntry',
			{
				action: '<%= Constants.MOVE %>'
			}
		);
	};

	<%
	PortletURL viewFileEntryTypeURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);

	viewFileEntryTypeURL.setParameter("browseBy", "file-entry-type");
	viewFileEntryTypeURL.setParameter("fileEntryTypeId", (String)null);
	%>

	var openDocumentTypesSelector = function() {
		var A = AUI();

		var itemSelectorDialog = new A.LiferayItemSelectorDialog(
			{
				eventName: '<portlet:namespace />selectFileEntryType',
				on: {
					selectedItemChange: function(event) {
						var selectedItem = event.newVal;

						if (selectedItem) {
							var uri = '<%= viewFileEntryTypeURL %>';

							uri = Liferay.Util.addParams('<portlet:namespace />fileEntryTypeId=' + selectedItem, uri);

							location.href = uri;
						}
					}
				},
				'strings.add': '<liferay-ui:message key="select" />',
				title: '<liferay-ui:message key="select-document-type" />',
				url: '<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/document_library/select_file_entry_type.jsp" /><portlet:param name="fileEntryTypeId" value="<%= String.valueOf(fileEntryTypeId) %>" /></portlet:renderURL>'
			}
		);

		itemSelectorDialog.open();

	};

	var ACTIONS = {
		'checkin': checkin,
		'checkout': checkout,
		'deleteEntries': deleteEntries,
		'download': download,
		'move': move,
		'openDocumentTypesSelector': openDocumentTypesSelector
	};

	Liferay.componentReady('dlAdminManagementToolbar').then(
		function(managementToolbar) {
			managementToolbar.on(
				['actionItemClicked', 'filterItemClicked'],
				function(event) {
					var itemData = event.data.item.data;

					if (itemData && itemData.action && ACTIONS[itemData.action]) {
						ACTIONS[itemData.action]();
					}
				}
			);
		}
	);
</aui:script>
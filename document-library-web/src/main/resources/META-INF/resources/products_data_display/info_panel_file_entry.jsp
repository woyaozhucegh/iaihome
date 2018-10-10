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

<%@ include file="/products_data_display/init.jsp" %>

<%
FileEntry fileEntry = (FileEntry)request.getAttribute("info_panel.jsp-fileEntry");
FileVersion fileVersion = (FileVersion)request.getAttribute("info_panel.jsp-fileVersion");

DLViewFileVersionDisplayContext dlViewFileVersionDisplayContext = dlDisplayContextProvider.getDLViewFileVersionDisplayContext(request, response, fileVersion);

long assetClassPK = 0;

if (!fileVersion.isApproved() && !fileVersion.getVersion().equals(DLFileEntryConstants.VERSION_DEFAULT) && !fileEntry.isInTrash()) {
	assetClassPK = fileVersion.getFileVersionId();
}
else {
	assetClassPK = fileEntry.getFileEntryId();
}

//get the group logo--------------------Tiamo--------------------------------------------
long fileEntryTypeId = ParamUtil.getLong(request, "fileEntryTypeId", -1);

long groupId = fileEntry.getGroupId();
Group group = GroupLocalServiceUtil.getGroup(groupId);
String groupname = group.getName();
boolean isPrivatePages = false;

long logoId = 0;
String layoutSetLogoUrl = null;
LayoutSet brandLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, isPrivatePages);
if (brandLayoutSet.isLogo()) {
  logoId = brandLayoutSet.getLogoId();
}
StringBundler sb = new StringBundler(5);

sb.append(PortalUtil.getPathImage());
sb.append("/layout_set_logo?img_id=");
sb.append(logoId);
sb.append("&t=");
sb.append(WebServerServletTokenUtil.getToken(logoId));
layoutSetLogoUrl = sb.toString();


AssetEntry layoutAssetEntry = AssetEntryLocalServiceUtil.fetchEntry(DLFileEntryConstants.getClassName(), assetClassPK);

//get the fileEntryType

if (fileVersion.getModel() instanceof DLFileVersion) {
	DLFileVersion dlFileVersion = (DLFileVersion)fileVersion.getModel();

	fileEntryTypeId = dlFileVersion.getFileEntryTypeId();
}

DLFileEntryType dlFileEntryType = null;
String dlFileEntrytypeName = "base documents";
if (fileEntryTypeId > 0) {
	dlFileEntryType = DLFileEntryTypeLocalServiceUtil.getFileEntryType(fileEntryTypeId);
	dlFileEntrytypeName = dlFileEntryType.getName(locale);
}
%>

<div class="sidebar-header">
	<ul class="sidebar-header-actions">
		<li>
			<liferay-util:include page="/products_data_display/file_entry_action.jsp" servletContext="<%= application %>" />
		</li>
	</ul>


	<c:if test="<%= dlViewFileVersionDisplayContext.isVersionInfoVisible() %>">
		<clay:label
			label='<%= LanguageUtil.get(request, "version") + StringPool.SPACE + fileVersion.getVersion() %>'
			style="info"
		/>
	</c:if>

	<aui:model-context bean="<%= fileVersion %>" model="<%= DLFileVersion.class %>" />

	<aui:workflow-status model="<%= DLFileEntry.class %>" showIcon="<%= false %>" showLabel="<%= false %>" status="<%= fileVersion.getStatus() %>" />
</div>

<%
String tabsNames = "details";

if (dlViewFileVersionDisplayContext.isVersionInfoVisible()) {
	tabsNames += ",versions";
}
%>

<liferay-ui:tabs
	cssClass="navbar-no-collapse"
	names="<%= tabsNames %>"
	refresh="<%= false %>"
	type="dropdown"
>
	<liferay-ui:section>
		<div class="sidebar-body">

			<%
			String thumbnailSrc = DLUtil.getThumbnailSrc(fileEntry, fileVersion, themeDisplay);
			%>

			<div class="aspect-ratio aspect-ratio-16-to-9 sidebar-panel thumbnail">
				<img alt="<liferay-ui:message escapeAttribute="<%= true %>" key="thumbnail" />" class="aspect-ratio-item-center-middle aspect-ratio-item-fluid" src="<%= layoutSetLogoUrl %>" />
				<span style="display:block; margin: 8px; color: rgba(0, 0, 0, 0.5);font-size: 0.87em;"><%= LanguageUtil.format(request, "x-ago-by-x", new String[] {LanguageUtil.getTimeDescription(locale, System.currentTimeMillis() - fileVersion.getCreateDate().getTime(), true), groupname}, false) %></span>
			</div>


			<div class="autofit-row sidebar-panel widget-metadata">
				<div class="autofit-col inline-item-before">

					<%
					User owner = UserLocalServiceUtil.fetchUser(fileEntry.getUserId());

					String ownerURL = StringPool.BLANK;

					if ((owner != null) && !owner.isDefaultUser()) {
						ownerURL = owner.getDisplayURL(themeDisplay);
					}
					%>

					<liferay-ui:user-portrait
						cssClass="user-icon-lg"
						user="<%= owner %>"
					/>
				</div>

				<div class="autofit-col autofit-col-expand">
					<div class="autofit-row">
						<div class="autofit-col autofit-col-expand">
							<div class="component-title h4 username">
								<a href="<%= ownerURL %>"><%= owner.getFullName() %></a>
							</div>
						</div>
					</div>
				</div>
			</div>


			<dl class="sidebar-dl sidebar-section">
				<liferay-asset:asset-categories-available
					className="<%= DLFileEntryConstants.getClassName() %>"
					classPK="<%= assetClassPK %>"
				>
					<dt class="sidebar-dt">
						<liferay-ui:message key="categories" />
					</dt>
					<dd class="sidebar-dd">
						<liferay-asset:asset-categories-summary
							className="<%= DLFileEntryConstants.getClassName() %>"
							classPK="<%= assetClassPK %>"
							displayStyle="simple-category"
						/>
					</dd>
				</liferay-asset:asset-categories-available>
				
				<liferay-asset:asset-tags-available
					className="<%= DLFileEntryConstants.getClassName() %>"
					classPK="<%= assetClassPK %>"
				>
					<dt class="sidebar-dt">
						<liferay-ui:message key="tags" />
					</dt>
					<dd class="sidebar-dd">
						<liferay-asset:asset-tags-summary
							className="<%= DLFileEntryConstants.getClassName() %>"
							classPK="<%= assetClassPK %>"
						/>
					</dd>
				</liferay-asset:asset-tags-available>

			</dl>

			<c:if test="<%= (layoutAssetEntry != null) && dlPortletInstanceSettings.isEnableRelatedAssets() && fileEntry.isSupportsSocial() %>">
				<liferay-asset:asset-links
					assetEntryId="<%= layoutAssetEntry.getEntryId() %>"
				/>
			</c:if>
			
            <c:if test="<%= Validator.isNotNull(fileEntry.getDescription()) %>">
				<dd class="sidebar-dd fileentry-description">
					<%= HtmlUtil.escape(fileEntry.getDescription()) %>
				</dd>
			</c:if>

		</div>
	</liferay-ui:section>

	<c:if test="<%= dlViewFileVersionDisplayContext.isVersionInfoVisible() %>">
		<liferay-ui:section>
			<div class="sidebar-body">

				<%
				request.setAttribute("info_panel.jsp-fileEntry", fileEntry);
				%>

				<liferay-util:include page="/products_data_display/file_entry_history.jsp" servletContext="<%= application %>" />
			</div>
		</liferay-ui:section>
	</c:if>

</liferay-ui:tabs>
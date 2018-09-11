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
long repositoryId = GetterUtil.getLong((String)request.getAttribute("view.jsp-repositoryId"), ParamUtil.getLong(request, "repositoryId"));

request.setAttribute("view.jsp-repositoryId", String.valueOf(repositoryId));

List<Folder> folders = (List<Folder>)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FOLDERS);
List<FileEntry> fileEntries = (List<FileEntry>)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_ENTRIES);
List<FileShortcut> fileShortcuts = (List<FileShortcut>)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_SHORTCUTS);

Map<String, Object> infoPanelToggleData = new HashMap<String, Object>();

infoPanelToggleData.put("toggle", liferayPortletResponse.getNamespace() + "infoPanelId");

if (ListUtil.isEmpty(folders) && ListUtil.isEmpty(fileEntries) && ListUtil.isEmpty(fileShortcuts)) {
	long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"), ParamUtil.getLong(request, "folderId"));

	folders = new ArrayList<Folder>();

	Folder folder = (Folder)request.getAttribute("view.jsp-folder");

	if (folder != null) {
		folders.add(folder);
	}
	else if (folderId != DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
		folders.add(DLAppLocalServiceUtil.getFolder(folderId));
	}
	else {
		folders.add(null);
	}
}
%>

<c:choose>
	<c:when test="<%= ListUtil.isEmpty(fileEntries) && ListUtil.isEmpty(fileShortcuts) && ListUtil.isNotEmpty(folders) && (folders.size() == 1) %>">

		<%
		Folder folder = folders.get(0);

		request.setAttribute("info_panel.jsp-folder", folder);
		%>

		<div class="sidebar-header">
			<ul class="sidebar-actions">
				<li>
					<liferay-util:include page="/document_library/subscribe.jsp" servletContext="<%= application %>" />
				</li>
				<li>
					<liferay-util:include page="/document_library/folder_action.jsp" servletContext="<%= application %>" />
				</li>
			</ul>

			<h4 class="sidebar-title"><%= (folder != null) ? folder.getName() : LanguageUtil.get(request, "home") %></h4>

			<h5 class="sidebar-subtitle">
				<liferay-ui:message key="folder" />
			</h5>
		</div>

		<liferay-ui:tabs
			cssClass="navbar-no-collapse"
			names="details"
			refresh="<%= false %>"
			type="dropdown"
		>
			<liferay-ui:section>
				<div class="sidebar-body">
					<dl class="sidebar-block">
						<dt class="sidebar-dt">
							<liferay-ui:message key="num-of-items" />
						</dt>

						<%
						long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

						if (folder != null) {
							folderId = folder.getFolderId();
						}
						%>

						<dd class="sidebar-dd">
							<%= DLAppServiceUtil.getFoldersAndFileEntriesAndFileShortcutsCount(repositoryId, folderId, WorkflowConstants.STATUS_APPROVED, true) %>
						</dd>

						<c:if test="<%= folder != null %>">
							<dt class="sidebar-dt">
								<liferay-ui:message key="created" />
							</dt>
							<dd class="sidebar-dd">
								<%= HtmlUtil.escape(folder.getUserName()) %>
							</dd>
						</c:if>
					</dl>
				</div>
			</liferay-ui:section>
		</liferay-ui:tabs>
	</c:when>
	<c:when test="<%= ListUtil.isEmpty(folders) && ListUtil.isEmpty(fileShortcuts) && ListUtil.isNotEmpty(fileEntries) && (fileEntries.size() == 1) %>">

		<%
		FileEntry fileEntry = fileEntries.get(0);

		FileVersion fileVersion = null;

		if ((user.getUserId() == fileEntry.getUserId()) || permissionChecker.isContentReviewer(user.getCompanyId(), scopeGroupId) || DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.UPDATE)) {
			fileVersion = fileEntry.getLatestFileVersion();
		}
		else {
			fileVersion = fileEntry.getFileVersion();
		}

		request.setAttribute("info_panel.jsp-fileEntry", fileEntry);
		request.setAttribute("info_panel.jsp-fileVersion", fileVersion);
		%>

		<liferay-util:include page="/document_library/info_panel_file_entry.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test="<%= ListUtil.isEmpty(folders) && ListUtil.isEmpty(fileEntries) && ListUtil.isNotEmpty(fileShortcuts) && (fileShortcuts.size() == 1) %>">

		<%
		FileShortcut fileShortcut = fileShortcuts.get(0);

		request.setAttribute("info_panel.jsp-fileShortcut", fileShortcut);
		%>

		<div class="sidebar-header">
			<ul class="sidebar-actions">
				<li>
					<liferay-util:include page="/document_library/file_entry_action.jsp" servletContext="<%= application %>" />
				</li>
			</ul>

			<h4 class="sidebar-title"><%= HtmlUtil.escape(fileShortcut.getToTitle()) %></h4>

			<h5>
				<liferay-ui:message key="shortcut" />
			</h5>
		</div>

		<liferay-ui:tabs
			cssClass="navbar-no-collapse"
			names="details"
			refresh="<%= false %>"
			type="dropdown"
		>
			<liferay-ui:section>
				<div class="sidebar-body">

					<%
					FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileShortcut.getToFileEntryId());
					%>

					<dl class="sidebar-block">
						<dt class="sidebar-dt">
							<liferay-ui:message key="description" />
						</dt>
						<dd class="sidebar-dd">
							<%= HtmlUtil.escape(fileEntry.getDescription()) %>
						</dd>

						<%
						Group fileEntryGroup = GroupLocalServiceUtil.getGroup(fileEntry.getGroupId());

						Group fileEntrySiteGroup = fileEntryGroup;

						while ((fileEntrySiteGroup != null) && !fileEntrySiteGroup.isSite()) {
							fileEntrySiteGroup = fileEntrySiteGroup.getParentGroup();
						}
						%>

						<c:if test="<%= fileEntrySiteGroup != null %>">
							<dt class="sidebar-dt">
								<liferay-ui:message key="target-site" />
							</dt>
							<dd class="sidebar-dd">
								<%= HtmlUtil.escape(fileEntrySiteGroup.getName(locale)) %>
							</dd>
						</c:if>

						<dt class="sidebar-dt">
							<liferay-ui:message key="target-folder" />
						</dt>
						<dd class="sidebar-dd">

							<%
							Folder folder = fileEntry.getFolder();
							%>

							<portlet:renderURL var="targetFolderURL">
								<portlet:param name="mvcRenderCommand" value="/document_library/view" />
								<portlet:param name="folderId" value="<%= String.valueOf(folder.getFolderId()) %>" />
							</portlet:renderURL>

							<a href="<%= targetFolderURL %>">
								<c:choose>
									<c:when test="<%= folder.getFolderId() == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID %>">
										<liferay-ui:message key="home" />
									</c:when>
									<c:otherwise>
										<%= HtmlUtil.escape(folder.getName()) %>
									</c:otherwise>
								</c:choose>
							</a>
						</dd>
						<dt class="sidebar-dt">
							<liferay-ui:message key="size" />
						</dt>
						<dd class="sidebar-dd">
							<%= TextFormatter.formatStorageSize(fileEntry.getSize(), locale) %>
						</dd>

						<c:if test="<%= fileEntry.getModel() instanceof DLFileEntry %>">

							<%
							DLFileEntry dlFileEntry = (DLFileEntry)fileEntry.getModel();

							DLFileEntryType dlFileEntryType = dlFileEntry.getDLFileEntryType();
							%>

							<dt class="sidebar-dt">
								<liferay-ui:message key="document-type" />
							</dt>
							<dd class="sidebar-dd">
								<%= HtmlUtil.escape(dlFileEntryType.getName(locale)) %>
							</dd>
						</c:if>

						<dt class="sidebar-dt">
							<liferay-ui:message key="content-type" />
						</dt>
						<dd class="sidebar-dd">
							<%= HtmlUtil.escape(fileEntry.getMimeType()) %>
						</dd>
					</dl>
				</div>
			</liferay-ui:section>
		</liferay-ui:tabs>
	</c:when>
	<c:otherwise>
		<div class="sidebar-header">
			<h4 class="sidebar-title"><liferay-ui:message arguments="<%= folders.size() + fileEntries.size() + fileShortcuts.size() %>" key="x-items-are-selected" /></h4>
		</div>

		<liferay-ui:tabs
			cssClass="navbar-no-collapse"
			names="details"
			refresh="<%= false %>"
			type="dropdown"
		>
			<liferay-ui:section>
				<div class="sidebar-body">
					<h5>
						<liferay-ui:message arguments="<%= folders.size() + fileEntries.size() + fileShortcuts.size() %>" key="x-items-are-selected" />
					</h5>
				</div>
			</liferay-ui:section>
		</liferay-ui:tabs>
	</c:otherwise>
</c:choose>
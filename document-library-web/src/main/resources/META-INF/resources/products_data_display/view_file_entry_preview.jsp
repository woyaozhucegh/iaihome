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
FileVersion fileVersion = (FileVersion)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_VERSION);

int status = ParamUtil.getInteger(request, "status", WorkflowConstants.STATUS_ANY);

FileEntry fileEntry = fileVersion.getFileEntry();

boolean hasAudio = AudioProcessorUtil.hasAudio(fileVersion);
boolean hasImages = ImageProcessorUtil.hasImages(fileVersion);
boolean hasPDFImages = PDFProcessorUtil.hasImages(fileVersion);
boolean hasVideo = VideoProcessorUtil.hasVideo(fileVersion);

boolean showImageContainer = true;


//---------------------------------Tiamo-------------------------------------------------------------
boolean versionSpecific = false;

if (fileVersion != null) {
	versionSpecific = true;
}
else if ((user.getUserId() == fileEntry.getUserId()) || permissionChecker.isContentReviewer(user.getCompanyId(), scopeGroupId) || DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.UPDATE)) {
	fileVersion = fileEntry.getLatestFileVersion();
}
else {
	fileVersion = fileEntry.getFileVersion();
}

long fileVersionId = fileVersion.getFileVersionId();

long fileEntryTypeId = 0;

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
//--------------------Tiamo-------------------------------------------------------------------
//GET FileEntry attachments
long[] defaultData = {101594};
long[] attachmentFileEntryIds = {101594};
long classNameId = ClassNameLocalServiceUtil.getClassNameId(DLFileEntry.class.getName());
ExpandoTable expandoTable = ExpandoTableLocalServiceUtil.getTable(themeDisplay.getCompanyId(), classNameId, "CUSTOM_FIELDS");
if (!fileVersion.getVersion().equals(DLFileEntryConstants.VERSION_DEFAULT)) {
	attachmentFileEntryIds = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), DLFileEntry.class.getName(),expandoTable.getName(),"attachments", fileVersion.getFileVersionId(), defaultData);		
}
else {
	attachmentFileEntryIds = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), DLFileEntry.class.getName(),expandoTable.getName(),"attachments", fileEntry.getFileEntryId(), defaultData);							 
}

boolean uploadProducts = false;
boolean uploadManuals = false;
boolean uploadModels = false;

if(dlFileEntrytypeName.equals("products")){
	uploadProducts = true;
}else if(dlFileEntrytypeName.equals("manuals")){
	uploadManuals = true;
}else if(dlFileEntrytypeName.equals("models")){
	uploadModels = true;
}
%>


<%@ include file="/products_data_display/view_file_entry_preview.jspf" %>
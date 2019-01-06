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

<%@ include file="/init.jsp" %>
<%
	User selUser = themeDisplay.getUser();
%>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="editCategories" var="editCategoriesURL" >
	<portlet:param name="context" value="n" />
</portlet:actionURL>

<div class="container-fluid-1280 entry-body">
	<aui:form action="<%= editCategoriesURL %>" cssClass="edit-entry" enctype="multipart/form-data" method="post" name="fm" onSubmit="event.preventDefault();">
		<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="categorization">
			<liferay-asset:asset-categories-selector
				className="<%= User.class.getName() %>"
				classPK="<%= (selUser != null) ? selUser.getPrimaryKey() : 0 %>"
			/>
		</aui:fieldset>
		<aui:button-row cssClass="blog-article-button-row">

			<aui:button name="saveButton" primary="<%= false %>" type="submit" value="save" />

			<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
		</aui:button-row>
		
	</aui:form>
</div>
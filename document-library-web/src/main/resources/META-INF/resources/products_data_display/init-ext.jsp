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

<%@
page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil" %><%@
page import="com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil" %><%@
page import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil" %><%@
page import="com.liferay.expando.kernel.model.ExpandoTable" %><%@
page import="com.liferay.portal.kernel.search.filter.BooleanFilter" %><%@
page import="com.liferay.portal.kernel.search.filter.TermFilter" %><%@
page import="com.liferay.portal.kernel.search.BooleanQuery" %><%@
page import="com.liferay.portal.kernel.search.IndexSearcher" %><%@
page import="com.liferay.portal.kernel.search.generic.BooleanQueryImpl" %><%@
page import="com.liferay.portal.kernel.search.SearchEngine" %><%@
page import="com.liferay.portal.kernel.search.BooleanQueryFactoryUtil" %><%@
page import="com.liferay.portal.kernel.search.SearchEngineUtil" %><%@
page import="com.liferay.portal.kernel.search.BooleanClauseOccur" %><%@
page import="com.liferay.portal.kernel.search.SearchEngineHelper" %><%@
page import="com.liferay.portal.kernel.search.Query" %><%@
page import="com.liferay.portal.kernel.search.generic.StringQuery" %><%@
page import="com.liferay.portal.kernel.search.BooleanClause" %><%@
page import="com.liferay.portal.kernel.search.BooleanClauseFactoryUtil" %><%@
page import="com.liferay.portal.kernel.search.SortFactoryUtil" %><%@
page import="java.io.Serializable" %><%@
page import="com.liferay.document.library.kernel.model.DLFileShortcut" %><%@
page import="com.liferay.document.library.kernel.service.DLFileShortcutLocalServiceUtil" %><%@
page import="com.liferay.document.library.kernel.model.DLFileEntryType" %><%@
page import="com.liferay.portal.kernel.exception.PortalException" %><%@
page import="com.liferay.portal.kernel.exception.SystemException" %><%@
page import="com.liferay.portal.kernel.model.LayoutSet" %><%@
page import="com.liferay.portal.kernel.service.LayoutSetLocalServiceUtil" %><%@
page import="com.liferay.asset.kernel.model.AssetEntry" %><%@
page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.webserver.WebServerServletTokenUtil" %>



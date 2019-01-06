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
       <script>
         define._amd = define.amd;
         define.amd = false;
     </script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/custom.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.bxslider.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easing.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/wow.js"></script>
     <script>
         define.amd = define._amd;
    </script>
        <div id="app">
        <div class="background-buttons">
            <p>Color</p>
            <button @click="bgColor = '#ff0'">#ff0</button>
            <button @click="bgColor = '#f00'">#f00</button>
            <button @click="bgColor = '#13ce66'">#13ce66</button>
            <p>Alpha</p>
            <button @click="bgAlpha = 0.5">0.5</button>
            <button @click="bgAlpha = 1">1</button>
            <button @click="bgAlpha = 0">0</button>
        </div>
        <model-obj
            :background-alpha="bgAlpha"
            :background-color="bgColor"
        	src="http://localhost:8080/documents/20126/0/1JZ_GTE_Engine.obj/67616d43-732a-3461-8558-ae73437d7ce1">
        </model-obj>
    </div>
    	 var app = new Vue({
		  el: '#app',
          data: {
              bgColor: '#ff0',
              bgAlpha: 0.5,
          },
		})
		
		
 	<div id="app2">
        <model-stl 
            :background-alpha="bgAlpha"
            :background-color="bgColor"
            :lights="[
		        {
		            type: 'DirectionalLight',           
		            position: { x: 1, y: 2, z: 3 },    
		            color: 0xffffff,
		            intensity: 0.6
		        }
		    ]"            
        	src="http://localhost:8080/documents/20126/0/%E7%AE%A1%E9%81%93%E7%8C%AA.stl/705f4b14-ca06-2d6b-55fa-7d6698b17ace"></model-stl>
    </div>  

<aui:script> 

	 var app2 = new Vue({
		  el: '#app2',
          data: {
              bgColor: '#ff0',
              bgAlpha: 0.5,
          },
		})
</aui:script>

<portlet:actionURL name="definedCategories" var="definedCategoriesURL" >
	<portlet:param name="context" value="<%= context.toString() %>" />
</portlet:actionURL>
--%>

<%@ include file="/init.jsp" %>
    <portlet:renderURL var="definedCategoriesURL">
        <portlet:param name="mvcPath" value="/defined_categories.jsp" />
    </portlet:renderURL>
<%
Map<String, Object> context = new HashMap<>();

context.put("itemSelectorSaveEvent", HtmlUtil.escapeJS(assetCategoriesSelectorDisplayContext.getEventName()));
context.put("multiSelection", !assetCategoriesSelectorDisplayContext.isSingleSelect());
context.put("namespace", liferayPortletResponse.getNamespace());
context.put("nodes", assetCategoriesSelectorDisplayContext.getCategoriesJSONArray());
System.out.println("nodes===="+assetCategoriesSelectorDisplayContext.getCategoriesJSONArray());
context.put("pathThemeImages", themeDisplay.getPathThemeImages());
context.put("viewType", "tree");

if (!themeDisplay.isSignedIn()){
%>
			<div class="SignupCallOut module js-signup-call-out">
			  <div class="SignupCallOut-header">
			    <h3 class="SignupCallOut-title u-textBreak">
			      	<liferay-ui:message key="new-user" />
			    </h3>
			  </div>
			  <div class="SignupCallOut-subheader">
				    <liferay-ui:message key="signin-define" />
			  </div>
			  <div class="signup SignupForm">
			 	 <a href="http://localhost:8080/c/portal/login" role="button" class="EdgeButton EdgeButton--large EdgeButton--primary SignupForm-submit u-block js-signup " data-component="signup_callout" data-element="form"><liferay-ui:message key="register-signin" /></a>
			  </div>
			</div>	
<%
}

%>		
    <portlet:renderURL var="definedCategoriesURL">
        <portlet:param name="mvcPath" value="/defined_categories.jsp" />
    </portlet:renderURL>

<soy:component-renderer
	context="<%= context %>"
	module="asset-category-tag-selector-web/js/SelectCategory.es"
	templateNamespace="com.liferay.asset.category.tag.selector.web.SelectCategory.render"
/>


<%
if (themeDisplay.isSignedIn()){
%>
			<div class="SignupCallOut module js-signup-call-out">
			  <div class="SignupCallOut-subheader">
				    <liferay-ui:message key="define-categories" />
			  </div>
			  <div class="signup SignupForm">
			 	 <a href="<%= definedCategoriesURL.toString() %>" role="button" class="EdgeButton EdgeButton--large EdgeButton--primary SignupForm-submit u-block js-signup " data-component="signup_callout" data-element="form"><liferay-ui:message key="want-to-customize" /></a>
			  </div>
			</div>	
<%
}
%>

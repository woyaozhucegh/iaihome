package com.liferay.asset.assetcategorytagselector.portlet;

import com.liferay.asset.assetcategorytagselector.constants.AssetCategoryTagSelectorWebPortletKeys;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetCategoryConstants;
import com.liferay.asset.kernel.service.AssetCategoryService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author huangxiangming
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=portlet-asset-category-tag-selector",
		"com.liferay.portlet.display-category=category.cms",
		"com.liferay.portlet.display-category=category.highlighted",
		"com.liferay.portlet.footer-portlet-javascript=https://cdn.jsdelivr.net/npm/vue/dist/vue.js",
		"com.liferay.portlet.footer-portlet-javascript=https://unpkg.com/vue-3d-model/dist/vue-3d-model.js",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/tree.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Asset Category tag Selector",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AssetCategoryTagSelectorWebPortletKeys.ASSET_CATEGORY_TAG_SELECTOR_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class AssetCategoryTagSelectorWebPortlet extends MVCPortlet {
	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		String resourceID = GetterUtil.getString(
			resourceRequest.getResourceID());

		if (resourceID.equals("getCategories")) {
			try {
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

				List<AssetCategory> categories = getCategories(resourceRequest);

				for (AssetCategory category : categories) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

					List<AssetCategory> childCategories =
						_assetCategoryService.getChildCategories(
							category.getCategoryId());
					System.out.println("ffffffffff"+category.getCategoryId());
					jsonObject.put("categoryId", category.getCategoryId());
					jsonObject.put("childrenCount", childCategories.size());
					jsonObject.put("hasChildren", !childCategories.isEmpty());
					jsonObject.put("name", category.getName());
					jsonObject.put(
						"parentCategoryId", category.getParentCategoryId());
					jsonObject.put(
						"titleCurrentValue", category.getTitleCurrentValue());

					jsonArray.put(jsonObject);
				}

				writeJSON(
					resourceRequest, resourceResponse, jsonArray.toString());
			}
			catch (PortalException pe) {
				throw new PortletException(pe);
			}
		}
		else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}

	protected List<AssetCategory> getCategories(PortletRequest portletRequest)
		throws PortalException {
		
		long categoryId = ParamUtil.getLong(portletRequest, "categoryId");
		long vocabularyId = ParamUtil.getLong(portletRequest, "vocabularyId");
		System.out.println("ddddddddddddddddd"+vocabularyId+"cccc"+categoryId);
		int start = ParamUtil.getInteger(
			portletRequest, "start", QueryUtil.ALL_POS);
		int end = ParamUtil.getInteger(
			portletRequest, "end", QueryUtil.ALL_POS);

		if ((categoryId <= 0) && (vocabularyId <= 0)) {
			return Collections.emptyList();
		}

		if (categoryId > 0) {
			return _assetCategoryService.getChildCategories(
				categoryId, start, end, null);
		}

		long parentCategoryId = ParamUtil.getLong(
			portletRequest, "parentCategoryId",
			AssetCategoryConstants.DEFAULT_PARENT_CATEGORY_ID);

		return _assetCategoryService.getVocabularyCategories(
			parentCategoryId, vocabularyId, start, end, null);
	}

	@Reference(unbind = "-")
	protected void setAssetCategoryService(
		AssetCategoryService assetCategoryService) {
System.out.println("111111111111111111");
		_assetCategoryService = assetCategoryService;
	}
	
	public void editCategories(ActionRequest request, ActionResponse response) {
		//String context = ParamUtil.getString(request, "context");
		//System.out.println("definedCategories---------"+context);
	}

	private AssetCategoryService _assetCategoryService;

}
;(function() {
	AUI().applyConfig(
		{
			groups: {
				'asset-category-tag-selector-web': {
					base: MODULE_PATH + '/',
					combine: Liferay.AUI.getCombine(),
					filter: Liferay.AUI.getFilterConfig(),
					modules: {
						'liferay-categories-selector': {
							path: 'js/categories_selector.js',
							requires: [
								'aui-tree',
								'liferay-asset-taglib-tags-selector'
							]
						},
					},
					root: MODULE_PATH + '/'
				}
			}
		}
	);
})();
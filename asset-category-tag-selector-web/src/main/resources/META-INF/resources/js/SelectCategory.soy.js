// This file was automatically generated from SelectCategory.soy.
// Please don't edit this file by hand.

/**
 * @fileoverview Templates in namespace com.liferay.asset.categories.selector.web.SelectCategory.
 * @public
 */

if (typeof com == 'undefined') { var com = {}; }
if (typeof com.liferay == 'undefined') { com.liferay = {}; }
if (typeof com.liferay.asset == 'undefined') { com.liferay.asset = {}; }
if (typeof com.liferay.asset.categories == 'undefined') { com.liferay.asset.categories = {}; }
if (typeof com.liferay.asset.categories.selector == 'undefined') { com.liferay.asset.categories.selector = {}; }
if (typeof com.liferay.asset.categories.selector.web == 'undefined') { com.liferay.asset.categories.selector.web = {}; }
if (typeof com.liferay.asset.categories.selector.web.SelectCategory == 'undefined') { com.liferay.asset.categories.selector.web.SelectCategory = {}; }


com.liferay.asset.categories.selector.web.SelectCategory.render = function(opt_data, opt_ignored) {
  goog.asserts.assert(goog.isBoolean(opt_data.multiSelection) || opt_data.multiSelection === 1 || opt_data.multiSelection === 0, "expected param 'multiSelection' of type boolean.");
  var multiSelection = /** @type {boolean} */ (!!opt_data.multiSelection);
  var nodes = goog.asserts.assertArray(opt_data.nodes, "expected parameter 'nodes' of type list<unknown>.");
  goog.asserts.assert(goog.isString(opt_data.pathThemeImages) || (opt_data.pathThemeImages instanceof goog.soy.data.SanitizedContent), "expected param 'pathThemeImages' of type string|goog.soy.data.SanitizedContent.");
  var pathThemeImages = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.pathThemeImages);
  goog.asserts.assert(opt_data.namespace == null || (opt_data.namespace instanceof goog.soy.data.SanitizedContent) || goog.isString(opt_data.namespace), "expected param 'namespace' of type null|string|undefined.");
  var namespace = /** @type {null|string|undefined} */ (opt_data.namespace);
  goog.asserts.assert(opt_data.selectedNodeChange_ == null || opt_data.selectedNodeChange_ != null, "expected param 'selectedNodeChange_' of type *|null|undefined.");
  var selectedNodeChange_ = /** @type {*|null|undefined} */ (opt_data.selectedNodeChange_);
  goog.asserts.assert(opt_data.viewType == null || (opt_data.viewType instanceof goog.soy.data.SanitizedContent) || goog.isString(opt_data.viewType), "expected param 'viewType' of type null|string|undefined.");
  var viewType = /** @type {null|string|undefined} */ (opt_data.viewType);
  return soydata.VERY_UNSAFE.ordainSanitizedHtml('<div class="select-category"><nav class="management-bar navbar navbar-light"><div class="navbar-form navbar-form-autofit"><div class="container-fluid"><form role="search"><div class="input-group input-group-inset"><div class="input-group-input"><input class="form-control" data-oninput="searchNodes_" name="' + soy.$$escapeHtmlAttribute(namespace) + 'filterKeywords" placeholder="search" type="text"></div><span class="input-group-inset-item"><button class="btn btn-unstyled" type="button"><svg class="lexicon-icon"><use xlink:href="' + soy.$$escapeHtmlAttribute(soy.$$filterNormalizeUri(pathThemeImages)) + '/lexicon/icons.svg#search"></use></svg></button></span></div></form></div></div></nav><form class="container-fluid-1280" name="' + soy.$$escapeHtmlAttribute(namespace) + 'selectCategoryFm"><fieldset class="panel-body"><div class="category-tree" id="' + soy.$$escapeHtmlAttribute(namespace) + 'categoryContainer">' + soy.$$escapeHtml(liferay.frontend.CardsTreeview.render({events: {selectedNodesChanged: selectedNodeChange_}, multiSelection: multiSelection, nodes: nodes, pathThemeImages: pathThemeImages, viewType: viewType})) + '</div></fieldset></form></div>');
};
if (goog.DEBUG) {
  com.liferay.asset.categories.selector.web.SelectCategory.render.soyTemplateName = 'com.liferay.asset.categories.selector.web.SelectCategory.render';
}

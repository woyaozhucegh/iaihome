// This file was automatically generated from TagSelector.soy.
// Please don't edit this file by hand.

/**
 * @fileoverview Templates in namespace com.liferay.asset.publisher.web.TagSelector.
 * @public
 */

if (typeof com == 'undefined') { var com = {}; }
if (typeof com.liferay == 'undefined') { com.liferay = {}; }
if (typeof com.liferay.asset == 'undefined') { com.liferay.asset = {}; }
if (typeof com.liferay.asset.publisher == 'undefined') { com.liferay.asset.publisher = {}; }
if (typeof com.liferay.asset.publisher.web == 'undefined') { com.liferay.asset.publisher.web = {}; }
if (typeof com.liferay.asset.publisher.web.TagSelector == 'undefined') { com.liferay.asset.publisher.web.TagSelector = {}; }


com.liferay.asset.publisher.web.TagSelector.render = function(opt_data, opt_ignored) {
  var index = goog.asserts.assertNumber(opt_data.index, "expected parameter 'index' of type int.");
  goog.asserts.assert(opt_data.namespace == null || (opt_data.namespace instanceof goog.soy.data.SanitizedContent) || goog.isString(opt_data.namespace), "expected param 'namespace' of type null|string|undefined.");
  var namespace = /** @type {null|string|undefined} */ (opt_data.namespace);
  return soydata.VERY_UNSAFE.ordainSanitizedHtml('<div id="' + soy.$$escapeHtmlAttribute(namespace) + 'assetTagsSelector' + soy.$$escapeHtmlAttribute(index) + '"><input name="' + soy.$$escapeHtmlAttribute(namespace) + 'queryTagNames' + soy.$$escapeHtmlAttribute(index) + '" id="' + soy.$$escapeHtmlAttribute(namespace) + 'queryTagNames' + soy.$$escapeHtmlAttribute(index) + '" ref="hiddenInput" type="hidden" /><input class="form-control lfr-tag-selector-input" id="' + soy.$$escapeHtmlAttribute(index) + 'assetTagName" ref="tagInput" size="15" title="add-tags" type="text" /></div>');
};
if (goog.DEBUG) {
  com.liferay.asset.publisher.web.TagSelector.render.soyTemplateName = 'com.liferay.asset.publisher.web.TagSelector.render';
}

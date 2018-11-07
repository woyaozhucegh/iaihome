// This file was automatically generated from AutoField.soy.
// Please don't edit this file by hand.

/**
 * @fileoverview Templates in namespace com.liferay.asset.publisher.web.AutoField.
 * @public
 */

if (typeof com == 'undefined') { var com = {}; }
if (typeof com.liferay == 'undefined') { com.liferay = {}; }
if (typeof com.liferay.asset == 'undefined') { com.liferay.asset = {}; }
if (typeof com.liferay.asset.publisher == 'undefined') { com.liferay.asset.publisher = {}; }
if (typeof com.liferay.asset.publisher.web == 'undefined') { com.liferay.asset.publisher.web = {}; }
if (typeof com.liferay.asset.publisher.web.AutoField == 'undefined') { com.liferay.asset.publisher.web.AutoField = {}; }


com.liferay.asset.publisher.web.AutoField.render = function(opt_data, opt_ignored) {
  goog.asserts.assert(goog.isString(opt_data.categorySelectorURL) || (opt_data.categorySelectorURL instanceof goog.soy.data.SanitizedContent), "expected param 'categorySelectorURL' of type string|goog.soy.data.SanitizedContent.");
  var categorySelectorURL = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.categorySelectorURL);
  goog.asserts.assert(goog.isString(opt_data.groupIds) || (opt_data.groupIds instanceof goog.soy.data.SanitizedContent), "expected param 'groupIds' of type string|goog.soy.data.SanitizedContent.");
  var groupIds = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.groupIds);
  goog.asserts.assert(goog.isString(opt_data.id) || (opt_data.id instanceof goog.soy.data.SanitizedContent), "expected param 'id' of type string|goog.soy.data.SanitizedContent.");
  var id = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.id);
  goog.asserts.assert(opt_data.namespace == null || (opt_data.namespace instanceof goog.soy.data.SanitizedContent) || goog.isString(opt_data.namespace), "expected param 'namespace' of type null|string|undefined.");
  var namespace = /** @type {null|string|undefined} */ (opt_data.namespace);
  goog.asserts.assert(goog.isString(opt_data.pathThemeImages) || (opt_data.pathThemeImages instanceof goog.soy.data.SanitizedContent), "expected param 'pathThemeImages' of type string|goog.soy.data.SanitizedContent.");
  var pathThemeImages = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.pathThemeImages);
  var rules = goog.asserts.assertArray(opt_data.rules, "expected parameter 'rules' of type list<[queryAndOperator: bool, queryContains: bool, type: string]>.");
  goog.asserts.assert(goog.isString(opt_data.tagSelectorURL) || (opt_data.tagSelectorURL instanceof goog.soy.data.SanitizedContent), "expected param 'tagSelectorURL' of type string|goog.soy.data.SanitizedContent.");
  var tagSelectorURL = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.tagSelectorURL);
  goog.asserts.assert(goog.isString(opt_data.vocabularyIds) || (opt_data.vocabularyIds instanceof goog.soy.data.SanitizedContent), "expected param 'vocabularyIds' of type string|goog.soy.data.SanitizedContent.");
  var vocabularyIds = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.vocabularyIds);
  goog.asserts.assert(opt_data.queryLogicIndexes == null || (opt_data.queryLogicIndexes instanceof goog.soy.data.SanitizedContent) || goog.isString(opt_data.queryLogicIndexes), "expected param 'queryLogicIndexes' of type null|string|undefined.");
  var queryLogicIndexes = /** @type {null|string|undefined} */ (opt_data.queryLogicIndexes);
  var output = '<div id="' + soy.$$escapeHtmlAttribute(id) + '"><input name="' + soy.$$escapeHtmlAttribute(namespace) + 'queryLogicIndexes" value="' + soy.$$escapeHtmlAttribute(queryLogicIndexes) + '" type="hidden"><ul class="timeline"><li class="timeline-item"><div class="panel panel-default"><div class="flex-container panel-body"><div class="h4 panel-title">rules</div><div class="timeline-increment"><span class="timeline-icon"></span></div></div></div></li>';
  if (rules && rules.length > 0) {
    var ruleList26 = rules;
    var ruleListLen26 = ruleList26.length;
    for (var ruleIndex26 = 0; ruleIndex26 < ruleListLen26; ruleIndex26++) {
      var ruleData26 = ruleList26[ruleIndex26];
      var ruleIndex__soy16 = ruleIndex26;
      output += com.liferay.asset.publisher.web.AutoField.rule({categorySelectorURL: categorySelectorURL, groupIds: groupIds, index: ruleIndex__soy16, namespace: namespace, pathThemeImages: pathThemeImages, rule: ruleData26, tagSelectorURL: tagSelectorURL, vocabularyIds: vocabularyIds});
    }
  }
  output += '</ul>' + com.liferay.asset.publisher.web.AutoField.addRuleButton(opt_data) + '</div>';
  return soydata.VERY_UNSAFE.ordainSanitizedHtml(output);
};
if (goog.DEBUG) {
  com.liferay.asset.publisher.web.AutoField.render.soyTemplateName = 'com.liferay.asset.publisher.web.AutoField.render';
}


com.liferay.asset.publisher.web.AutoField.addRuleButton = function(opt_data, opt_ignored) {
  goog.asserts.assert(goog.isString(opt_data.pathThemeImages) || (opt_data.pathThemeImages instanceof goog.soy.data.SanitizedContent), "expected param 'pathThemeImages' of type string|goog.soy.data.SanitizedContent.");
  var pathThemeImages = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.pathThemeImages);
  return soydata.VERY_UNSAFE.ordainSanitizedHtml('<div class="addbutton-timeline-item"><div class="add-condition timeline-increment-icon"><button data-onclick="addRule_" class="btn btn-monospaced btn-primary btn-xs form-builder-timeline-add-item form-builder-rule-add-condition" type="button"><svg class="icon-monospaced lexicon-icon"><use xlink:href="' + soy.$$escapeHtmlAttribute(soy.$$filterNormalizeUri(pathThemeImages)) + '/lexicon/icons.svg#plus"></use></svg></button></div></div>');
};
if (goog.DEBUG) {
  com.liferay.asset.publisher.web.AutoField.addRuleButton.soyTemplateName = 'com.liferay.asset.publisher.web.AutoField.addRuleButton';
}


com.liferay.asset.publisher.web.AutoField.rule = function(opt_data, opt_ignored) {
  goog.asserts.assert(goog.isString(opt_data.categorySelectorURL) || (opt_data.categorySelectorURL instanceof goog.soy.data.SanitizedContent), "expected param 'categorySelectorURL' of type string|goog.soy.data.SanitizedContent.");
  var categorySelectorURL = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.categorySelectorURL);
  goog.asserts.assert(goog.isString(opt_data.groupIds) || (opt_data.groupIds instanceof goog.soy.data.SanitizedContent), "expected param 'groupIds' of type string|goog.soy.data.SanitizedContent.");
  var groupIds = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.groupIds);
  var index = goog.asserts.assertNumber(opt_data.index, "expected parameter 'index' of type int.");
  goog.asserts.assert(opt_data.namespace == null || (opt_data.namespace instanceof goog.soy.data.SanitizedContent) || goog.isString(opt_data.namespace), "expected param 'namespace' of type null|string|undefined.");
  var namespace = /** @type {null|string|undefined} */ (opt_data.namespace);
  goog.asserts.assert(goog.isString(opt_data.pathThemeImages) || (opt_data.pathThemeImages instanceof goog.soy.data.SanitizedContent), "expected param 'pathThemeImages' of type string|goog.soy.data.SanitizedContent.");
  var pathThemeImages = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.pathThemeImages);
  var rule = goog.asserts.assertObject(opt_data.rule, "expected parameter 'rule' of type [queryAndOperator: bool, queryContains: bool, type: string].");
  goog.asserts.assert(goog.isString(opt_data.tagSelectorURL) || (opt_data.tagSelectorURL instanceof goog.soy.data.SanitizedContent), "expected param 'tagSelectorURL' of type string|goog.soy.data.SanitizedContent.");
  var tagSelectorURL = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.tagSelectorURL);
  goog.asserts.assert(goog.isString(opt_data.vocabularyIds) || (opt_data.vocabularyIds instanceof goog.soy.data.SanitizedContent), "expected param 'vocabularyIds' of type string|goog.soy.data.SanitizedContent.");
  var vocabularyIds = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.vocabularyIds);
  return soydata.VERY_UNSAFE.ordainSanitizedHtml('<li class="timeline-item"><div class="panel panel-default"><div class="panel-body"><div class="form-group"><select class="form-control" id="' + soy.$$escapeHtmlAttribute(namespace) + 'queryContains' + soy.$$escapeHtmlAttribute(index) + '" name="' + soy.$$escapeHtmlAttribute(namespace) + 'queryContains' + soy.$$escapeHtmlAttribute(index) + '" title="Query Contains"><option class="" ' + ((rule.queryContains) ? 'selected="selected"' : '') + ' value="true">contains</option><option class="" ' + ((! rule.queryContains) ? 'selected="selected"' : '') + ' value="false">does-not-contain</option></select></div><div class="form-group"><select class="form-control" id="' + soy.$$escapeHtmlAttribute(namespace) + 'queryAndOperator' + soy.$$escapeHtmlAttribute(index) + '" name="' + soy.$$escapeHtmlAttribute(namespace) + 'queryAndOperator' + soy.$$escapeHtmlAttribute(index) + '" title="And Operator"><option class="" ' + ((rule.queryAndOperator) ? 'selected="selected"' : '') + ' value="true">all</option><option class="" ' + ((! rule.queryAndOperator) ? 'selected="selected"' : '') + '>any</option></select></div><div class="form-group"><label class="control-label" for="' + soy.$$escapeHtmlAttribute(namespace + 'queryName' + index) + '">of-the-following</label></div><div class="form-group"><select class="form-control asset-query-name" data-item-index="' + soy.$$escapeHtmlAttribute(index) + '" data-onchange="changeSelector_" id="' + soy.$$escapeHtmlAttribute(namespace + 'queryName' + index) + '" name="' + soy.$$escapeHtmlAttribute(namespace + 'queryName' + index) + '"><option class="" ' + ((rule.type == 'assetCategories') ? 'selected="selected"' : '') + ' value="assetCategories">categories</option><option class="" ' + ((rule.type == 'assetTags') ? 'selected="selected"' : '') + ' value="assetTags">tags</option></select></div>' + ((rule.type == 'assetCategories') ? com.liferay.asset.publisher.web.CategorySelector.render({eventName: namespace + 'selectCategory', groupIds: groupIds, index: index, namespace: namespace, categorySelectorURL: categorySelectorURL, rule: rule, vocabularyIds: vocabularyIds}) : com.liferay.asset.publisher.web.TagSelector.render({eventName: namespace + 'selectTag', groupIds: groupIds, index: index, namespace: namespace, tagSelectorURL: tagSelectorURL, rule: rule})) + '<div class="timeline-increment"><span class="timeline-icon"></span></div></div></div>' + com.liferay.asset.publisher.web.AutoField.trashButton({pathThemeImages: pathThemeImages, ruleId: index}) + '</li>');
};
if (goog.DEBUG) {
  com.liferay.asset.publisher.web.AutoField.rule.soyTemplateName = 'com.liferay.asset.publisher.web.AutoField.rule';
}


com.liferay.asset.publisher.web.AutoField.trashButton = function(opt_data, opt_ignored) {
  goog.asserts.assert(goog.isString(opt_data.pathThemeImages) || (opt_data.pathThemeImages instanceof goog.soy.data.SanitizedContent), "expected param 'pathThemeImages' of type string|goog.soy.data.SanitizedContent.");
  var pathThemeImages = /** @type {string|goog.soy.data.SanitizedContent} */ (opt_data.pathThemeImages);
  var ruleId = goog.asserts.assertNumber(opt_data.ruleId, "expected parameter 'ruleId' of type int.");
  return soydata.VERY_UNSAFE.ordainSanitizedHtml('<div class="container-trash"><button class="btn btn-monospaced btn-link btn-xs condition-card-delete" data-rule-id="' + soy.$$escapeHtmlAttribute(ruleId) + '" data-onclick="deleteRule_" type="button"><svg class="lexicon-icon icon-monospaced"><use xlink:href="' + soy.$$escapeHtmlAttribute(soy.$$filterNormalizeUri(pathThemeImages)) + '/lexicon/icons.svg#trash"></use></svg></button></div>');
};
if (goog.DEBUG) {
  com.liferay.asset.publisher.web.AutoField.trashButton.soyTemplateName = 'com.liferay.asset.publisher.web.AutoField.trashButton';
}

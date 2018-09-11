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

package com.liferay.document.library.web.internal.portlet.action;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.exportimport.changeset.Changeset;
import com.liferay.exportimport.changeset.portlet.action.ExportImportChangesetMVCActionCommand;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileShortcut;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mate Thurzo
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DLPortletKeys.DOCUMENT_LIBRARY_ADMIN,
		"mvc.command.name=/document_library/publish_file_shortcut"
	},
	service = MVCActionCommand.class
)
public class PublishFileShortcutMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		final long fileShortcutId = ParamUtil.getLong(
			actionRequest, "fileShortcutId");

		Changeset.Builder builder = Changeset.create();

		Changeset changeset = builder.addStagedModel(
			() -> _fetchFileShortcut(fileShortcutId)
		).build();

		_exportImportChangesetMVCActionCommand.processPublishAction(
			actionRequest, actionResponse, changeset);
	}

	private FileShortcut _fetchFileShortcut(long fileShortcutId) {
		try {
			return _dlAppLocalService.getFileShortcut(fileShortcutId);
		}
		catch (PortalException pe) {
			if (_log.isDebugEnabled()) {
				_log.debug("Unable to get file shortcut " + fileShortcutId, pe);
			}
		}

		return null;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PublishFileShortcutMVCActionCommand.class);

	@Reference
	private DLAppLocalService _dlAppLocalService;

	@Reference
	private ExportImportChangesetMVCActionCommand
		_exportImportChangesetMVCActionCommand;

}
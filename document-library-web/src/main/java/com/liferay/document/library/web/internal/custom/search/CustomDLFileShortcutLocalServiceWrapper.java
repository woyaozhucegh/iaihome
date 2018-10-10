/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.document.library.web.internal.custom.search;

import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.document.library.kernel.service.DLFileShortcutLocalServiceWrapper;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = ServiceWrapper.class
)

public class CustomDLFileShortcutLocalServiceWrapper extends DLFileShortcutLocalServiceWrapper {

	public CustomDLFileShortcutLocalServiceWrapper() {
		super(null);
	}
//After addFileShortcut to REINDEX ----------------by Tiamo----------------
	@Override
	@Indexable(type = IndexableType.REINDEX)
	public com.liferay.document.library.kernel.model.DLFileShortcut addFileShortcut(
		long userId, long groupId, long repositoryId, long folderId,
		long toFileEntryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
	    System.out.println("This is a DL " + toFileEntryId);    
    
	    return super.addFileShortcut(
	    		userId, groupId, repositoryId, folderId,
	    		toFileEntryId,
	    		serviceContext); 
	}
	//After deleteDLFileShortcut to DELETE index	 ----------------by Tiamo----------------
	@Override
	@Indexable(type = IndexableType.DELETE)
	public com.liferay.document.library.kernel.model.DLFileShortcut deleteDLFileShortcut(
		com.liferay.document.library.kernel.model.DLFileShortcut dlFileShortcut) {
		return super.deleteDLFileShortcut(dlFileShortcut);
	}
	//After updateFileShortcut to REINDEX	
	@Override
	@Indexable(type = IndexableType.REINDEX)
	public com.liferay.document.library.kernel.model.DLFileShortcut updateFileShortcut(
		long userId, long fileShortcutId, long repositoryId, long folderId,
		long toFileEntryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return super.updateFileShortcut(userId,
			fileShortcutId, repositoryId, folderId, toFileEntryId,
			serviceContext);
	}
}
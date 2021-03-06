package com.x.portal.assemble.surface.jaxrs.source;

import com.x.base.core.exception.PromptException;

class PortalAccessDeniedException extends PromptException {

	private static final long serialVersionUID = -4908883340253465376L;

	PortalAccessDeniedException(String person, String name, String id) {
		super("用户: {}, 访问站点: {}, id: {}, 失败,权限不足.", person, name, id);
	}

}

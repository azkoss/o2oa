package com.x.okr.assemble.control.jaxrs.okrworkreportbaseinfo;

import com.x.base.core.exception.PromptException;

class ReportProcessLogListException extends PromptException {

	private static final long serialVersionUID = 1859164370743532895L;

	ReportProcessLogListException( Throwable e, String id ) {
		super("系统根据指定工作汇报ID查询汇报所有的处理记录列表时发生异常。ReportId：" + id, e );
	}
}

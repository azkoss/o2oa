package com.x.okr.assemble.control.jaxrs.okrworkreportdetailinfo;
import java.util.ArrayList;
import java.util.List;

import com.x.base.core.http.annotation.Wrap;
import com.x.okr.entity.OkrWorkReportDetailInfo;
@Wrap( OkrWorkReportDetailInfo.class)
public class WrapOutOkrWorkReportDetailInfo extends OkrWorkReportDetailInfo{

	private static final long serialVersionUID = -5076990764713538973L;

	public static List<String> Excludes = new ArrayList<String>();

	private Long rank = 0L;

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}
	
}

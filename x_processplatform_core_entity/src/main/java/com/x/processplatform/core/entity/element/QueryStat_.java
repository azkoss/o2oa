/** 
 *  Generated by OpenJPA MetaModel Generator Tool.
**/

package com.x.processplatform.core.entity.element;

import com.x.base.core.entity.SliceJpaObject_;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel
(value=com.x.processplatform.core.entity.element.QueryStat.class)
@javax.annotation.Generated
(value="org.apache.openjpa.persistence.meta.AnnotationProcessor6",date="Sat May 06 19:36:06 CST 2017")
public class QueryStat_ extends SliceJpaObject_  {
    public static volatile SingularAttribute<QueryStat,String> alias;
    public static volatile SingularAttribute<QueryStat,String> application;
    public static volatile ListAttribute<QueryStat,String> availableCompanyList;
    public static volatile ListAttribute<QueryStat,String> availableDepartmentList;
    public static volatile ListAttribute<QueryStat,String> availableIdentityList;
    public static volatile ListAttribute<QueryStat,String> availablePersonList;
    public static volatile ListAttribute<QueryStat,String> controllerList;
    public static volatile SingularAttribute<QueryStat,Date> createTime;
    public static volatile SingularAttribute<QueryStat,String> creatorPerson;
    public static volatile SingularAttribute<QueryStat,String> data;
    public static volatile SingularAttribute<QueryStat,String> description;
    public static volatile SingularAttribute<QueryStat,String> icon;
    public static volatile SingularAttribute<QueryStat,String> id;
    public static volatile SingularAttribute<QueryStat,String> lastUpdatePerson;
    public static volatile SingularAttribute<QueryStat,Date> lastUpdateTime;
    public static volatile SingularAttribute<QueryStat,String> layout;
    public static volatile SingularAttribute<QueryStat,String> name;
    public static volatile SingularAttribute<QueryStat,String> queryView;
    public static volatile SingularAttribute<QueryStat,String> queryViewAlias;
    public static volatile SingularAttribute<QueryStat,String> queryViewName;
    public static volatile SingularAttribute<QueryStat,String> result;
    public static volatile SingularAttribute<QueryStat,String> sequence;
    public static volatile SingularAttribute<QueryStat,Boolean> timingEnable;
    public static volatile SingularAttribute<QueryStat,Integer> timingInterval;
    public static volatile SingularAttribute<QueryStat,Date> updateTime;
}

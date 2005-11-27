/*
 * Created on 2005/11/06
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.seasar.s2sqlmap;

import java.io.IOException;
import java.util.Properties;

import com.ibatis.db.sqlmap.SqlMap;

/**
 * SqlMapConfigはSqlMap生成インターフェースです。
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public interface SqlMapConfig
{
    void setConfigLocation(String configLocation);

    void setSqlMapProperties(Properties sqlMapProperties);

    void init() throws IOException;

    SqlMap getSqlMap();
}
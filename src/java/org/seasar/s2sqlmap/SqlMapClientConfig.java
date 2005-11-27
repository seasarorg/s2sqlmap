/*
 * Created on 2005/11/06
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.seasar.s2sqlmap;

import java.util.Properties;

import javax.sql.DataSource;

import org.seasar.s2sqlmap.spring.lob.port.LobHandler;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * SqlMapClientConfigはSqlMapClient生成インターフェースです。
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public interface SqlMapClientConfig
{
 
    void setConfigLocation(String configLocation);
 
    void setSqlMapClientProperties(Properties sqlMapClientProperties);
 
    void setDataSource(DataSource dataSource);
 
    void setUseTransactionAwareDataSource(boolean useTransactionAwareDataSource);
 
    void setTransactionConfigClass(Class transactionConfigClass);
 
    void setTransactionConfigProperties(Properties transactionConfigProperties);
 
    void setLobHandler(LobHandler lobHandler);

    void init() throws Exception;

    SqlMapClient getSqlMapClient();

    Object getObject();
}
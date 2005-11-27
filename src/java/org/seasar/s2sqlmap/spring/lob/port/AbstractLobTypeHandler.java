/*
 * Copyright 2002-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.seasar.s2sqlmap.spring.lob.port;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.seasar.s2sqlmap.S2SqlMapClientConfig;

import com.ibatis.sqlmap.engine.type.BaseTypeHandler;

/**
 * Spring FrameworkÇ©ÇÁSeasarÇ÷ÇÃà⁄êAî≈Ç≈Ç∑ÅB
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public abstract class AbstractLobTypeHandler extends BaseTypeHandler {

	private LobHandler lobHandler;


	public AbstractLobTypeHandler() {
		this(S2SqlMapClientConfig.getConfigTimeLobHandler());
	}

	protected AbstractLobTypeHandler(LobHandler lobHandler) {
		if (lobHandler == null) {
			throw new IllegalStateException("No LobHandler found for configuration - " +
			    "lobHandler property must be set on SqlMapClientFactoryBean");
		}
		this.lobHandler = lobHandler;
	}

	public final void setParameter(PreparedStatement ps, int i, Object parameter, String jdbcType)
			throws SQLException {
		final LobCreator lobCreator = this.lobHandler.getLobCreator();
		try {
			setParameterInternal(ps, i, parameter, jdbcType, lobCreator);
		}
		catch (IOException ex) {
			throw new SQLException("I/O errors during LOB access: " + ex.getMessage());
		}
	}

	public final Object getResult(ResultSet rs, String columnName) throws SQLException {
		return getResult(rs, rs.findColumn(columnName));
	}

	public final Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		try {
			return getResultInternal(rs, columnIndex, this.lobHandler);
		}
		catch (IOException ex) {
			throw new SQLException(
					"I/O errors during LOB access: " + ex.getClass().getName() + ": " + ex.getMessage());
		}
	}

	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		throw new SQLException("Retrieving LOBs from a CallableStatement is not supported");
	}

	protected abstract void setParameterInternal(
			PreparedStatement ps, int index, Object value, String jdbcType, LobCreator lobCreator)
			throws SQLException, IOException;

	protected abstract Object getResultInternal(ResultSet rs, int index, LobHandler lobHandler)
			throws SQLException, IOException;

}

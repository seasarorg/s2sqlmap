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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Spring FrameworkからSeasarへの移植版です。
 *
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class BlobByteArrayTypeHandler extends AbstractLobTypeHandler {

	public BlobByteArrayTypeHandler() {
		super();
	}

	protected BlobByteArrayTypeHandler(LobHandler lobHandler) {
		super(lobHandler);
	}

	protected void setParameterInternal(
			PreparedStatement ps, int index, Object value, String jdbcType, LobCreator lobCreator)
			throws SQLException {
		lobCreator.setBlobAsBytes(ps, index, (byte[]) value);
	}

	protected Object getResultInternal(ResultSet rs, int index, LobHandler lobHandler)
			throws SQLException {
		return lobHandler.getBlobAsBytes(rs, index);
	}

	public Object valueOf(String s) {
		return s.getBytes();
	}
}

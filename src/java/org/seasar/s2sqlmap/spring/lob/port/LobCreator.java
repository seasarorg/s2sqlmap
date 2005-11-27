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

import java.io.InputStream;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Spring FrameworkÇ©ÇÁSeasarÇ÷ÇÃà⁄êAî≈Ç≈Ç∑ÅB
 */
public interface LobCreator {

	void setBlobAsBytes(PreparedStatement ps, int paramIndex, byte[] content)
	    throws SQLException;

	void setBlobAsBinaryStream(
			PreparedStatement ps, int paramIndex, InputStream contentStream, int contentLength)
	    throws SQLException;

	void setClobAsString(PreparedStatement ps, int paramIndex, String content)
	    throws SQLException;

	void setClobAsAsciiStream(
			PreparedStatement ps, int paramIndex, InputStream asciiStream, int contentLength)
	    throws SQLException;

	void setClobAsCharacterStream(
			PreparedStatement ps, int paramIndex, Reader characterStream, int contentLength)
	    throws SQLException;

	void close();
}

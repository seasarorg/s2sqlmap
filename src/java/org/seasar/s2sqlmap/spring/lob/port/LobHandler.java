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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Spring FrameworkÇ©ÇÁSeasarÇ÷ÇÃà⁄êAî≈Ç≈Ç∑ÅB
 */
public interface LobHandler {

	byte[] getBlobAsBytes(ResultSet rs, String columnName) throws SQLException;

	byte[] getBlobAsBytes(ResultSet rs, int columnIndex) throws SQLException;

	InputStream getBlobAsBinaryStream(ResultSet rs, String columnName) throws SQLException;

	InputStream getBlobAsBinaryStream(ResultSet rs, int columnIndex) throws SQLException;

	String getClobAsString(ResultSet rs, String columnName) throws SQLException;

	String getClobAsString(ResultSet rs, int columnIndex) throws SQLException;

	InputStream getClobAsAsciiStream(ResultSet rs, String columnName) throws SQLException;

	InputStream getClobAsAsciiStream(ResultSet rs, int columnIndex) throws SQLException;

	Reader getClobAsCharacterStream(ResultSet rs, String columnName) throws SQLException;

	Reader getClobAsCharacterStream(ResultSet rs, int columnIndex) throws SQLException;

	LobCreator getLobCreator();
}

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
package org.seasar.s2sqlmap.exception.port;

 
/**
 * Spring FrameworkからSeasarへの移植版向け例外です。
 * JDBCの更新処理が時に予期しない数の行数に影響を及ぼした場合にスローされます。
 * 典型的な例として単一の行に対しての更新に対して複数列に影響を及ぼした場合の
 * エラーを意味します。
 * @author $Author:$
 * @version $Revision:$
 */
public class JdbcUpdateAffectedIncorrectNumberOfRowsException extends RuntimeException {
	
	private int expected;
	
	private int actual;

	public JdbcUpdateAffectedIncorrectNumberOfRowsException(String sql, int expected, int actual) {
		super("SQL update '" + sql + "' affected " + actual + " rows, not " + expected + " as expected");
		this.expected = expected;
		this.actual = actual;
	}

	public int getExpectedRowsAffected() {
		return expected;
	}
	
	public int getActualRowsAffected() {
		return actual;
	}

	public boolean wasDataUpdated() {
		return getActualRowsAffected() > 0;
    }
}

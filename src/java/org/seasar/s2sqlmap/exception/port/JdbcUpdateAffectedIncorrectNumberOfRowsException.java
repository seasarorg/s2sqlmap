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
 * Spring Framework����Seasar�ւ̈ڐA�Ō�����O�ł��B
 * JDBC�̍X�V���������ɗ\�����Ȃ����̍s���ɉe�����y�ڂ����ꍇ�ɃX���[����܂��B
 * �T�^�I�ȗ�Ƃ��ĒP��̍s�ɑ΂��Ă̍X�V�ɑ΂��ĕ�����ɉe�����y�ڂ����ꍇ��
 * �G���[���Ӗ����܂��B
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

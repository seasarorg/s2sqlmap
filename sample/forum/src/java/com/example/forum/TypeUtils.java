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
package com.example.forum;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * �ȈՂ̌^�ϊ����[�e�B���e�B�[�N���X�ł��B
 * @author $Author: gwatsman $
 * @version $Revision: 1.1 $
 */
public final class TypeUtils
{
    private static Log log = LogFactory.getLog(TypeUtils.class);
    
    private TypeUtils(){}

    /**
     * �������int�^�Ƃ��Ĕ�r���܂��B
     * @param a �Ώ�a.
     * @param b �Ώ�b.
     * @return �\�[�g�ɗp�������r�l�B
     */
    public static int compareInt(final String a, final String b) {
        return toInt(b, 0) - toInt(a, 0);
    }

    /**
     * �������int�^�֕ϊ����܂��B�ϊ��Ɏ��s�����ꍇ�̓f�t�H���g�l��
     * ���p����܂��B
     * @param intString �Ώە�����B
     * @param defaultValue �f�t�H���g�l�B
     * @return �ϊ����ꂽint�^�̒l�B
     */
    public static int toInt(String intString, int defaultValue) {
        if (intString == null || intString.length() == 0) {
            return defaultValue;
        }

        int intValue = defaultValue;
        try {
            intValue = Integer.parseInt(intString);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return intValue;
    }

    /**
     * �������long�^�Ƃ��Ĕ�r���܂��B
     * @param a �Ώ�a.
     * @param b �Ώ�b.
     * @return �\�[�g�ɗp�������r�l�B
     */
    public static int compareLong(String a, String b) {
        long d = toLong(b, 0) - toLong(a, 0);
        if (d == 0)
            return 0;
        else if(d < 0)
            return -1;
        else 
            return 1;
    }

    /**
     * �������long�^�ɕϊ����܂��B
     * @param longString �Ώە�����B
     * @param defaultValue �f�t�H���g�l�B
     * @return �ϊ����ꂽlong�^�̒l�B
     */
    public static long toLong(String longString, long defaultValue) {
        if (longString == null || longString.length() == 0) {
            return defaultValue;
        }

        long longValue = defaultValue;
        try {
            longValue = Long.parseLong(longString);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return longValue;
    }

    /**
     * �������float�^�Ƃ��Ĕ�r���܂��B
     * @param a �Ώ�a.
     * @param b �Ώ�b.
     * @return �\�[�g�ɗp�������r�l�B
     */
    public static float compareFloat(String a, String b) {
        double d = toFloat(b, 0) - toFloat(a, 0);
        if (d == 0.0)
            return 0;
        else if(d < 0.0)
            return -1;
        else 
            return 1;
    }

    /**
     * �������float�^�ɕϊ����܂��B
     * @param floatString �Ώە�����B
     * @param defaultValue �f�t�H���g�l�B
     * @return �ϊ����ꂽfloat�^�̒l�B
     */
    public static float toFloat(String floatString, float defaultValue) {

        if (floatString == null || floatString.length() == 0) {
            return defaultValue;
        }

        float floatValue = defaultValue;
        try {
            floatValue = Float.parseFloat(floatString);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return floatValue;
    }

    /**
     * �������double�^�Ƃ��Ĕ�r���܂��B
     * @param a �Ώ�a.
     * @param b �Ώ�b.
     * @return �\�[�g�ɗp�������r�l�B
     */
    public static double compareDouble(String a, String b) {
        double d = toDouble(b, 0) - toDouble(a, 0);
        if (d == 0.0)
            return 0;
        else if(d < 0.0)
            return -1;
        else 
            return 1;
    }

    /**
     * �������double�^�ɕϊ����܂��B
     * @param doubleString �Ώە�����B
     * @param defaultValue �f�t�H���g�l�B
     * @return �ϊ����ꂽdouble�^�̒l�B
     */
    public static double toDouble(String doubleString, double defaultValue) {
        if (doubleString == null || doubleString.length() == 0) {
            return defaultValue;
        }

        double doubleValue = defaultValue;
        try {
            doubleValue = Double.parseDouble(doubleString);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return doubleValue;
    }

    /**
     * �������short�^�Ƃ��Ĕ�r���܂��B
     * @param a �Ώ�a.
     * @param b �Ώ�b.
     * @return �\�[�g�ɗp�������r�l�B
     */
    public static int compareShort(String a, String b) {
        return (int) (toShort(b, (short) 0) - toShort(a, (short) 0));
    }

    /**
     * �������short�^�ɕϊ����܂��B
     * @param shortString �Ώە�����B
     * @param defaultValue �f�t�H���g�l�B
     * @return �ϊ����ꂽshort�^�̒l�B
     */
    public static short toShort(String shortString, short defaultValue) {
        if (shortString == null || shortString.length() == 0) {
            return defaultValue;
        }

        short shortValue = defaultValue;
        try {
            shortValue = Short.parseShort(shortString);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return shortValue;
    }

    /**
     * �������byte�^�Ƃ��Ĕ�r���܂��B
     * @param a �Ώ�a.
     * @param b �Ώ�b.
     * @return �\�[�g�ɗp�������r�l�B
     */
    public static int compareByte(String a, String b) {
        return (int) (toByte(b, (byte) 0) - toByte(a, (byte) 0));
    }

    /**
     * �������byte�^�ɕϊ����܂��B
     * @param byteString �Ώە�����B
     * @param defaultValue �f�t�H���g�l�B
     * @return �ϊ����ꂽbyte�^�̒l�B
     */
    public static byte toByte(String byteString, byte defaultValue) {
        if (byteString == null || byteString.length() == 0) {
            return defaultValue;
        }

        byte byteValue = defaultValue;
        try {
            byteValue = Byte.parseByte(byteString);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return byteValue;
    }
 
    /**
     * �������boolean�^�ɕϊ����܂��B
     * @param value �Ώە�����B
     * @param defaultValue �f�t�H���g�l�B
     * @return �ϊ����ꂽboolean�^�̒l�B
     */
    public static boolean toBoolean(String value, boolean defaultValue) {

        if (!defaultValue) {
            if (value == null)
                return defaultValue;
            else if (value.equalsIgnoreCase("true"))
                return true;
            else if (value.equalsIgnoreCase("yes"))
                return true;
            else if (value.equalsIgnoreCase("on"))
                return true;
            else 
                return value.equalsIgnoreCase("y");
        } else {
            if (value == null)
                return defaultValue;
            else if (value.equalsIgnoreCase("false"))
                return false;
            else if (value.equalsIgnoreCase("no"))
                return false;
            else if (value.equalsIgnoreCase("off"))
                return false;
            else 
                return !value.equalsIgnoreCase("n");
        }
    }
}

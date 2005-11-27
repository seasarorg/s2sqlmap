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
 * 簡易の型変換ユーティリティークラスです。
 * @author $Author: gwatsman $
 * @version $Revision: 1.1 $
 */
public final class TypeUtils
{
    private static Log log = LogFactory.getLog(TypeUtils.class);
    
    private TypeUtils(){}

    /**
     * 文字列をint型として比較します。
     * @param a 対象a.
     * @param b 対象b.
     * @return ソートに用いられる比較値。
     */
    public static int compareInt(final String a, final String b) {
        return toInt(b, 0) - toInt(a, 0);
    }

    /**
     * 文字列をint型へ変換します。変換に失敗した場合はデフォルト値が
     * 利用されます。
     * @param intString 対象文字列。
     * @param defaultValue デフォルト値。
     * @return 変換されたint型の値。
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
     * 文字列をlong型として比較します。
     * @param a 対象a.
     * @param b 対象b.
     * @return ソートに用いられる比較値。
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
     * 文字列をlong型に変換します。
     * @param longString 対象文字列。
     * @param defaultValue デフォルト値。
     * @return 変換されたlong型の値。
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
     * 文字列をfloat型として比較します。
     * @param a 対象a.
     * @param b 対象b.
     * @return ソートに用いられる比較値。
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
     * 文字列をfloat型に変換します。
     * @param floatString 対象文字列。
     * @param defaultValue デフォルト値。
     * @return 変換されたfloat型の値。
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
     * 文字列をdouble型として比較します。
     * @param a 対象a.
     * @param b 対象b.
     * @return ソートに用いられる比較値。
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
     * 文字列をdouble型に変換します。
     * @param doubleString 対象文字列。
     * @param defaultValue デフォルト値。
     * @return 変換されたdouble型の値。
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
     * 文字列をshort型として比較します。
     * @param a 対象a.
     * @param b 対象b.
     * @return ソートに用いられる比較値。
     */
    public static int compareShort(String a, String b) {
        return (int) (toShort(b, (short) 0) - toShort(a, (short) 0));
    }

    /**
     * 文字列をshort型に変換します。
     * @param shortString 対象文字列。
     * @param defaultValue デフォルト値。
     * @return 変換されたshort型の値。
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
     * 文字列をbyte型として比較します。
     * @param a 対象a.
     * @param b 対象b.
     * @return ソートに用いられる比較値。
     */
    public static int compareByte(String a, String b) {
        return (int) (toByte(b, (byte) 0) - toByte(a, (byte) 0));
    }

    /**
     * 文字列をbyte型に変換します。
     * @param byteString 対象文字列。
     * @param defaultValue デフォルト値。
     * @return 変換されたbyte型の値。
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
     * 文字列をboolean型に変換します。
     * @param value 対象文字列。
     * @param defaultValue デフォルト値。
     * @return 変換されたboolean型の値。
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

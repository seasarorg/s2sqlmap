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
package org.seasar.s2sqlmap;

import java.io.InputStream;

/**
 * ResourceUtilsはResourceの代替を提供するユーティリティークラスです。
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class ResourceUtils
{
    /**
     * パッケージリソースを取得します。物理的なリソース位置に現在対応していません。
     * @param confingLocation 設定ファイルのパス。
     * @return リソースに対応するInputStreamのインスタンス。リソースが存在しない場合はNULLを戻り値とします。
     */
    public static InputStream getInputStream(
            String confingLocation){
        return ResourceUtils.class.getResourceAsStream(confingLocation);
    }
}

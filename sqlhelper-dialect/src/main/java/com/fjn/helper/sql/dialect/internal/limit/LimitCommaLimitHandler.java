/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the LGPL, Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at  http://www.gnu.org/licenses/lgpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fjn.helper.sql.dialect.internal.limit;

import com.fjn.helper.sql.dialect.RowSelection;

/**
 *  select * from TABLE where xxx
 *  limit $offset, $limit
 */
public class LimitCommaLimitHandler extends AbstractLimitHandler {

    @Override
    public String processSql(String sql, RowSelection rowSelection) {
        return getLimitString(sql, LimitHelper.hasFirstRow(rowSelection));
    }

    @Override
    protected String getLimitString(String sql, boolean hasOffset) {
        return sql + (hasOffset ? " limit ?, ?" : " limit ?");
    }

}
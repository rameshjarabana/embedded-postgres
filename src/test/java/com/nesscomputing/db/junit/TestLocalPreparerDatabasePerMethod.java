/**
 * Copyright (C) 2012 Ness Computing, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nesscomputing.db.junit;


import org.junit.Assert;
import org.junit.Rule;
import org.skife.jdbi.v2.DBI;

import com.google.common.io.Resources;
import com.nesscomputing.db.postgres.junit.LocalPostgresPreparerTestRule;
import com.nesscomputing.db.postgres.junit.PostgresRules;

public class TestLocalPreparerDatabasePerMethod extends AbstractPreparerTests
{
    @Rule
    public final LocalPostgresPreparerTestRule database = PostgresRules.databasePreparerRule(Resources.getResource(PostgresRules.class, "/sql/"), "simple");

    @Override
    public DBI getDbi()
    {
        Assert.assertNotNull(database);
        final DBI dbi = database.getDbi();
        Assert.assertNotNull(dbi);
        return dbi;
    }
}

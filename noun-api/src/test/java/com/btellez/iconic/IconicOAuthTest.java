/*
 * Copyright 2014 Bladymir Tellez
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.btellez.iconic;

import com.btellez.iconic.model.ApiKeys;
import com.btellez.iconic.model.Responses;
import org.junit.Assert;
import org.junit.Test;

public class IconicOAuthTest {

    @Test
    public void testSuccessfullResponse() {
        ApiKeys keys = new ApiKeys("fill-in-key","fill-in-secret");
        TheNounProjectService api = IconicNounAPI.getInstance(keys).getService();
        Responses.RecentUploads uploads = api.iconsRecentUploads();
        Assert.assertNotNull(uploads.recent_uploads);
        Assert.assertNotEquals(0, uploads.recent_uploads.size());
    }
}

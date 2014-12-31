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
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import se.akerfeldt.signpost.retrofit.RetrofitHttpOAuthConsumer;
import se.akerfeldt.signpost.retrofit.SigningOkClient;

public class IconicNounAPI {

    private TheNounProjectService service;

    private static final String baseUrl = "http://api.thenounproject.com/";
    private static IconicNounAPI instance;

    private IconicNounAPI(ApiKeys apiKeys) {
        RetrofitHttpOAuthConsumer oAuthConsumer = new RetrofitHttpOAuthConsumer(apiKeys.getKey(), apiKeys.getSecret());
        final RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setClient(new SigningOkClient(oAuthConsumer));
        RestAdapter restAdapter = builder.build();
        service = restAdapter.create(TheNounProjectService.class);
    }

    public static IconicNounAPI getInstance(ApiKeys apiKeys) {
        if (instance == null) {
            instance = new IconicNounAPI(apiKeys);
        }
        return instance;
    }

    public TheNounProjectService getService() {
        return service;
    }
}

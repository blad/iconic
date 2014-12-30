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
import com.squareup.okhttp.OkHttpClient;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class IconicNounAPI {

    private ApiKeys apiKeys;
    private TheNounProjectService service;

    private static final String baseUrl = "http://api.thenounproject.com/";
    private static IconicNounAPI instance;

    public IconicNounAPI() {

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setClient(new OkClient(new OkHttpClient()));

        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                IconicOAuth auth = new IconicOAuth(apiKeys);
                request.addHeader("Accept", "application/json");
                request.addHeader("Authorization", auth.getOAuthHeader());
            }
        });

        RestAdapter restAdapter = builder.build();
        service = restAdapter.create(TheNounProjectService.class);
    }

    public static IconicNounAPI getInstance(ApiKeys apiKeys) {
        if (instance == null) {
            instance = new IconicNounAPI();
        }
        instance.setApiKeys(apiKeys);
        return instance;
    }

    private void setApiKeys(ApiKeys apiKeys) {
        this.apiKeys = apiKeys;
    }

    public TheNounProjectService getService() {
        return service;
    }
}

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

import com.btellez.iconic.model.ApiUsage;
import com.btellez.iconic.model.Responses;
import retrofit.http.GET;
import retrofit.http.Path;

public interface TheNounProjectService {
    @GET("/collections")
    public Responses.Collections collections();

    @GET("/collection/{id}/icons")
    public Responses.Icons collectionIcons(@Path("id") int id);

    @GET("/collection/{slug}/icons")
    public Responses.Icons collectionIcons(@Path("slug") String slug);

    @GET("/collection/{id}")
    public Responses.Collection collectionid(@Path("id") int id);

    @GET("/collection/{slug}")
    public Responses.Collection collectionSlug(@Path("slug") String slug);

    @GET("/icon/{id}")
    public Responses.Icon iconId(@Path("id") int id);

    @GET("/icon/{term}")
    public Responses.Icon iconTerm(@Path("term") String term);

    @GET("/icons/recent_uploads")
    public Responses.RecentUploads iconsRecentUploads();

    @GET("/icons/{term}")
    public Responses.Icons icons(@Path("term") String term);

    @GET("/oauth/usage")
    public ApiUsage oauthUsage();

    @GET("/user/{user_id}/collections/{slug}")
    public Responses.Collection userCollections(@Path("user_id") int userId, @Path("slug") String slug);

    @GET("/user/{user_id}/collections")
    public Responses.Collections userCollections(@Path("user_id") int userId);

    @GET("/user/{username}/uploads")
    public Responses.Uploads userUploads(@Path("username") String username);
}

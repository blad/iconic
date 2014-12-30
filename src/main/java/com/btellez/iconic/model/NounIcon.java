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

package com.btellez.iconic.model;

import java.util.List;

public class NounIcon {
    private String attribution;
    private List<NounCollection> collections;
    private String count_purchase;
    private String count_view;
    private String count_download;
    private String date_uploaded;
    private String id;
    private String is_active;
    private String license_description;
    private String permalink;
    private String preview_url;
    private String preview_url_84;
    private String preview_url_42;
    private String sponsor_campaign_link;
    private String sponsor;
    private String sponsor_id;
    private String term;
    private String term_slug;
    private String term_id;
    private String year;
    private NounAuthor uploader;
    private String uploader_id;

    public String getAttribution() {
        return attribution;
    }

    public List<NounCollection> getCollections() {
        return collections;
    }

    public String getCount_purchase() {
        return count_purchase;
    }

    public String getCount_view() {
        return count_view;
    }

    public String getCount_download() {
        return count_download;
    }

    public String getDate_uploaded() {
        return date_uploaded;
    }

    public String getId() {
        return id;
    }

    public String getIs_active() {
        return is_active;
    }

    public String getLicense_description() {
        return license_description;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public String getPreview_url_84() {
        return preview_url_84;
    }

    public String getPreview_url_42() {
        return preview_url_42;
    }

    public String getSponsor_campaign_link() {
        return sponsor_campaign_link;
    }

    public String getSponsor() {
        return sponsor;
    }

    public String getSponsor_id() {
        return sponsor_id;
    }

    public String getTerm() {
        return term;
    }

    public String getTerm_slug() {
        return term_slug;
    }

    public String getTerm_id() {
        return term_id;
    }

    public String getYear() {
        return year;
    }

    public NounAuthor getUploader() {
        return uploader;
    }

    public String getUploader_id() {
        return uploader_id;
    }
}

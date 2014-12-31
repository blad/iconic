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

public class NounCollection {
    private NounAuthor author;
    private String author_id;
    private String date_created;
    private String date_updated;
    private String description;
    private String icon_count;
    private String id;
    private String is_featured;
    private String is_published;
    private String is_store_item;
    private String name;
    private String slug;
    private String permalink;
    private String sponsor_campaign_link;
    private NounSponsor sponsor;
    private String sponsor_id;
    private String template;
    private List<String> tags;

    public NounAuthor getAuthor() {
        return author;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getDate_created() {
        return date_created;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon_count() {
        return icon_count;
    }

    public String getId() {
        return id;
    }

    public String getIs_featured() {
        return is_featured;
    }

    public String getIs_published() {
        return is_published;
    }

    public String getIs_store_item() {
        return is_store_item;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getSponsor_campaign_link() {
        return sponsor_campaign_link;
    }

    public NounSponsor getSponsor() {
        return sponsor;
    }

    public String getSponsor_id() {
        return sponsor_id;
    }

    public String getTemplate() {
        return template;
    }

    public List<String> getTags() {
        return tags;
    }
}

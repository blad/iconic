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

public class Responses {
    public static class Collection {
        public NounCollection  collection;
    }

    public static class Collections {
        public List<NounCollection> collections;
    }

    public static class Icons {
        public String generated_at;
        public List<NounIcon> icons;
    }

    public static class Icon {
        public NounIcon icon;
    }

    public static class RecentUploads {
        public String generated_at;
        public List<NounIcon> recent_uploads;
    }

    public static class Uploads {
        public String generated_at;
        public List<NounIcon> uploads;
    }
}

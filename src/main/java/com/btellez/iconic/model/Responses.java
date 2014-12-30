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
        NounCollection  collection;
    }

    public static class Collections {
        List<NounCollection> collections;
    }

    public static class Icons {
        String generated_at;
        List<NounIcon> icons;
    }

    public static class Icon {
        NounIcon icon;
    }

    public static class RecentUploads {
        String generated_at;
        List<NounIcon> recent_uploads;
    }

    public static class Uploads {
        String generated_at;
        List<NounIcon> uploads;
    }
}

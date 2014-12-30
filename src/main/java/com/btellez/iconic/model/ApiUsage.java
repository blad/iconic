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

public class ApiUsage {
    private UsageMetrics usage;
    private UsageMetrics limits;

    public UsageMetrics getUsage() {
        return usage;
    }

    public UsageMetrics getLimits() {
        return limits;
    }

    public class UsageMetrics {
        private int hourly;
        private int daily;
        private int monthly;

        public int getHourly() {
            return hourly;
        }

        public int getDaily() {
            return daily;
        }

        public int getMonthly() {
            return monthly;
        }
    }
}

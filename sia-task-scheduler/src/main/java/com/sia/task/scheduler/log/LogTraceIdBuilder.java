/*-
 * <<
 * task
 * ==
 * Copyright (C) 2019 - 2020 sia
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package com.sia.task.scheduler.log;

/**
 * @author maozhengwei
 * @version V1.0.0
 * @data 2019-11-07 17:58
 * @see
 **/
public class LogTraceIdBuilder {

    private static LogTraceIdGenerator logTraceIdGenerator;

    static {
        logTraceIdGenerator = new LogTraceIdUUIDGenerator();
    }

    public static LogTraceIdGenerator build(LogTraceIdGenerator logTraceIdGenerator) {
        return logTraceIdGenerator;
    }

    public static String buildLogTraceId(String key) {
        return logTraceIdGenerator.generateTraceId(key);
    }
}

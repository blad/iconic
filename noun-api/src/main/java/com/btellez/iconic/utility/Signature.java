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

package com.btellez.iconic.utility;

import javafx.util.Pair;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class Signature {

    private static final String AMP = "&";
    private static final String EQ = "=";

    public static String getParameterString(List<Pair<String, String>> headerList) {
        StringBuffer paramsString = new StringBuffer();
        for (Pair<String, String> set : headerList) {
            paramsString.append(encode(set.getKey())).append(EQ)
                    .append(encode(set.getValue())).append(AMP);
        }
        return paramsString.subSequence(0, paramsString.length() - 1).toString(); // trim extra ampersand
    }

    public static String encode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return s;
        }
    }


    public static String calculateSignature(String key, String data)
    {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            SecretKeySpec secret = new SecretKeySpec(key.getBytes("UTF-8"), mac.getAlgorithm());
            mac.init(secret);
            byte[] digest = mac.doFinal(data.getBytes());
            return new BASE64Encoder().encode(digest);
        } catch (Exception e) {
            return "";
        }
    }
}

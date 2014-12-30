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
import javafx.util.Pair;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IconicOAuth {

    public enum RequestType {GET, POST}

    private static final String AMP = "&";
    private static final String EQ = "=";

    private ApiKeys keys;
    private String endpoint;
    private RequestType requestType;

    public IconicOAuth(ApiKeys keys) {
        this.keys = keys;
    }

    public IconicOAuth withEnpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public IconicOAuth withRequestType(RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    public String getOAuthHeader() {
        assertReady(endpoint, requestType);
        List<Pair<String, String>> oAuthHeaderList = new ArrayList<Pair<String, String>>();
        oAuthHeaderList.add(new Pair<String, String>("oauth_signature_method", "HMAC-SHA1"));
        oAuthHeaderList.add(new Pair<String, String>("oauth_version", "1.0"));
        oAuthHeaderList.add(new Pair<String, String>("oauth_consumer_key", keys.getKey()));
        oAuthHeaderList.add(new Pair<String, String>("oauth_nonce", getNounce(32)));
        oAuthHeaderList.add(new Pair<String, String>("oauth_timestamp", String.valueOf(System.currentTimeMillis()/1000)));

        String signature = computeSignature(sortOAuthHeaderParams(oAuthHeaderList));
        oAuthHeaderList.add(new Pair<String, String>("oauth_signature", encode(signature)));
        return "OAuth "+ getOAuthheaderString(sortOAuthHeaderParams(oAuthHeaderList));
    }

    private void assertReady(String endpoint, RequestType requestType) {
        if (isEmpty(endpoint) || requestType == null) {
            throw new IllegalArgumentException("Endpoint and Request type are both required fields.");
        }
    }

    private String getOAuthheaderString(List<Pair<String, String>> headerList) {
        StringBuffer sb = new StringBuffer();
        for (Pair<String, String> headers : headerList) {
            sb.append(String.format("%s=\"%s\", ", headers.getKey(), headers.getValue()));
        }
        return sb.subSequence(0, sb.length()-2).toString(); // trim extra space and comma.;
    }

    protected String computeSignature(List<Pair<String, String>> headerList) {
        String baseString = requestType.name().toUpperCase() + AMP;
        baseString += encode(endpoint) + AMP;
        baseString += encode(getParamString(headerList));
        return calculateHMACSHA1(getSignatureKey(), baseString);
    }

    private String getParamString(List<Pair<String, String>> headerList) {
        StringBuffer paramsString = new StringBuffer();
        for (Pair<String, String> set : headerList) {
            paramsString.append(encode(set.getKey())).append(EQ)
                    .append(encode(set.getValue())).append(AMP);
        }
        return paramsString.subSequence(0, paramsString.length() - 1).toString(); // trim extra ampersand
    }

    // Utility Methods

    private String getSignatureKey() {
        return encode(keys.getSecret()) + AMP;
    }


    private String getNounce(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder(32);

        for(int i = 0; i < length; i++) {
            result.append(alphabet.charAt((int) Math.floor(Math.random() * alphabet.length())));
        }
        return result.toString();
    }

    private String encode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return s;
        }
    }

    private List<Pair<String, String>> sortOAuthHeaderParams(List<Pair<String, String>> headerList) {
        Collections.sort(headerList, new Comparator<Pair<String, String>>() {
            @Override
            public int compare(Pair<String, String> lhs, Pair<String, String> rhs) {
                return lhs.getKey().compareTo(rhs.getKey());
            }
        });
        return headerList;
    }

    private String calculateHMACSHA1(String key, String data)
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

    private boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
}

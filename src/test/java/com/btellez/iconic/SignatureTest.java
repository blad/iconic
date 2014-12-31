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

import com.btellez.iconic.utility.Signature;
import org.junit.Assert;
import org.junit.Test;

public class SignatureTest {

    @Test
    public void testEncoding() {
        // Assert characters encoded
        Assert.assertEquals("%3A%2F%2F%3F%26", Signature.encode("://?&"));

        // Assert unchanged characters
        String alphabet = "abcdefghijklmnopqrstuvwxyZABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Assert.assertEquals(alphabet, Signature.encode(alphabet));
    }

    @Test
    public void testCalculateSignature() {
        String key = "123abc";
        String data = "POST&"+ Signature.encode("http://www.google.com") +"&data";
        Assert.assertEquals("I8+NcrptJJ7yXjmBNg2HQTouGMQ=", Signature.calculateSignature(key, data));
    }
}

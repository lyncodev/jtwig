/**
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

package com.lyncode.jtwig.unit.util.render;

import com.lyncode.jtwig.util.render.RenderHttpServletRequest;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class RenderHttpServletRequestTest {
    private HttpServletRequest originalRequest = mock(HttpServletRequest.class);

    @Test
    public void testName() throws Exception {
        when(originalRequest.getLocalAddr()).thenReturn("A");
        RenderHttpServletRequest servletRequest = new RenderHttpServletRequest(originalRequest);

        reset(originalRequest);
        when(originalRequest.getLocalAddr()).thenReturn("B");


        assertThat(servletRequest.getLocalAddr(), equalTo("A"));
    }
}

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

package org.jtwig.acceptance.issues;

import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;
import org.jtwig.AbstractJtwigTest;
import org.jtwig.exception.RenderException;
import static org.jtwig.util.SyntacticSugar.given;
import static org.jtwig.util.SyntacticSugar.then;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Issue76Test extends AbstractJtwigTest {

    @Test
    public void shouldGiveNiceExplanationForNonExistingFunctionsWithParams() throws Exception {
        try {
            withResource(classpathResource("templates/issue76/test3.twig"));
            render();
            fail();
        } catch (RenderException e) {
            then(e.getCause().getMessage(), containsString("templates/issue76/test3.twig -> Line 1, column 24: Unable to find function with name 'nonExistingFunction', and parameters: java.lang.String, java.lang.String, java.lang.Integer"));
        }
    }

    @Test
    public void shouldGiveNiceExplanationForNonExistingFunctions() throws Exception {
        try {
            withResource(classpathResource("templates/issue76/test1.twig"));
            render();
            fail();
        } catch (RenderException e) {
            then(e.getCause().getMessage(), containsString("templates/issue76/test1.twig -> Line 1, column 24: Unable to find function with name 'nonExistingFunction'"));
        }
    }

    @Test
    public void shouldGiveNiceExplanationForNonExistingVariables() throws Exception {
        try {
            given(theEnvironment().setStrictMode(true));
            withResource(classpathResource("templates/issue76/test2.twig"));
            render();
            fail();
        } catch (RenderException e) {
            then(e.getCause().getMessage(), startsWith("templates/issue76/test2.twig -> Line 1, column 23:"));
        }
    }
}

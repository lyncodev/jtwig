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

package com.lyncode.jtwig.expressions.operations.binary;

import com.lyncode.jtwig.exception.CalculateException;
import com.lyncode.jtwig.expressions.api.BinaryOperation;
import com.lyncode.jtwig.expressions.api.Expression;
import com.lyncode.jtwig.render.RenderContext;

import static com.lyncode.jtwig.util.BooleanOperations.isTrue;

public class IsNotOperator implements BinaryOperation {
    @Override
    public Object apply(RenderContext context, Expression left, Expression right) throws CalculateException {
        CompositionOperation composition = new CompositionOperation();
        return !isTrue(composition.apply(context, left, right));
    }
}

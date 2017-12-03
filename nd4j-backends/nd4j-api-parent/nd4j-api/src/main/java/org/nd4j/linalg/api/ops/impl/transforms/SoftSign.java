/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.transforms;

import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseTransformOp;

import java.util.Collections;
import java.util.List;

/**
 *
 * Softsign element-wise activation function. f(x) = x/(1+abs(x))<br>
 * Similar in shape to tanh but may outperform it due to
 * 'gentler' nonlinearity (smoother asymptotes).<br>
 * See for example: http://jmlr.org/proceedings/papers/v9/glorot10a/glorot10a.pdf
 * @author Alex Black
 */
public class SoftSign extends BaseTransformOp {
    public SoftSign(SameDiff sameDiff, DifferentialFunction i_v, boolean inPlace) {
        super(sameDiff, i_v, inPlace);
    }

    public SoftSign(SameDiff sameDiff, DifferentialFunction i_v, int[] shape, boolean inPlace, Object[] extraArgs) {
        super(sameDiff, i_v, shape, inPlace, extraArgs);
    }

    public SoftSign(SameDiff sameDiff, DifferentialFunction i_v, Object[] extraArgs) {
        super(sameDiff, i_v, extraArgs);
    }

    public SoftSign() {}

    public SoftSign(INDArray x, INDArray z) {
        super(x, z);
    }

    public SoftSign(INDArray x, INDArray z, long n) {
        super(x, z, n);
    }

    public SoftSign(INDArray x, INDArray y, INDArray z, long n) {
        super(x, y, z, n);
    }

    public SoftSign(INDArray x) {
        super(x);
    }

    @Override
    public int opNum() {
        return 20;
    }

    @Override
    public String opName() {
        return "softsign";
    }

    @Override
    public String onnxName() {
        return "Softsign";
    }

    @Override
    public String tensorflowName() {
        return "Softsign";
    }




    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> i_v) {
        DifferentialFunction ret = f().softsignDerivative(i_v.get(0));

        return Collections.singletonList(ret);
    }

}

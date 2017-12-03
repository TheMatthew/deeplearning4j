package org.nd4j.linalg.api.ops.impl.shape;

import onnx.OnnxProto3;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.NoOpNameFoundException;
import org.tensorflow.framework.AttrValue;
import org.tensorflow.framework.GraphDef;
import org.tensorflow.framework.NodeDef;

import java.util.Map;

/**
 * Stack op conversion
 *
 * @author raver119@gmail.com
 */
public class Pack extends Stack {

    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx op name found for  " + opName());
    }

    @Override
    public String tensorflowName() {
        return  "Pack";
    }

    @Override
    public void initFromTensorFlow(NodeDef nodeDef, SameDiff initWith, Map<String, AttrValue> attributesForNode, GraphDef graph) {
        super.initFromTensorFlow(nodeDef, initWith, attributesForNode, graph);
    }

    @Override
    public void initFromOnnx(OnnxProto3.NodeProto node, SameDiff initWith, Map<String, OnnxProto3.AttributeProto> attributesForNode, OnnxProto3.GraphProto graph) {
        super.initFromOnnx(node, initWith, attributesForNode, graph);
    }

    @Override
    public String opName() {
        return "pack";
    }
}

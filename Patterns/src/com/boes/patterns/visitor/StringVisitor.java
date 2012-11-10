package com.boes.patterns.visitor;

import com.boes.patterns.structure.Empty;
import com.boes.patterns.structure.Node;
import com.boes.patterns.type.NodeVisitorType;
//import com.boes.patterns.type.NodeType;

public class StringVisitor implements NodeVisitorType {

	@Override
	public Object forNode(Node that) {
		return "(" + that.value.toString() + ", " + that.rest.accept(this) + ")";
	}

	@Override
	public Object forEmpty(Empty that) {
		return "()";
	}
	
	/*
	@Override
	public Object forNode(Object value, NodeType rest) {
		return "(" + value.toString() + ", " + rest.accept(this) + ")";
	}

	@Override
	public Object forEmpty() {
		return "()";
	}
	*/
}

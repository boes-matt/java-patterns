package com.boes.patterns.visitor;

import com.boes.patterns.structure.Empty;
import com.boes.patterns.structure.Node;
import com.boes.patterns.type.NodeVisitorType;
//import com.boes.patterns.type.NodeType;

public class OccursVisitor implements NodeVisitorType {

	Object a;
	
	public OccursVisitor(Object a) {
		this.a = a;
	}

	@Override
	public Object forNode(Node that) {
		if (a.equals(that.value)) return 1 + (Integer) that.rest.accept(this);
		else return that.rest.accept(this);
	}

	@Override
	public Object forEmpty(Empty that) {
		return 0;
	}	
	
	/*
	@Override
	public Object forNode(Object value, NodeType rest) {
		if (a.equals(value)) return 1 + (Integer) rest.accept(this);
		else return rest.accept(this);
	}

	@Override
	public Object forEmpty() {
		return 0;
	}
	*/
}

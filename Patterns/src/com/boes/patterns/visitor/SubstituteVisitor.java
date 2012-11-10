package com.boes.patterns.visitor;

import com.boes.patterns.type.NodeVisitorType;
//import com.boes.patterns.type.NodeType;

import com.boes.patterns.structure.Node;
import com.boes.patterns.structure.Empty;

public class SubstituteVisitor implements NodeVisitorType {

	Object n;
	Object o;
	
	public SubstituteVisitor(Object n, Object o) {
		this.n = n;
		this.o = o;
	}
	
	@Override
	public Object forNode(Node that) {
		if (o.equals(that.value)) that.value = n;	
		that.rest.accept(this);
		return that;
	}

	@Override
	public Object forEmpty(Empty that) {
		return that;
	}
	
	/*
	@Override
	public Object forNode(Object value, NodeType rest) {
		if (o.equals(value)) return new Node(n, (NodeType) rest.accept(this));
		else return new Node(value, (NodeType) rest.accept(this));
	}

	@Override
	public Object forEmpty() {
		return new Empty();
	}
	*/
}

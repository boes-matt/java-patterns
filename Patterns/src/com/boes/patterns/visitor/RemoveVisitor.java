package com.boes.patterns.visitor;

import com.boes.patterns.structure.Node;
import com.boes.patterns.structure.Empty;

import com.boes.patterns.type.NodeType;
import com.boes.patterns.type.NodeVisitorType;

public class RemoveVisitor implements NodeVisitorType {

	Object removeMe;
	
	public RemoveVisitor(Object removeMe) {
		this.removeMe = removeMe;
	}

	@Override
	public Object forNode(Node that) {
		if (removeMe.equals(that.value)) return that.rest.accept(this);
		else return new Node(that.value, (NodeType) that.rest.accept(this));
	}

	@Override
	public Object forEmpty(Empty that) {
		return that;
	}
	
	/*
	@Override
	public Object forNode(Object value, NodeType rest) {
		if (removeMe.equals(value)) return rest.accept(this);
		else return new Node(value, (NodeType) rest.accept(this));
	}

	@Override
	public Object forEmpty() {
		return new Empty();
	}
	*/
}

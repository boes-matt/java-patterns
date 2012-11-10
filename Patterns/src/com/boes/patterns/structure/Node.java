package com.boes.patterns.structure;

import com.boes.patterns.type.NodeType;
import com.boes.patterns.type.NodeVisitorType;

public class Node implements NodeType {

	public Object value;
	public NodeType rest;
	
	public Node(Object value, NodeType rest) {
		this.value = value;
		this.rest = rest;
	}
	
	@Override
	public Object accept(NodeVisitorType behavior) {
		return behavior.forNode(this);
		
		//return behavior.forNode(value, rest);
	}

}

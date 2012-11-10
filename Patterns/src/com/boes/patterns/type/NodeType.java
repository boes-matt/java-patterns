package com.boes.patterns.type;

public interface NodeType {
	Object accept(NodeVisitorType behavior);
}

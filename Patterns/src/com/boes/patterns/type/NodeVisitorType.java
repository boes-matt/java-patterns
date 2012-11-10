package com.boes.patterns.type;

import com.boes.patterns.structure.Empty;
import com.boes.patterns.structure.Node;

public interface NodeVisitorType {
	// Different protocol.  Allows us to avoid 'new' keyword in some cases.  See SubstituteVisitor.
	Object forNode(Node that);
	Object forEmpty(Empty that);

	//Object forNode(Object value, NodeType rest);
	//Object forEmpty();
}

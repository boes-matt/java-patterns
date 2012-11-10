package com.boes.patterns.structure;

import com.boes.patterns.type.NodeType;
import com.boes.patterns.type.NodeVisitorType;

public class Empty implements NodeType {

	@Override
	public Object accept(NodeVisitorType behavior) {		
		return behavior.forEmpty(this);

		//return behavior.forEmpty();
	}

}

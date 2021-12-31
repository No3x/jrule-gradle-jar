package de.my.internal;

import java.util.HashSet;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;

import lombok.Data;

@Data
public class MyData {
	private String name;

	public MyData(String name) {
		final HashSet<String> strings = Sets.newHashSet(name, "2", "3");
		this.name = Joiner.on(",").join(strings);
	}
}

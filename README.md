## Getting Started

Here is a guideline to help you get started to write rules in Java with jrule. It uses the feature to deploy rules as jar to the `rules-jar` directory.

> For nice *sync support* copy the contents of this project to `/etc/automation/jrule/` and make sure to open it in your IDE (so make sure you are on the openhab
> server filesystem or on a mapped network drive. This way your IDE will pick up new items and the generated jar is picked up by jrule).

## Folder Structure

The workspace (after jrule is initialized) contains of the following:

- `items`: items src from openhab (ignore)
- `jar/jrule-items.jar`: compiled items to jar (added as dependency)
- `jar/jrule.jar`: jrule (added as dependency)
- `ext-lib` additional dependencies (ignore)
- `rules` compiled by jrule (ignore, we do not use this with gradle build approach because we compile on our own)

Only these two are actually important for you: 
- `src/main/java/org/openhab/automation/jrule/rules/user` place your java rules here
- `src/main/java/de/my/internal` place everything but rules here. You can name it whatever you like `e.g. org.my.package`

## Build
When you wish to deploy your rules execute the `assemble` task.

> The `rules-jar` folder will contain your custom rules compiled to a jar. This is picked up by jrule on change.

## Dependencies

Lombok is included in this sample. 

The class MyData shows that you can use lombok and guava as example.
```java
package de.my.internal;

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
```

This is accomplished by building an uber jar that contains the compiled dependencies.

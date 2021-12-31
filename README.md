## Getting Started

Here is a guideline to help you get started to write rules in Java with jrule. It uses the feature to deploy rules as jar to the `rules-jar` directory.

> For nice *sync support* copy the contents of this project to `/etc/automation/jrule/` and make sure to open it in your IDE (so make sure you are on the openhab
> server filesystem or on a mapped network drive. This way you IDE will pick up new items and the generated jar is picked up by jrule).

## Folder Structure

The workspace (after jrule is initialized) contains of the following:

- `items`: items src from openhab (ignore)
- `jar/jrule-items.jar`: compiled items to jar (added as dependency)
- `jar/jrule.jar`: jrule (added as dependency)
- `ext-lib` additional dependencies (ignore)
- `rules` compiled by jrule (ignore, we do not use this with gradle build approach because we compile on our own)

Only this two are acutally important for you: 
- `myrules/org/openhab/automation/jrule/rules/user` place your java rules here
- `de/my/internal` place everything but rules here. You can name it whatever you like `e.g. org.my.package`

## Build
When you wish to deploy your rules execute the `jar` task.

> The `rules-jar` folder will contain your custom rules compiled to a jar. This is picked up by jrule on change.

## Dependencies

Lombok is included in this sample. Add any dependency you might need like `guava` or `apache commons` in the `dependency` block in `build.gradle`.

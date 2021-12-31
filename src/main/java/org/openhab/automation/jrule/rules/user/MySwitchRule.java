package org.openhab.automation.jrule.rules.user;

import org.openhab.automation.jrule.items.generated._MyOtherItem;
import org.openhab.automation.jrule.items.generated._MyTestSwitch;
import org.openhab.automation.jrule.rules.JRule;
import org.openhab.automation.jrule.rules.JRuleName;
import org.openhab.automation.jrule.rules.JRuleWhen;

import de.my.internal.MyData;

public class MySwitchRule extends JRule {

	@JRuleName("MySwitchRule")
	@JRuleWhen(item = _MyTestSwitch.ITEM, trigger = _MyTestSwitch.TRIGGER_CHANGED_TO_ON)
	public void execOffToOnRule() {
		final MyData myData = new MyData("1");
		final String someCalculatedValue = myData.getName();
		logInfo("||||| --> Hello World! And hello lombok " + someCalculatedValue);
		_MyOtherItem.sendCommand(someCalculatedValue);
	}
}

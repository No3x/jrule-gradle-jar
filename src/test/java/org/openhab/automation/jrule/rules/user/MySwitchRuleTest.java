package org.openhab.automation.jrule.rules.user;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.openhab.automation.jrule.items.generated._MyOtherItem;

class MySwitchRuleTest {

	private MySwitchRule rule;

	@BeforeEach
	void setUp() {
		rule = new MySwitchRule();
	}

	@Test
	void execOffToOnRuleTest() {
		try (MockedStatic<_MyOtherItem> mocked = mockStatic(_MyOtherItem.class)) {
			rule.execOffToOnRule();
			// Verifying mocks.
			mocked.verify(() -> _MyOtherItem.sendCommand("1,2,3"), times(1));
		}
	}
}

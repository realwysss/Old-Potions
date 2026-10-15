package dev.oldp;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class CfgScr {
	static Component t(String s) {
		return Component.literal(s);
	}

	public static Screen mk(Screen p) {
		ConfigBuilder b = ConfigBuilder.create().setParentScreen(p).setTitle(t("Old Potions")).setSavingRunnable(Cfg::sv);
		ConfigCategory cc = b.getOrCreateCategory(t("Settings"));
		ConfigEntryBuilder e = b.entryBuilder();
		Cfg c = Cfg.c;
		cc.addEntry(e.startBooleanToggle(t("Old Colors"), c.col).setDefaultValue(true).setTooltip(t("Uses the potion and effect colors from 1.18. This changes the bottle color, the swirl particles around you and the tipped arrows.")).setSaveConsumer(v -> c.col = v).build());
		cc.addEntry(e.startBooleanToggle(t("Potion Glint"), c.gl).setDefaultValue(true).setTooltip(t("Potions, splash potions and lingering potions with effects shine like in 1.18.")).setSaveConsumer(v -> c.gl = v).build());
		cc.addEntry(e.startBooleanToggle(t("Water Bottle Glint"), c.wat).setDefaultValue(false).setTooltip(t("Also makes potions without effects shine, like water bottles and awkward potions. 1.18 did not do this.")).setSaveConsumer(v -> c.wat = v).build());
		cc.addEntry(e.startBooleanToggle(t("Arrow Glint"), c.arr).setDefaultValue(false).setTooltip(t("Tipped arrows with effects shine too. 1.18 did not do this.")).setSaveConsumer(v -> c.arr = v).build());
		return b.build();
	}
}

package com.pouffy.forgedinfire.main.tools.data;

import com.pouffy.forgedinfire.main.tools.ForgedTools;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;

public class StationSlotLayoutProvider extends AbstractStationSlotLayoutProvider {
    public StationSlotLayoutProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addLayouts() {
        defineModifiable(ForgedTools.glaive)
                .sortIndex(SORT_WEAPON + SORT_LARGE)
                .addInputItem(TinkerToolParts.smallBlade,  45, 26)
                .addInputItem(TinkerToolParts.toughHandle,  9, 62)
                .addInputItem(TinkerToolParts.toughHandle, 27, 44)
                .addInputItem(TinkerToolParts.toolBinding,  45, 44)
                .build();
    }
    @Override
    public String getName() {
        return "Forged In Fire Tinker Station Slot Layouts";
    }
}

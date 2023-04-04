package com.pouffy.forgedinfire.main.tools.data.sprite;

import com.pouffy.forgedinfire.ForgedInFire;
import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

public class ForgedPartSpriteProvider extends AbstractPartSpriteProvider {
    public ForgedPartSpriteProvider() {
        super(ForgedInFire.MOD_ID);
    }
    @Override
    public String getName() {
        return "Forged In Fire Parts";
    }
    @Override
    protected void addAllSpites() {

        buildTool("glaive").withLarge().addBreakableHead("head").addHandle("handle").addHandle("grip").addBinding("accessory");
    }
}

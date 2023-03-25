package com.pouffy.forgedinfire.main.tools.data.material;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class MaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {
    public MaterialRenderInfoProvider(DataGenerator gen, AbstractMaterialSpriteProvider spriteProvider) {
        super(gen, spriteProvider);
    }
    @Override
    protected void addMaterialRenderInfo() {
        buildRenderInfo(MaterialIds.dragon_bone).color(0xA39F93).fallbacks("bone", "rock");
        buildRenderInfo(MaterialIds.wither_bone).color(0x2a2a2a).fallbacks("bone", "rock");

        buildRenderInfo(MaterialIds.dragon_scale).color(0x700C0C);
        buildRenderInfo(MaterialIds.red).color(0x700C0C);
        buildRenderInfo(MaterialIds.emerald).color(0x40502c);
        buildRenderInfo(MaterialIds.bronze).color(0x7b622b);
        buildRenderInfo(MaterialIds.amethyst).color(0x361c59);
        buildRenderInfo(MaterialIds.black).color(0x232323);
        buildRenderInfo(MaterialIds.blue).color(0xafd1e1);
        buildRenderInfo(MaterialIds.copper).color(0x5a3428);
        buildRenderInfo(MaterialIds.electric_blue).color(0x241c59);
        buildRenderInfo(MaterialIds.gray).color(0x4b443f);
        buildRenderInfo(MaterialIds.sapphire).color(0x185084);
        buildRenderInfo(MaterialIds.silver).color(0x595c5e);
        buildRenderInfo(MaterialIds.white).color(0xf1f1f1);
        buildRenderInfo(MaterialIds.fireDragonsteel).color(0x4b4757).fallbacks("bone", "metal").luminosity(2);
        buildRenderInfo(MaterialIds.iceDragonsteel).color(0x789295).fallbacks("bone", "metal").luminosity(2);
        buildRenderInfo(MaterialIds.lightningDragonsteel).color(0x512f63).fallbacks("bone", "metal").luminosity(2);


    }
    @Override
    public String getName() {
        return "Forged In Fire Material Render Info Provider";
    }

}

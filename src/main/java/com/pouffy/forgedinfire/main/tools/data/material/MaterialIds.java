package com.pouffy.forgedinfire.main.tools.data.material;

import com.pouffy.forgedinfire.ForgedInFire;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import static slimeknights.tconstruct.library.materials.definition.MaterialVariantId.create;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MaterialIds {
    public static final MaterialId dragon_bone = id("dragon_bone");
    public static final MaterialId wither_bone = id("wither_bone");

    public static final MaterialId dragon_scale = id("dragon_scale");

    public static final MaterialVariantId red     = create(dragon_scale, "red");
    public static final MaterialVariantId emerald     = create(dragon_scale, "emerald");
    public static final MaterialVariantId bronze     = create(dragon_scale, "bronze");
    public static final MaterialVariantId gray     = create(dragon_scale, "gray");
    public static final MaterialVariantId blue     = create(dragon_scale, "blue");
    public static final MaterialVariantId white     = create(dragon_scale, "white");
    public static final MaterialVariantId sapphire     = create(dragon_scale, "sapphire");
    public static final MaterialVariantId silver     = create(dragon_scale, "silver");
    public static final MaterialVariantId amethyst     = create(dragon_scale, "amethyst");
    public static final MaterialVariantId electric_blue     = create(dragon_scale, "electric_blue");
    public static final MaterialVariantId copper     = create(dragon_scale, "copper");
    public static final MaterialVariantId black     = create(dragon_scale, "black");

    public static final MaterialId fireDragonsteel     = id("fire_dragonsteel");
    public static final MaterialId iceDragonsteel     = id( "ice_dragonsteel");
    public static final MaterialId lightningDragonsteel     = id( "lightning_dragonsteel");




    private static MaterialId id(String name) {
        return new MaterialId(ForgedInFire.MOD_ID, name);
    }
}

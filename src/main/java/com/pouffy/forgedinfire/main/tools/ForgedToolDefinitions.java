package com.pouffy.forgedinfire.main.tools;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ForgedToolDefinitions {
    public static final ToolDefinition GLAIVE = ToolDefinition.builder(ForgedTools.glaive).meleeHarvest().build();
}

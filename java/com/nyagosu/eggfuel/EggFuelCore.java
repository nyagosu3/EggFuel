package com.nyagosu.eggfuel;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(
	modid = "eggfuel",
	name = "EggFuel",
	version = "1.0.0",
	dependencies = "required-after:Forge@[10.13.4.1614,)",
	useMetadata = true
)

public class EggFuelCore {
	
	public int burningTime = 2000;
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
		
		GameRegistry.registerFuelHandler(new IFuelHandler(){
			@Override
			public int getBurnTime(ItemStack fuel){
				if(fuel.getItem().equals(Items.egg)){
					return burningTime;
				}
				return 0;
			}
		});
		
    }
}

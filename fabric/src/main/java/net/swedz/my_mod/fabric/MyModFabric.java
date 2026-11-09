package net.swedz.my_mod.fabric;

import net.fabricmc.api.ModInitializer;
import net.swedz.my_mod.MyMod;

public final class MyModFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		MyMod.LOGGER.info("Hello world on Fabric!");
		MyMod.init();
	}
}

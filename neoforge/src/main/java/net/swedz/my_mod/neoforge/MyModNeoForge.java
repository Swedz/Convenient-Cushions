package net.swedz.my_mod.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.swedz.my_mod.MyMod;

@Mod(MyMod.ID)
public final class MyModNeoForge
{
	public MyModNeoForge(IEventBus bus, ModContainer container)
	{
		MyMod.LOGGER.info("Hello world on NeoForge!");
		MyMod.init();
	}
}

package net.swedz.my_mod.neoforge.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.swedz.my_mod.MyMod;
import net.swedz.my_mod.client.MyModClient;

@Mod(
		value = MyMod.ID,
		dist = Dist.CLIENT
)
public final class MyModNeoForgeClient
{
	public MyModNeoForgeClient(IEventBus bus, ModContainer container)
	{
		MyMod.LOGGER.info("Hello world on NeoForge client!");
		MyModClient.init();
	}
}

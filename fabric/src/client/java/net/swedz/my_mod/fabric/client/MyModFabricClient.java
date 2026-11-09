package net.swedz.my_mod.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.swedz.my_mod.MyMod;
import net.swedz.my_mod.client.MyModClient;

public final class MyModFabricClient implements ClientModInitializer
{
	@Override
	public void onInitializeClient()
	{
		MyMod.LOGGER.info("Hello world on Fabric client!");
		MyModClient.init();
	}
}

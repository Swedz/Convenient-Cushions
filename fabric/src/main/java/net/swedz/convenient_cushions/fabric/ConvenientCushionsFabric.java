package net.swedz.convenient_cushions.fabric;

import net.fabricmc.api.ModInitializer;
import net.swedz.convenient_cushions.common.ConvenientCushions;

public final class ConvenientCushionsFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		ConvenientCushions.init();
	}
}

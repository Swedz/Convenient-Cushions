package net.swedz.convenient_cushions.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.swedz.convenient_cushions.common.ConvenientCushions;

@Mod(ConvenientCushions.ID)
public final class ConvenientCushionsNeoForge
{
	public ConvenientCushionsNeoForge(IEventBus bus, ModContainer container)
	{
		ConvenientCushions.init();
	}
}

package net.swedz.convenient_cushions;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConvenientCushions
{
	public static final String ID   = "convenient_cushions";
	public static final String NAME = "Convenient Cushions";
	
	public static ResourceLocation id(String path)
	{
		return ResourceLocation.fromNamespaceAndPath(ID, path);
	}
	
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	
	public static void init()
	{
	}
}

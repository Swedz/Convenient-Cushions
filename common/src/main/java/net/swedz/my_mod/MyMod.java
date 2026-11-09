package net.swedz.my_mod;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MyMod
{
	public static final String ID   = "my_mod";
	public static final String NAME = "My Mod";
	
	public static Identifier id(String path)
	{
		return Identifier.fromNamespaceAndPath(ID, path);
	}
	
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	
	public static void init()
	{
		LOGGER.info("Hello world on both!");
	}
}

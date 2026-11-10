package net.swedz.convenient_cushions.common;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConvenientCushions
{
	public static final String ID   = "convenient_cushions";
	public static final String NAME = "Convenient Cushions";
	
	public static Identifier id(String path)
	{
		return Identifier.fromNamespaceAndPath(ID, path);
	}
	
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
	
	public static void init()
	{
	}
}

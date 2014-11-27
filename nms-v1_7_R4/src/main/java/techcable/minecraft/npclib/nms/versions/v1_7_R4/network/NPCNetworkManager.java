package techcable.minecraft.npclib.nms.versions.v1_7_R4.network;

import java.lang.reflect.Field;

import techcable.minecraft.npclib.util.ReflectUtil;

import net.minecraft.server.v1_7_R4.NetworkManager;

import lombok.*;

@Getter
public class NPCNetworkManager extends NetworkManager {

	public NPCNetworkManager() {
		super(false); //MCP = isClientSide
		
		Field channel = ReflectUtil.makeField(NetworkManager.class, "m"); //MCP = channel
		Field address = ReflectUtil.makeField(NetworkManager.class, "n"); //MCP = address
		
		ReflectUtil.setField(channel, this, new NullChannel());
		ReflectUtil.setField(address, this, new NullSocketAddress());
		
	}

}

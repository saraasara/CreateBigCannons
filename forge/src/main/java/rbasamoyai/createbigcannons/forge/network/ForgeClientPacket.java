package rbasamoyai.createbigcannons.forge.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import rbasamoyai.createbigcannons.network.CBCRootNetwork;
import rbasamoyai.createbigcannons.network.RootPacket;

import java.util.function.Supplier;

public class ForgeClientPacket {

	private final RootPacket pkt;

	public ForgeClientPacket(RootPacket pkt) { this.pkt = pkt; }

	public ForgeClientPacket(FriendlyByteBuf buf) {
		this.pkt = CBCRootNetwork.constructPacket(buf, buf.readVarInt());
	}

	public void encode(FriendlyByteBuf buf) {
		CBCRootNetwork.writeToBuf(this.pkt, buf);
	}

	public void handle(Supplier<NetworkEvent.Context> sup) {
		NetworkEvent.Context ctx = sup.get();
		ctx.enqueueWork(() -> {
			this.pkt.handle(null, ctx.getNetworkManager().getPacketListener(), null);
		});
		ctx.setPacketHandled(true);
	}

}

package com.duelco.ui.managers;

import com.duelco.obj.BingoItem;
import com.duelco.ui.screen.BingoScreen;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.StackLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class BingoItemUIManager {

    public static StackLayout buildItemSlot(BingoItem bingoItem) {
        StackLayout sampleSlot = (StackLayout) Containers.stack(Sizing.fixed(24), Sizing.fixed(24))
                .alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER)
                .padding(Insets.of(2));

        sampleSlot.child(
                Components.box(Sizing.fill(), Sizing.fill())
                        .fill(true)
                        .color(Color.ofRgb(15457478))
        );

        if (bingoItem.isFreeSpace()) {
            sampleSlot.child(
                    Components.texture(Identifier.of("duelutils", "ui/free_space.png"), 1, 1, 256, 256)
                            .sizing(Sizing.fixed(20))
                            .zIndex(20)
            );
        } else {
            sampleSlot.child(
                    Components.item(bingoItem.getItem())
            );
        }

        sampleSlot.mouseDown().subscribe((a, b, c) -> {
            bingoItem.setMarked(!bingoItem.isMarked());
            MinecraftClient.getInstance().setScreen(new BingoScreen());
            return true;
        });

        if (bingoItem.isMarked()) {
            sampleSlot.child(
                    Components.texture(Identifier.of("duelutils", "ui/marker.png"), 1, 1, 256, 256)
                            .sizing(Sizing.fixed(20))
            );
        }

        return sampleSlot;
    }
}

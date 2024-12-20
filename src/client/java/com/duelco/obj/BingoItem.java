package com.duelco.obj;

import net.minecraft.component.*;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.item.ItemStack;

public class BingoItem {
    private ItemStack item;
    private boolean isMarked;
    private boolean isFreeSpace;
    private int customModelDataNum;
    private String name;

    public BingoItem(ItemStack item, int customModelDataNum, boolean isMarked, String name) {
        CustomModelDataComponent ItemComponents= new CustomModelDataComponent(customModelDataNum);
        item.set(DataComponentTypes.CUSTOM_MODEL_DATA, ItemComponents);

        this.item = item;
        this.isMarked = isMarked;
        this.isFreeSpace = false;
        this.name = name;
    }

    public BingoItem(BingoItem bingoItem) {
        this.item = bingoItem.getItem();
        this.isMarked = bingoItem.isMarked();
        this.isFreeSpace = bingoItem.isFreeSpace();
        this.customModelDataNum = bingoItem.getCustomModelDataNum();
        this.name = bingoItem.getName();
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public boolean isFreeSpace() {
        return isFreeSpace;
    }

    public int getCustomModelDataNum() {
        return customModelDataNum;
    }

    public void setCustomModelDataNum(int customModelDataNum) {
        this.customModelDataNum = customModelDataNum;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        this.isMarked = marked;
    }

    public void setFreeSpace(boolean isFreeSpace) {
        this.isFreeSpace = isFreeSpace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

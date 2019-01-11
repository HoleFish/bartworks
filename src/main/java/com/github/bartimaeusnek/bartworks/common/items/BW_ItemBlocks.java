/*
 * Copyright (c) 2019 bartimaeusnek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.bartimaeusnek.bartworks.common.items;

import com.github.bartimaeusnek.bartworks.MainMod;
import com.github.bartimaeusnek.bartworks.util.ChatColorHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.util.GT_LanguageManager;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BW_ItemBlocks extends ItemBlock {

    protected final String mNoMobsToolTip = GT_LanguageManager.addStringLocalization("gt.nomobspawnsonthisblock", "Mobs cannot Spawn on this Block");
    protected final String mNoTileEntityToolTip = GT_LanguageManager.addStringLocalization("gt.notileentityinthisblock", "This is NOT a TileEntity!");

    public BW_ItemBlocks(final Block par1) {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(MainMod.GT2);
    }

    @Override
    public int getMetadata(final int aMeta) {
        return aMeta;
    }

    @Override
    public String getUnlocalizedName(final ItemStack aStack) {
        return this.field_150939_a.getUnlocalizedName() + "." + this.getDamage(aStack);
    }

    @Override
    public void addInformation(final ItemStack aStack, final EntityPlayer aPlayer, final List aList, final boolean aF3_H) {
        aList.add(this.mNoMobsToolTip);
        aList.add(this.mNoTileEntityToolTip);
        aList.add("Added by" + ChatColorHelper.DARKGREEN + " BartWorks");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass) {
        return this.field_150939_a.getIcon(0, stack.getItemDamage());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return getIcon(stack, renderPass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_) {
        return this.field_150939_a.getIcon(0, p_77618_2_);
    }
}
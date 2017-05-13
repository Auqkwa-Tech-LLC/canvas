package org.ipvp.canvas.slot;

import java.util.Optional;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.ipvp.canvas.ClickInformation;

/**
 * A slot is a position held by an Inventory that can be interacted with by users.
 * <p>
 * A Menu slot always has the potential to be clicked by players, controlling
 * what interactions have any effect on the slot are made available through {@link ClickOptions}.
 */
public interface Slot {

    /**
     * Returns the slots index position inside the parent Menu.
     *
     * @return The slots position
     */
    int getIndex();

    /**
     * Returns the click interactions that the Slot permits.
     *
     * @return The slots options
     */
    ClickOptions getClickOptions();

    /**
     * Modifies the expected function of the slot when handling clicks.
     *
     * @param options The new slot options
     */
    void setClickOptions(ClickOptions options);

    /**
     * Returns the item currently present in the slot. Return value
     * has undefined behavior when the stack is of type AIR.
     *
     * @return The item in the slot
     */
    ItemStack getItem();

    /**
     * Sets the item currently in the slot.
     *
     * @param item The new item in the slot
     */
    void setItem(ItemStack item);

    /**
     * Returns a user-defined handler for when a Player clicks the slot.
     *
     * @return The click handler
     */
    Optional<ClickHandler> getClickHandler();

    /**
     * Sets a new handler policy for when a Player clicks the slot.
     *
     * @param handler The new click handler
     */
    void setClickHandler(ClickHandler handler);

    /**
     * A Slots click handler is a user defined function or policy that occurs when a
     * Player clicks on a slot.
     * <p>
     * Passed through are the player that clicked the slot as well as the information
     * regarding their click, including the clicked Menu as well as the slot clicked.
     */
    @FunctionalInterface
    interface ClickHandler {

        /**
         * Called when a Player successfully clicks on a slot with this handler. Users may
         * change the result a click will have in the underlying inventory by setting the
         * information in the passed through ClickInformation object.
         *
         * @param player The player that clicked the slot
         * @param click  Information about the performed click
         */
        void click(Player player, ClickInformation click);
    }
}

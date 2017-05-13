package org.ipvp.canvas;

import java.util.Optional;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.ipvp.canvas.slot.Slot;

/**
 * A menu represents an interactive interface for Players backed by instances of 
 * Inventories. 
 * <p>
 * Menu interaction will not function properly unless an instance of {@link MenuFunctionListener}
 * is properly registered with the Bukkit event scheduler.
 */
public interface Menu extends InventoryHolder {

    /**
     * Returns the fallback Menu for when this menu is closed
     * 
     * @return The parent menu
     */
    Optional<Menu> getParent();

    /**
     * Opens the Menu for a Player
     *
     * @param viewer The player to view the Menu
     */
    void open(Player viewer);

    /**
     * Closes the Menu for a viewing Player
     *
     * @param viewer The player who currently is viewing this Menu
     * @throws IllegalStateException If the Player is not viewing the Menu
     */
    void close(Player viewer);

    /**
     * Returns the Slot found at the given index of the Menu
     *
     * @param index The index of the Slot
     * @return The Slot at the index
     */
    Slot getSlot(int index);

    /**
     * Clears out the whole Menu
     */
    void clear();

    /**
     * Clears out a particular Button at the given index
     *
     * @param index The index number to clear
     */
    void clear(int index);

    /**
     * Returns the dimensions of the Menu
     * 
     * @return The menus row and column count
     */
    Dimension getDimensions();

    @Override
    ImmutableInventory getInventory();

    /**
     * A Builder for Menus
     */
    interface Builder {

        /**
         * Adds a title to this Menu
         *
         * @param title The title to display
         * @return Fluent pattern
         */
        Builder title(String title);

        /**
         * Adds a fallback parent to this Menu
         *
         * @param parent The fallback GUI
         * @return Fluent pattern
         */
        Builder parent(Menu parent);

        /**
         * Builds the Menu from the given data
         *
         * @return The instance of Menu, if successful
         */
        Menu build();
    }

    /**
     * Represents the dimensions of a Menu 
     */
    class Dimension {
        
        private final int rows;
        private final int columns;
        
        public Dimension(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
        }

        /**
         * Returns the number of rows in the Menu
         * 
         * @return The row count
         */
        public int getRows() {
            return rows;
        }

        /**
         * Returns the number of columns in the Menu
         * 
         * @return The column count
         */
        public int getColumns() {
            return columns;
        }
    }
}

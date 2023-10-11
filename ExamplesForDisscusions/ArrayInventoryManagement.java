package ExamplesForDisscusions;

public class ArrayInventoryManagement {
    public static void main(String[] args) {
        // Create an array of Product objects to represent the inventory
        Product[] inventory = new Product[100];

        // Initialize the inventory with some products
        inventory[0] = new Product(0, "Widget", 50);
        inventory[1] = new Product(1, "Gadget", 30);

        // Update stock levels when a product is sold or restocked
        inventory[0].setStock(inventory[0].getStock() - 10); // Sold 10 units of Widget
        inventory[1].setStock(inventory[1].getStock() + 30); // Restocked 30 units of Gadget

        // Display the current inventory
        for (Product product : inventory) {
            if (product != null) {
                System.out.println(product);
            }
        }
    }
}

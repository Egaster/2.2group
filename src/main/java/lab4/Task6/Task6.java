package lab4.Task6;
import java.util.Objects;
public class Task6 {
    public static void main(String[] args) {
        DiscountedItem x = new DiscountedItem("item", 1, 0.05);
        Item y = new Item("item", 1);
        DiscountedItem z = new DiscountedItem("item", 1, 0.1);

        System.out.println("x.equals(y) = " + x.equals(y)); // true
        System.out.println("y.equals(z) = " + y.equals(z)); // true
        System.out.println("x.equals(z) = " + x.equals(z)); // false
    }

    protected static class Item {
        private String description;
        private double price;

        public Item(String description, double price) {
            this.description = description;
            this.price = price;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof Item)) return false;
            Item item = (Item) object;
            return Double.compare(item.price, price) == 0 &&
                    Objects.equals(description, item.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(description, price);
        }
    }

    protected static class DiscountedItem extends Item {
        private double discount;

        public DiscountedItem(String description, double price, double discount) {
            super(description, price);
            this.discount = discount;
        }

        @Override
        public boolean equals(Object o) {
            if (!super.equals(o)) return false;
//            System.out.println(o.getClass());
//            System.out.println(Item.class);
            if (o.getClass() == Item.class) {
                return true;
            }
            DiscountedItem that = (DiscountedItem) o;
            return Double.compare(that.discount, discount) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), discount);
        }
    }
}

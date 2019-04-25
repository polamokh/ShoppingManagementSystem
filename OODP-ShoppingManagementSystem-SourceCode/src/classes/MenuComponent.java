package classes;

import java.util.List;

public abstract class MenuComponent {
	public void add(MenuComponent menuComponent) {}
	public void remove(MenuComponent menuComponent) {}
	public abstract MenuComponent getChild(int i);
	public abstract List<MenuComponent> getProducts();
	public abstract String getName();
	public abstract String getDescription();
	public abstract double getPrice();
	public abstract int getQuantity();
}

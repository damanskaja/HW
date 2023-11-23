public class CommonCustomer implements Customer {

    private int id;
    private String name;
    private int age;
    private String email;
    private Cart cart;

    public CommonCustomer() {
    }

    public CommonCustomer(int id, String name, Cart cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        validateCustomer();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        validateCustomer();
    }

    private void validateCustomer() {
        if (age < 0 || age > 150) {
            throw new CustomerValidationException("Invalid age");
        }

        if (email != null && !isValidEmail(email)) {
            throw new CustomerValidationException("Invalid email");
        }
    }

    private boolean isValidEmail(String email) {
        return true;
    }
}

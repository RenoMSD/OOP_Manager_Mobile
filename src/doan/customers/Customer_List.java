package doan.customers;

public class Customer_List {
    private Customer[] list;

    public Customer_List() {
        this.list = new Customer[0]; // Khởi tạo mảng rỗng
    }

    public void add_Customer(Customer customer) {
        Customer[] newList = new Customer[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        newList[list.length] = customer;
        list = newList;
    }

    public void remove_Customer(Customer customer) {
        int indexToRemove = -1;

        // Tìm chỉ mục của khách hàng cần xóa
        for (int i = 0; i < list.length; i++) {
            if (list[i].get_Id() == customer.get_Id()) { // Giả sử ID là duy nhất
                indexToRemove = i;
                break;
            }
        }

        // Nếu tìm thấy khách hàng, tạo mảng mới mà không có khách hàng đó
        if (indexToRemove != -1) {
            Customer[] newList = new Customer[list.length - 1];
            for (int i = 0, j = 0; i < list.length; i++) {
                if (i != indexToRemove) {
                    newList[j++] = list[i];
                }
            }
            list = newList;
        }
    }

    public Customer[] getList() {
        return list;
    }

    public void displayCustomers() {
        System.out.println("Danh sách khách hàng:");
        for (Customer customer : list) {
            System.out.println("ID: " + customer.get_Id() + ", Tên: " + customer.get_Name());
        }
    }
}
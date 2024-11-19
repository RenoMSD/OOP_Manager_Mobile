package doan.orders;

public class Order_List {
    private Order[] list; // Mảng để lưu trữ danh sách đơn hàng

    public Order_List() {
        this.list = new Order[0]; // Khởi tạo mảng rỗng
    }

    // Thêm đơn hàng vào danh sách
    public void add_Order(Order order) {
        Order[] newList = new Order[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        newList[list.length] = order; // Thêm đơn hàng mới
        list = newList; // Cập nhật danh sách
    }

    // Xóa đơn hàng khỏi danh sách
    public void remove_Order(Order order) {
        int indexToRemove = -1;

        // Tìm chỉ mục của đơn hàng cần xóa
        for (int i = 0; i < list.length; i++) {
            if (list[i].get_Id().equals(order.get_Id())) { // So sánh ID
                indexToRemove = i;
                break;
            }
        }

        // Nếu tìm thấy đơn hàng, tạo mảng mới mà không có đơn hàng đó
        if (indexToRemove != -1) {
            Order[] newList = new Order[list.length - 1];
            for (int i = 0, j = 0; i < list.length; i++) {
                if (i != indexToRemove) {
                    newList[j++] = list[i]; // Sao chép đơn hàng còn lại
                }
            }
            list = newList; // Cập nhật danh sách
        }
    }

    // Trả về danh sách đơn hàng
    public Order[] getList() {
        return list;
    }

    // Hiển thị thông tin đơn hàng
    public void displayOrders() {
        System.out.println("Danh sách đơn hàng:");
        for (Order order : list) {
            System.out.println("ID: " + order.get_Id() + 
                               ", Khách hàng: " + order.get_Customer().get_Name() + 
                               ", Sản phẩm: " + order.get_Product().get_Name() + 
                               ", Số lượng: " + order.get_Quantity());
        }
    }
}

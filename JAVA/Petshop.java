import java.util.ArrayList; 
import java.util.List;      

class PetShop {
    private List<String[]> products; 

    public PetShop() {
        products = new ArrayList<>(); 
    }

    // Metode untuk menampilkan semua produk
    public void displayProducts() {
        if (products.isEmpty()) { // Memeriksa apakah daftar produk kosong
            System.out.println("Tidak ada data produk.");
            return;
        }
        System.out.println("Daftar Produk:"); 
        for (String[] product : products) { 
            System.out.printf("Id: %s, Nama: %s, Kategori: %s, Harga: Rp %s%n",
                    product[0], product[1], product[2], product[3]); // Menampilkan informasi produk
        }
    }

    // Metode untuk menambahkan produk baru
    public void addProduct(String name, String category, int price) {
        int productId = products.size() + 1; // Menghasilkan ID produk baru
        String[] newProduct = {String.valueOf(productId), name, category, String.valueOf(price)}; // Membuat array produk baru
        products.add(newProduct); // Menambahkan produk ke daftar
        System.out.printf("Produk '%s' berhasil ditambahkan.%n", name); 
    }

    // Metode untuk memperbarui informasi produk
    public void updateProduct(int productId, String name, String category, Integer price) {
        for (String[] product : products) { 
            if (Integer.parseInt(product[0]) == productId) { // Memeriksa apakah ID produk cocok
                if (name != null) { // Memperbarui nama jika tidak null
                    product[1] = name;
                }
                if (category != null) { // Memperbarui kategori jika tidak null
                    product[2] = category;
                }
                if (price != null) { // Memperbarui harga jika tidak null
                    product[3] = String.valueOf(price);
                }
                System.out.printf("Produk dengan ID %d berhasil diperbarui.%n", productId); 
                return; 
            }
        }
        System.out.printf("Produk dengan ID %d tidak ditemukan.%n", productId); 
    }

    // Metode untuk menghapus produk berdasarkan ID
    public void deleteProduct(int productId) {
        for (String[] product : products) { 
            if (Integer.parseInt(product[0]) == productId) { // Memeriksa apakah ID produk cocok
                products.remove(product); // Menghapus produk dari daftar
                System.out.printf("Produk dengan ID %d berhasil dihapus.%n", productId); 
                return; 
            }
        }
        System.out.printf("Produk dengan ID %d tidak ditemukan.%n", productId); 
    }

    // Metode untuk mencari produk berdasarkan nama
    public void searchProduct(String name) {
        List<String[]> foundProducts = new ArrayList<>(); // Daftar untuk menyimpan produk yang ditemukan
        for (String[] product : products) { 
            if (product[1].toLowerCase().contains(name.toLowerCase())) { 
                foundProducts.add(product); // Menambahkan produk yang ditemukan ke daftar
            }
        }
        if (foundProducts.isEmpty()) { // Memeriksa apakah tidak ada produk yang ditemukan
            System.out.printf("Tidak ada produk yang ditemukan dengan nama '%s'.%n", name);
            return;
        }
        System.out.println("Produk yang ditemukan:"); 
        for (String[] product : foundProducts) { 
            System.out.printf("Id: %s, Nama: %s, Kategori: %s, Harga: Rp %s%n",
                    product[0], product[1], product[2], product[3]); // Menampilkan informasi produk yang ditemukan
        }
    }
}
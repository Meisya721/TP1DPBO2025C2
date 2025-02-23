import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) {
        PetShop petshop = new PetShop(); 
        Scanner scanner = new Scanner(System.in); 

        while (true) { 
            System.out.println("\nMenu:");
            System.out.println(" 1. Tampilkan Produk");
            System.out.println(" 2. Tambah Produk");
            System.out.println(" 3. Edit Produk");
            System.out.println(" 4. Hapus Produk");
            System.out.println(" 5. Cari Produk");
            System.out.println(" 6. Exit\n");

            System.out.print("Masukkan Pilihan: ");
            int choice = scanner.nextInt(); // Mengambil input dari user
            scanner.nextLine(); // Membersihkan newline

            switch (choice) { // Memeriksa pilihan yang dimasukkan
                case 1:
                    // Menampilkan semua produk
                    petshop.displayProducts(); 
                    break;

                case 2:
                    // Mengambil informasi produk baru dari user
                    System.out.print("Masukkan Nama Produk: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan Kategori Produk: ");
                    String category = scanner.nextLine();
                    System.out.print("Masukkan Harga Produk: ");
                    int price = scanner.nextInt(); 
                    petshop.addProduct(name, category, price); // Menambahkan produk baru
                    break;

                case 3:
                    // Mengambil ID produk yang ingin diedit
                    System.out.print("Masukkan ID Produk yang ingin diedit: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Masukkan Nama Baru: ");
                    String newName = scanner.nextLine();
                    System.out.print("Masukkan Kategori Baru: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Masukkan Harga Baru: ");
                    String priceInput = scanner.nextLine();
                    Integer newPrice = priceInput.isEmpty() ? null : Integer.parseInt(priceInput); 
                    petshop.updateProduct(productId, newName.isEmpty() ? null : newName,
                    newCategory.isEmpty() ? null : newCategory, newPrice); // Memperbarui produk
                    break;

                case 4:
                    // Menghapus produk berdasarkan Id
                    System.out.print("Masukkan ID Produk yang ingin dihapus: ");
                    int deleteId = scanner.nextInt();
                    petshop.deleteProduct(deleteId); 
                    break;

                case 5:
                    // Mencari produk berdasarkan nama                    
                    System.out.print("Masukkan nama produk yang dicari: ");
                    String searchName = scanner.nextLine();
                    petshop.searchProduct(searchName); 
                    break;

                case 6:
                    // Menampilkan pesan setelah keluar dari program
                    System.out.println("\n~Terima Kasih~");
                    System.out.println(" Good  Bye :)");
                    scanner.close(); 
                    return; 

                default:
                    // Menampilkan pesan jika pilihan tidak valid
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-6.");
            }
        }
    }
}
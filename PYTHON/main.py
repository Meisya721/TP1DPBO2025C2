from Petshop import PetShop  

def main():
    petshop = PetShop()  
    
    while True:  
        print("\nMenu:")
        print(" 1. Tampilkan Produk")
        print(" 2. Tambah Produk")
        print(" 3. Edit Produk")
        print(" 4. Hapus Produk")
        print(" 5. Cari Produk")
        print(" 6. Exit\n")
        
        choice = input("Masukkan Pilihan: ")  # Input pilihan dari user
        
        if choice == '1':
            # Menampilkan semua produk yang ada
            petshop.display_products()  
        
        elif choice == '2':
            # Mengambil informasi produk baru dari user
            name = input("Masukkan Nama Produk: ")
            category = input("Masukkan Kategori Produk: ")
            price = int(input("Masukkan Harga Produk: "))  
            petshop.add_product(name, category, price)  # Menambahkan produk baru
        
        elif choice == '3':
            # Mengambil ID produk yang ingin diedit
            product_id = int(input("Masukkan ID Produk yang ingin diedit: "))
            name = input("Masukkan Nama Baru: ")  
            category = input("Masukkan Kategori Baru: ")  
            price_input = input("Masukkan Harga Baru: ")  
            price = int(price_input) if price_input else None 
            petshop.update_product(product_id, name if name else None, category if category else None, price)

        elif choice == '4':
            # Mengambil ID produk yang ingin dihapus
            product_id = int(input("Masukkan ID Produk yang ingin dihapus: "))
            petshop.delete_product(product_id)  

        elif choice == '5':
            # Mengambil nama produk yang ingin dicari
            name = input("Masukkan nama produk yang dicari: ")
            petshop.search_product(name)  

        elif choice == '6':
            # Menampilkan pesan setelah keluar dari program
            print("\n~Terima Kasih~")  
            print("  Bye Bye :)")  
            break  

        else:
            # Menampilkan pesan jika pilihan tidak valid
            print("Pilihan tidak valid. Silakan pilih antara 1-6.")  

if __name__ == "__main__":
    main()
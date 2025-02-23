class PetShop:
    def __init__(self):
        # Inisialisasi daftar produk sebagai list kosong
        self.products = []
        
    # Getter untuk mendapatkan produk berdasarkan ID
    def get_product(self, product_id):
        for product in self.products:
            if product['id'] == product_id:
                return product
        return None

    # Metode untuk menampilkan semua produk
    def display_products(self):
        if not self.products:
            print("Tidak ada data produk.")
            return
        print("Daftar Produk:")
        for product in self.products:
            print(f"Id: {product['id']}, Nama: {product['name']}, Kategori: {product['category']}, Harga: Rp {product['price']}")

    # Metode untuk menambahkan produk baru
    def add_product(self, name, category, price):
        product_id = len(self.products) + 1
        new_product = {
            'id': product_id,
            'name': name,
            'category': category,
            'price': price
        }
        self.products.append(new_product)
        print(f"Produk '{name}' berhasil ditambahkan.")

    # Metode untuk memperbarui informasi produk/mengedit
    def update_product(self, product_id, name=None, category=None, price=None):
        for product in self.products:
            if product['id'] == product_id:
                if name is not None:
                    product['name'] = name
                if category is not None:
                    product['category'] = category
                if price is not None:
                    product['price'] = price
                print(f"Produk dengan ID {product_id} berhasil diperbarui.")
                return
        print(f"Produk dengan ID {product_id} tidak ditemukan.")

    # Metode untuk menghapus produk berdasarkan ID
    def delete_product(self, product_id):
        for product in self.products:
            if product['id'] == product_id:
                self.products.remove(product)
                print(f"Produk dengan ID {product_id} berhasil dihapus.")
                return
        print(f"Produk dengan ID {product_id} tidak ditemukan.")

    # Metode untuk mencari produk berdasarkan nama
    def search_product(self, name):
        found_products = [product for product in self.products if name.lower() in product['name'].lower()]
        if not found_products:
            print(f"Tidak ada produk yang ditemukan dengan nama '{name}'.")
            return
        print("Produk yang ditemukan:")
        for product in found_products:
            print(f"Id: {product['id']}, Nama: {product['name']}, Kategori: {product['category']}, Harga: Rp {product['price']}")
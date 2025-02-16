#include <iostream>
#include <string>

using namespace std;

class Product {
private:
    int id;
    string nama;
    string kategori;
    int harga;

public:
    Product() {}
    Product(int id, string nama, string kategori, int harga) {
        this->id = id;
        this->nama = nama;
        this->kategori = kategori;
        this->harga = harga;
    }

    int get_id() {
        return this->id;
    }

    void set_id(int id) {
        this->id = id;
    }

    string get_nama() {
        return this->nama;
    }

    void set_nama(string nama) {
        this->nama = nama;
    }

    string get_kategori() {
        return this->kategori;
    }

    void set_kategori(string kategori) {
        this->kategori = kategori;
    }

    int get_harga() {
        return this->harga;
    }

    void set_harga(int harga) {
        this->harga = harga;
    }

    ~Product()
    {
            
    }
};

class PetShop {
private:
    Product products[100];
    int productCount = 0;
    int nextId = 1;

public:
    void displayProducts();
    void addProduct(string nama, string kategori, int harga);
    void updateProduct(int id, string newnama, string newkategori, int newharga);
    void deleteProduct(int id);
    void searchProduct(string nama);
};

void PetShop::displayProducts() {
    if (productCount == 0) {
        cout << "Produk tidak ditemukan.\n";
        return;
    }
    cout << "\nList Produk:\n";
    for (int i = 0; i < productCount; i++) {
        cout << "ID: " << products[i].get_id() << ", nama: " << products[i].get_nama() << ", kategori: " << products[i].get_kategori() << ", harga: Rp " << products[i].get_harga() << endl;
    }
}

void PetShop::addProduct(string nama, string kategori, int harga) {
    if (productCount < 100) {
        products[productCount] = Product(nextId++, nama, kategori, harga);
        productCount++;
        cout << "Berhasil menambahkan produk.\n";
    } else {
        cout << "List Produk Penuh.\n";
    }
}

void PetShop::updateProduct(int id, string newnama, string newkategori, int newharga) {
    for (int i = 0; i < productCount; i++) {
        if (products[i].get_id() == id) {
            products[i].set_nama(newnama);
            products[i].set_kategori(newkategori);
            products[i].set_harga(newharga);
            cout << "Berhasil mengupdate produk.\n";
            return;
        }
    }
    cout << "Produk tidak ditemukan.\n";
}

void PetShop::deleteProduct(int id) {
    for (int i = 0; i < productCount; i++) {
        if (products[i].get_id() == id) {
            for (int j = i; j < productCount - 1; j++) {
                products[j] = products[j + 1];
            }
            productCount--;
            cout << "Berhasil menghapus produk.\n";
            return;
        }
    }
    cout << "Produk tidak ditemukan.\n";
}

void PetShop::searchProduct(string nama) {
    for (int i = 0; i < productCount; i++) {
        if (products[i].get_nama() == nama) {
            cout << "Found: ID: " << products[i].get_id() << ", nama: " << products[i].get_nama() << ", kategori: " << products[i].get_kategori() << ", harga: Rp " << products[i].get_harga() << endl;
            return;
        }
    }
    cout << "Produk tidak ditemukan.\n";
}


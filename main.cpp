#include <iostream>
#include "PetShop.cpp"

using namespace std;

int main() {
    PetShop shop;
    int choice;

    do {
        cout << "\n Sistem Pelayanan PetShop\n";
        cout << "1. Display Products\n2. Add Product\n3. Update Product\n4. Delete Product\n5. Search Product\n6. Exit\n";
        cout << "Masukkan pilihan: ";
        cin >> choice;

        switch (choice) {
            case 1:
                shop.displayProducts();
                break;
            case 2: {
                string nama, kategori;
                int harga;
                cout << "Masukkan nama: ";
                cin >> nama;
                cout << "Masukkan kategori: ";
                cin >> kategori;
                cout << "Masukkan harga: ";
                cin >> harga;
                shop.addProduct(nama, kategori, harga);
                break;
            }
            case 3: {
                int id;
                string nama, kategori;
                int harga;
                cout << "Masukkan ID produk untuk diupdate: ";
                cin >> id;
                cout << "Masukkan nama baru: ";
                cin >> nama;
                cout << "Masukkan kategori baru: ";
                cin >> kategori;
                cout << "Masukkan harga baru: ";
                cin >> harga;
                shop.updateProduct(id, nama, kategori, harga);
                break;
            }
            case 4: {
                int id;
                cout << "Masukkan ID produk untuk dihapus: ";
                cin >> id;
                shop.deleteProduct(id);
                break;
            }
            case 5: {
                string nama;
                cout << "Masukkan nama produk untuk dicari: ";
                cin >> nama;
                shop.searchProduct(nama);
                break;
            }
            case 6:
                cout << "~ Terima kasih ~\n";
                break;
            default:
                cout << "Input salah, silakan coba lagi.\n";
        }
    } while (choice != 6);

    return 0;
}
